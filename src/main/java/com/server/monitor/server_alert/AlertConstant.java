package com.server.monitor.server_alert;

/**
 * This contain constant used to generate alert
 *
 */
public final class AlertConstant {
	
	public static final int DISK_USAGE=70;
	public static final int MEMORY_USAGE=80;
	public static final String ALERT_DISK_FILE_NAME="alert_disk.txt";
	public static final String ALERT_MEMORY_FILE_NAME="alert_mem.txt";
	public static final String ALERT_DISK_MESSAGE="ALERT! System disk usage is above 70%";
	public static final String ALERT_MEMORY_MESSAGE="ALERT! Memory usage is above 80%";
}
