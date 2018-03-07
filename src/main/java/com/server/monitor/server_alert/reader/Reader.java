/**
 * 
 */
package com.server.monitor.server_alert.reader;

/**
 * Reader Interface
 *
 */
public interface Reader {

	/**
	 * This method is used to read file from given location.
	 * 
	 * @param path Path from where you want to read file
	 * @param fileName File Name
	 * @return String Array that contains data after reading file.
	 */
	String[] read(String path,String fileName);
}
