package edu.hit.GithubDataPersistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.oracle.nio.BufferSecrets;

/**
 * 分割githubArchive中下载来的大数据 1、能够将大数据切割成小块 2、分析每一个小块中的数据，识别出所有我们所需要的行为的json
 * 
 * @author DHAO
 *
 */
public class DataCutter {

	/* 切割出的每个buffer大小,当前一次读取4M数据 */
	static int BUFFER_SIZE = 4 * 1024 * 1024;

	/*
	 * 截取的项目名称 private String program;
	 */
	/* 原始大文件的地址 */
	private String filePath;
	private long fileLength;
	private int offset = 0;
	/**
	 * 切割点的byte数组，用ASCII码翻译来是：}\回车\换行{
	 */
	byte[] cutPoint = { 125, 13, 10, 123 };
	private File file;
	private FileChannel fileChannel;
	private MappedByteBuffer in;
	/* 用于存放截取文件的片段 */
	private byte[] dst = new byte[BUFFER_SIZE];

	public DataCutter(String filePath)  {
		this.filePath = filePath;
		file = new File(filePath);
		fileLength = file.length();
		FileChannel fc;
		try {
			fc = new RandomAccessFile(file, "rw").getChannel();
			in = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileLength);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* 根据偏移量去切割数据,同时修改offset */
	private byte[] cut() {
		if (fileLength - offset >= BUFFER_SIZE) {
			for (int i = 0; i < BUFFER_SIZE; i++)
				dst[i] = in.get(offset + i);
		} else {
			for (int i = 0; i < fileLength - offset; i++)
				dst[i] = in.get(offset + i);
		}
		offset += BUFFER_SIZE;

		for (int i = dst.length - 3; i > -1; i--) {
			if (dst[i] == cutPoint[0]) {
				if (dst[i + 1] == cutPoint[1]) {
					if (dst[i + 2] == cutPoint[2]) {
						if (dst[i + 3] == cutPoint[3]) {
							/* 检测到分割点后将多余的偏移量移回 */
							offset -= dst.length - i;
							break;
						}
					}
				}
			}
		}
		return dst;
	}

	/*
	 * 接收得到的byte数组，过滤出我们想要的相关的项目的json
	 */
	public List<String> extractJsonData(String program) {

		List<String> resultList = new ArrayList<String>();

		int upFlag;
		int downFlag;
		int scannedFlag = 0;// 保存扫描过的位置的尾部，每一次找到新的json之后都更新一次

		String partition = new String(this.cut());

		Pattern pattern = Pattern.compile(program);// "https://github\\.com/"+
		Matcher matcher = pattern.matcher(partition);

		while (matcher.find()) {
			
			upFlag = matcher.start();
			downFlag = matcher.end();
			if (upFlag > scannedFlag) {
				System.out.println(matcher.group());
				System.out.println(matcher.start() + " " + matcher.end());
				while (true) {
					if ((dst[upFlag - 3] == 125) && (dst[upFlag - 2] == 13)
							&& (dst[upFlag - 1] == 10) && (dst[upFlag] == 123)) {
						break;
					} else {
						upFlag--;
					}
				}
				while (true) {
					if ((dst[downFlag + 3] == 123) && (dst[downFlag + 2] == 10)
							&& (dst[downFlag + 1] == 13)
							&& (dst[downFlag] == 125)) {
						break;
					} else {
						downFlag++;
					}
				}
				resultList.add(partition.substring(upFlag, downFlag + 1));
				scannedFlag = downFlag;
			}
		}

		return resultList;
	}

}
