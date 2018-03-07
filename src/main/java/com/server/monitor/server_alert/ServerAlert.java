package com.server.monitor.server_alert;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.server.monitor.server_alert.reader.Reader;
import com.server.monitor.server_alert.reader.ReaderFactory;
import com.server.monitor.server_alert.util.MonitorUtility;

/**
 * This is main class to get server alerts.
 * 
 */
public class ServerAlert {
	public static void main(String[] args) {

		System.out.println("Checking Server Logs");
		// This is used in order to limit thread
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(Integer.valueOf(MonitorUtility
						.getMax_Limit()));
		// This used to run periodically
		ScheduledFuture<?> scheduledFuture = scheduledExecutorService
				.scheduleAtFixedRate(new Runnable() {

					public void run() {
						// Scan folder for any file and get file name
						String fileName = MonitorUtility
								.monitorFolder(MonitorUtility.getPath());
						System.out.println("Server Log File Name: " + fileName);
						if (fileName == null) {
							System.out.println("No file is present to process");
						} else {
							ReaderFactory factory = new ReaderFactory();
							String extension = getFileExtension(fileName);
							// Get File Extension
							Reader reader = factory.getFile(extension);
							long currentProcessTime = System.currentTimeMillis();
							// Read file
							String[] server_logs = reader.read(
									MonitorUtility.getPath(), fileName);
							// Check and alert
							GenerateAlert alert = new GenerateAlert();
							
							System.out.println("Going to alert");
							
							// Checking for Disk Usage
							boolean isAlertBasedOnDiskUsage = alert
									.alertBasedOnDiskUsage(server_logs);

							// Checking for Memory Usage
							boolean isAlertBasedOnMemoryUsage = alert
									.alertBasedOnMemoryUsage(server_logs);

							if (isAlertBasedOnDiskUsage) {
								alert.writeAlertOnFile(MonitorUtility.getPath()
										+ AlertConstant.ALERT_DISK_FILE_NAME,
										AlertConstant.ALERT_DISK_MESSAGE);
							} 
							if (isAlertBasedOnMemoryUsage) {
								alert.writeAlertOnFile(MonitorUtility.getPath()
										+ AlertConstant.ALERT_MEMORY_FILE_NAME,
										AlertConstant.ALERT_MEMORY_MESSAGE);
							}else {
								System.out.println("Everything is fine!!");
							}
							long totalProcessTime = System.currentTimeMillis()-currentProcessTime;
							System.out.println("Total Processing Time:"+totalProcessTime);
						}

					}
				}, 5, 5, TimeUnit.SECONDS);
		scheduledFuture.isCancelled();
	}

	/**
	 * This method is used to get file extension
	 * 
	 * @param file
	 *            File Name
	 * @return File Extension
	 */
	private static String getFileExtension(String file) {
		if (file.lastIndexOf(".") != -1 && file.lastIndexOf(".") != 0)
			return file.substring(file.lastIndexOf(".") + 1);
		else
			return "";
	}
}
