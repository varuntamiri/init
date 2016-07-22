package com.technoglitz.io;

import java.io.File;

public class DirectorySearch {
	public static void main(String[] args) {
		walkin(new File("C:\\Documents and Settings\\db2admin\\My Documents\\Dev\\workspace\\dva\\DVA_RRP_NEW_SH")); // Replace this with a suitable
																													// directory
	}

	/**
	 * Recursive function to descend into the directory tree and find all the files that end with ".mp3"
	 * 
	 * @param dir
	 *            A file object defining the top directory
	 **/
	public static void walkin(File dir) {
		File listFile[] = dir.listFiles();
		if (listFile != null) {
			for (File mainFile : listFile) {
				if (mainFile.isDirectory() && mainFile.getName().equals("CVS")) {
					File filesInCvs[] = mainFile.listFiles();
					for (File fileInCvs : filesInCvs) {
						fileInCvs.delete();
					}
					System.out.println(mainFile.getPath());
					System.out.println("Its delete status is:" + mainFile.delete());
				} else {
					walkin(mainFile);
				}
			}
		}
	}
}