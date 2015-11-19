package edu.hit.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

import edu.hit.githubDataAnalyzer.EventAnalyzer;

public class EventAnalyzerTest {

	@Test
	public void testAnalyzeJson() {
		try {
			File file = new File("D://CommitCommentEvent.txt");
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder stringBuilder = new StringBuilder();
			String s;
			while((s=bufferedReader.readLine())!=null){
				stringBuilder.append(s);
			}
			EventAnalyzer eventAnalyzer = new EventAnalyzer();
			//eventAnalyzer.analyzeJson(stringBuilder.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
