package edu.hit.test;

import java.io.IOException;

import edu.hit.GithubDataPersistence.DataCutter;

public class DataCutterTest {

	public static void main(String[] args) throws IOException {
		DataCutter dataCutter = new DataCutter("G://githubTest//githubJson.txt");
		
		dataCutter.extractJsonData("isaacs/node-tap");
		
	}

}
