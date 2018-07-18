package com.pere.OverviewTestNG;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { com.pere.OverviewTestNG.NewTest.class });
		testng.addListener(tla);
		testng.run();
	}
}
