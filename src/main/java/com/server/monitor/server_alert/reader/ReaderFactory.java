package com.server.monitor.server_alert.reader;

/**
 * This class represents factory which will give object depend upon parameter.
 *
 */
public class ReaderFactory {

	// use getFile method to get object of type according to file extension
	public Reader getFile(String fileExtension) {
		if (fileExtension == null) {
			return null;
		}
		if (fileExtension.equalsIgnoreCase("CSV")) {
			return new CSVReader();

		} else if (fileExtension.equalsIgnoreCase("JSON")) {
			//return new JSONReader();

		} else if (fileExtension.equalsIgnoreCase("XML")) {
			//return new XMLReader();
		}

		return null;
	}
}
