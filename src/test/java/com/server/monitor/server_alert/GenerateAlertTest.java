package com.server.monitor.server_alert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GenerateAlertTest {

	private static GenerateAlert alert = new GenerateAlert();
	
	final String[] mockStrArr = {"2","3","2","500","370","1024","980","3"};
	
	@Test
	public void testAlertBasedOnDiskUsageWithNull() {
		assertFalse(alert.alertBasedOnDiskUsage(null));
	}

	@Test
	public void testAlertBasedOnDiskUsage() {
		assertTrue(alert.alertBasedOnDiskUsage(mockStrArr));
	}
	
	@Test
	public void testAlertBasedOnMemoryUsageWithNull() {
		assertFalse(alert.alertBasedOnMemoryUsage(null));
	}

	@Test
	public void testAlertBasedOnMemoryUsage() {
		assertTrue(alert.alertBasedOnMemoryUsage(mockStrArr));
	}

}
