package com.technoglitz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// TODO: Auto-generated Javadoc
/**
 * Hello world!.
 */
public class TestMain 
{
    
    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException
    {
    	int i=2147483647;
        System.out.println( "Hello World!" +i);
		File imagePDF = new File(
				"C:\\Documents and Settings\\db2admin\\My Documents\\Dev\\springsource\\vfabric-tc-server-developer-2.7.0.RELEASE\\share\\wtpwebapps\\DVA_RRP_WAR\\"
						+ "\\temp\\" + "batch_231" + ".log");
		new FileOutputStream(imagePDF);

    }
}
