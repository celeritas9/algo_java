/**
 * 
 */
package com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author dshah
 *
 */
public class TestIO
{

	public static void main(String[] args) throws IOException
	{
		File f1 = new File("C:\\redknee\\test.txt");
		String directory = f1.getAbsolutePath().substring(0, f1.getAbsolutePath().lastIndexOf(f1.separator));
		
		System.out.println(directory);
		
		File f2 = new File(directory +f1.separator+ "test1.txt");
		System.out.println("isExists: "+f1.exists());
		FileOutputStream os = new FileOutputStream(f2);
		os.write(new String("abcc").getBytes());
		System.out.println(f2.getAbsolutePath());
		
		Integer.parseInt("");
	}
}
