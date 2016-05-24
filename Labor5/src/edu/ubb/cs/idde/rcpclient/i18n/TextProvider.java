package edu.ubb.cs.idde.rcpclient.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import edu.ubb.cs.idde.rcpclient.util.PropertyProvider;

public class TextProvider {
	private static final String BUNDLE_NAME = "SwingLabels";
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

	public static String getValue(final String key) {
		try {
			return new String (resourceBundle.getString(key).getBytes(), PropertyProvider.getProperty("encoding"));
		} catch (final MissingResourceException e) {
			return '!' + key + '!';
		} catch (final UnsupportedEncodingException e) {
			return resourceBundle.getString(key);
		}
	}
	
	public static void setLocale(final Locale locale) {
		resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
	}
	
	public static Locale getLocale() {
		return resourceBundle.getLocale();
	}
}
