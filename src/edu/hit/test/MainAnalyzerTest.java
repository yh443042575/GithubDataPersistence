package edu.hit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hit.githubDataAnalyzer.MainAnalyzer;

public class MainAnalyzerTest {
/*
	@Test
	public void testStartAnalyze() {
		MainAnalyzer mainAnalyzer = new MainAnalyzer();
		mainAnalyzer.startAnalyze();				
	}*/

	public static void main(String args[]) throws InterruptedException{
		MainAnalyzer mainAnalyzer = new MainAnalyzer();
		mainAnalyzer.startAnalyze();
	}
	
}
