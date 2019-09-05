package com.ddf2.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ddf2.base.TestBase;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(TestBase.configPath);
		config.load(fis);
		Properties or = new Properties();
		fis = new FileInputStream(TestBase.orPath);
		or.load(fis);

		System.out.println(config.getProperty("browser"));
		System.out.println(or.getProperty("customerLoginBtn"));

	}

}
