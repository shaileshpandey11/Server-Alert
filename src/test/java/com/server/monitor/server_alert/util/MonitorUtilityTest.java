package com.server.monitor.server_alert.util;

import static org.junit.Assert.assertNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;


public class MonitorUtilityTest {
	

	@Test
	public void testMonitorFolderWithPathNull() {
		assertNull("No folder is present to scan",MonitorUtility.monitorFolder(null)); ;	
	}

	@Test
	public void testGetPathWithException() {
		new MockUp<FileInputStream>() {
			 	@Mock
			    public void $init(String a) throws FileNotFoundException {
			        throw new FileNotFoundException();
			    }
		};
		assertNull("Exception occurred",MonitorUtility.getPath());
	}
}
