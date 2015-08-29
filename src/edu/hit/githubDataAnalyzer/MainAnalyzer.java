package edu.hit.githubDataAnalyzer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.hit.GithubDataPersistence.DataCutter;

/**
 * 解压文件，找到我们想要的相关项目的数据，
 * 并调用持久化函数将相对应的event持久化到数据库中
 * @author DHAO
 *
 */
public class MainAnalyzer {

	private ExecutorService exec = Executors.newFixedThreadPool(10);
	
	
	
}
/**
 * 负责解压文件，并且抽取我们想要的json，调度给相对的eventAnalyzer去解析
 * @author DHAO
 *
 */
class UnzipAndDispatcher implements Runnable{
	/*文件路径*/
	private String filePath;
	/*扫描初始日期*/
	private String startDate;
	/*扫描结束日期*/
	private String stopDate;

	public UnzipAndDispatcher(String filePath,String startDate, String stopDate) {
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.filePath = filePath;
	}

	
	private EventAnalyzer eventAnalyzer = new EventAnalyzer();
	
	private boolean flag = true;
	
	@Override
	public void run() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		/*将calendar设置为扫描截止时间*/
		try {
			calendar.setTime(sdf.parse(stopDate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*保留截止时间，用于while循环比较*/
		long stopDateMillis = calendar.getTimeInMillis();
		/*将calendar设置为扫描开始时间*/
		try {
			calendar.setTime(sdf.parse(startDate));
		} catch (ParseException e) {
			System.out.println("日期转换问题...");
			e.printStackTrace();
		}
		/*根据文件路径*/
		while(flag){
			String file = sdf.format(calendar.getTime());
			/*解压文件*/
			UnzipTool.doUncompressFile(file+".json.gz");
			/*对解压后的文件进行映射*/
			DataCutter dataCutter = new DataCutter(filePath+"/"+file);
			/*切割原始数据，获得跟项目有关的json*/
			List<String> jsonData = dataCutter.extractJsonData("jquery/jquery");
			/*循环解析json，将json数据进行持久化*/
			for(String json:jsonData){
				eventAnalyzer.analyzeJson(json);
			}
			
			if(calendar.getTimeInMillis()<stopDateMillis){
				/*如果没到指定日期，则继续分析下一个小时的数据*/
				calendar.setTimeInMillis(calendar.getTimeInMillis()+3600*1000);
			}else {
				flag = false;
			}
		}
		this.setFlag(false);
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStopDate() {
		return stopDate;
	}

	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}
