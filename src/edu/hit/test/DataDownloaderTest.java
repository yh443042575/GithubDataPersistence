package edu.hit.test;

import java.io.IOException;
import java.text.ParseException;

import edu.hit.GithubDataDownload.DataDownloader;

public class DataDownloaderTest {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		DataDownloader dataDownloader = new DataDownloader("127.0.0.1", 8087);
		dataDownloader.download("D://githubRawData", "2014-08-01", 153, 21);
		
	}

}
