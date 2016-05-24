/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyProvider {
	private static final Logger LOG = LoggerFactory.getLogger(PropertyProvider.class);
	
	private static Properties properties;
	
	static {
		properties = new Properties ();
		try {
			properties.load(PropertyProvider.class.getResourceAsStream("/General.properties"));
		} catch (IOException e) {
			LOG.error("IOException: " + e, e);
		}
	}
	
	public static String getProperty(final String key) {
		return properties.getProperty(key);
	}
	
	public static Object setProperty(String key, String value) {
		return properties.setProperty(key, value);
	}
}
