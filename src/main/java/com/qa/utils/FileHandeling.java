package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileHandeling {

	
	 public static void main(String[] args) { 
		 // copyFile("Include/sample.pdf","Include/sample-copy.pdf");
		 printAllFileAndFolder();
	 }
	 

	public static void copyFile(String filePath, String outputFilePath) {

		File file = new File(System.getProperty("user.dir") + "/" + filePath);
		File outputFile = new File(System.getProperty("user.dir") + "/" + outputFilePath);

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			fos = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int i = 0;

		try {
			while ((i = fis.read()) != -1) {
				fos.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		System.out.println("File copy successfully");
	}

	/**
	 * 
	 */
	public static void printAllFileAndFolder() {
		File file = new File(System.getProperty("user.dir"));
		File projectDir[] = file.listFiles();

		Arrays.sort(projectDir);

		for (File e : projectDir) {
			if (e.isFile()) {
				System.out.println("File : " + e.getName());
			} else if (e.isDirectory()) {
				System.out.println("Folder : " + e.getName());
			} else if (e.isHidden()) {
				System.out.println("Hidden : " + e.getName());
			} else {
				System.out.println("Not Known : " + e.getName());
			}
		}

	}
}
