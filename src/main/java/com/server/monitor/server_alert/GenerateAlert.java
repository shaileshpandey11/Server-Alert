package com.server.monitor.server_alert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class used to check condition for generating alerts to user.
 * 
 */
public final class GenerateAlert {

	/**
	 * This method is used to check disk usage
	 * 
	 * Assumption: logs should not be null.
	 * 
	 * @param logs It contains logs data
	 * 
	 * @return case1: true if it meets alert condition which is if disk usage is
	 *         above 70% case2: false if it doesn't meet above requirement.
	 */
	public boolean alertBasedOnDiskUsage(String[] logs) {
		try {
			if ( logs != null) {
				double used_disk_space = Double.parseDouble(logs[4]);
				double total_disk_space = Double.parseDouble(logs[3]);

				// Calculating Disk Usage Percentage
				double result = used_disk_space / total_disk_space;
				result = result * 100;

				if (result > (AlertConstant.DISK_USAGE)) {
					return true;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: " + e.toString());
		}
		return false;

	}

	/**
	 * This method is used to check memory usage
	 * 
	 * Assumption: logs should not be null.
	 * 
	 * @param logs
	 *            It contains logs data
	 * @return case1: true if it meets alert condition which is if memory usage
	 *         is above 80% case2: false if it doesn't meet above requirement.
	 */
	public boolean alertBasedOnMemoryUsage(String[] logs) {
		try {
			if (logs != null) {
				double used_memory_space = Double.parseDouble(logs[6]);
				double total_memory_space = Double.parseDouble(logs[5]);

				// Calculating Memory Usage Percentage
				double result = used_memory_space / total_memory_space;
				result = result * 100;

				if (result > (AlertConstant.MEMORY_USAGE)) {
					return true;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: " + e.toString());
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * This method is used to write content on a file.
	 * 
	 * @param filepath File Name with Location
	 * @param content Content need to write on file
	 */
	public void writeAlertOnFile(String filepath, String content) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {

			bw.write(content);

			System.out.println("Done!");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
