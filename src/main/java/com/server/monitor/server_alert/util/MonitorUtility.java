/**
 * 
 */
package com.server.monitor.server_alert.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;

/**
 * This Utility provides method to monitor folder.
 * 
 */
public class MonitorUtility {

	/**
	 * This method is used to scan folder if there is any file is created or modified.
	 * 
	 * Assumption: Path should not be null
	 * 
	 * @param path Folder Location
	 * @return File Name
	 */
	public static String monitorFolder(String path) {
		
		String fileName = null;
		if(path != null){
			// define a folder root
			Path myDir = Paths.get(path);
			try {
				//It watches registered objects for changes and events
				WatchService watcher = myDir.getFileSystem().newWatchService();

				//Registers the file located by this path with a watch service
				myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);

				boolean valid = true;
				// Continuously checking for an event 
				System.out.println("Going to scan folder");
				do {
					// Retrieves and removes next watch key, waiting if none are yet present.
					WatchKey watchKey = watcher.take();

					for (WatchEvent<?> event : watchKey.pollEvents()) {
						if (StandardWatchEventKinds.ENTRY_CREATE.equals(event
								.kind())) {
							fileName = event.context().toString();
							System.out.println("Log File Found");

						}
						if (StandardWatchEventKinds.ENTRY_MODIFY.equals(event
								.kind())) {
							fileName = event.context().toString();
							System.out.println("Log File Modified:");

						}
					}
					valid = watchKey.reset();
					break;
				} while (valid);

			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
			}
		}
		return fileName;
	}

	/**
	 * Get File Location by reading property file.
	 * 
	 * @return Path File actual location
	 */
	public static String getPath() {
		Properties prop = new Properties();
		String path = null;
		try (InputStream input = new FileInputStream(MonitorConstant.FILE_PATH
				+ MonitorConstant.PROPERTY_FILE_NAME)) {

			prop.load(input);
			path = prop.getProperty("path");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return path;
	}

	/**
	 * Get maximum thread limit by reading property file.
	 * 
	 * @return Max_Limit Thread Pool size
	 */
	public static String getMax_Limit() {
		Properties prop = new Properties();
		String path = null;
		try (InputStream input = new FileInputStream(MonitorConstant.FILE_PATH
				+ MonitorConstant.PROPERTY_FILE_NAME)) {

			prop.load(input);
			path = prop.getProperty("max_limit");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return path;
	}
}
