/**
 * 
 */
package com.server.monitor.server_alert.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is used to read CSV file.
 *
 */
public class CSVReader implements Reader {

	/* (non-Javadoc)
	 * @see com.server.monitor.server_alert.reader.Reader#read(java.lang.String, java.lang.String)
	 */
	@Override
	public String[] read(String path,String fileName) {
		String[] server_logs =null;
		 try (BufferedReader br = new BufferedReader(new FileReader(path+fileName))) {
    		 String line="";
             while ((line = br.readLine()) != null) {

                 // use comma as separator
                 server_logs = line.split(",");
             }

         } catch (IOException e) {
             e.printStackTrace();
         }
		 return server_logs;
	}

}
