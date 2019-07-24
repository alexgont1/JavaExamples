package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class testFileReadingWriting {

	public static void main(String[] args) throws IOException {
		
		//create file
		File file = new File("S:\\eclipse\\test.txt");
		file.createNewFile();
		
		//write inside a file
		FileWriter fw = new FileWriter("S:\\eclipse\\test.txt");
		BufferedWriter filewriter = new BufferedWriter(fw);
		
		filewriter.write("Please write inside this file");
		filewriter.newLine();
		filewriter.write("2nd line");		
		
		filewriter.close();
		
		//read from file
		FileReader fr = new FileReader("S:\\eclipse\\test.txt");
		BufferedReader freader = new BufferedReader(fr);
		
		//System.out.println(freader.readLine());
		//System.out.println(freader.readLine());//read 2nd line
		
		//OR CREATE LOOP:
		String i=null;
		
		while((i = freader.readLine())!=null) {
			System.out.println(i);
		}
		
		freader.close();

	}



}
