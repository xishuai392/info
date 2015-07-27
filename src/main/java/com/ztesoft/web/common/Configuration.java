package com.ztesoft.web.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

public class Configuration {   
  
    private static CompositeConfiguration  config;   
    
    private Configuration() {  
    } 
    static {  
        if (config == null) {  
        	config = new CompositeConfiguration();  
        	try {
        		PropertiesConfiguration appConfiguration=new PropertiesConfiguration("config/props/appconfig.properties");
        		appConfiguration.setReloadingStrategy(new FileChangedReloadingStrategy());
        		appConfiguration.setAutoSave(true);
//        		PropertiesConfiguration errorCodeConfiguration=new PropertiesConfiguration("config/error_code/error_code_framework.properties");
//        		errorCodeConfiguration.setReloadingStrategy(new FileChangedReloadingStrategy());
//        		errorCodeConfiguration.setAutoSave(true);
				config.addConfiguration(appConfiguration);
//				config.addConfiguration(errorCodeConfiguration);
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }  
    }  


	public static boolean containsKey(String key) {   
  
        return config.containsKey(key);   
    }   
  
    public static BigDecimal getBigDecimal(String key) {   
        return config.getBigDecimal(key);   
    }   
  
    public static BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {   
        return config.getBigDecimal(key, defaultValue);   
    }   
  
    public static BigInteger getBigInteger(String key) {   
        return config.getBigInteger(key);   
    }   
  
    public static BigInteger getBigInteger(String key, BigInteger defaultValue) {   
        return config.getBigInteger(key, defaultValue);   
    }   
  
    public static boolean getBoolean(String key) {   
        return config.getBoolean(key);   
    }   
  
    public static boolean getBoolean(String key, boolean defaultValue) {   
        return config.getBoolean(key, defaultValue);   
    }   
  
    public static Boolean getBoolean(String key, Boolean defaultValue) {   
        return config.getBoolean(key, defaultValue);   
    }   
  
    public static byte getByte(String key) {   
        return config.getByte(key);   
    }   
  
    public static byte getByte(String key, byte defaultValue) {   
        return config.getByte(key, defaultValue);   
    }   
  
    public static Byte getByte(String key, Byte defaultValue) {   
        return config.getByte(key, defaultValue);   
    }   
  
    public static double getDouble(String key) {   
        return config.getDouble(key);   
    }   
  
    public static double getDouble(String key, double defaultValue) {   
        return config.getDouble(key, defaultValue);   
    }   
  
    public static Double getDouble(String key, Double defaultValue) {   
        return config.getDouble(key, defaultValue);   
    }   
  
    public static float getFloat(String key) {   
        return config.getFloat(key);   
    }   
  
    public static float getFloat(String key, float defaultValue) {   
        return config.getFloat(key, defaultValue);   
    }   
  
    public static Float getFloat(String key, Float defaultValue) {   
        return config.getFloat(key, defaultValue);   
    }   
  
    public static int getInt(String key) {   
        return config.getInt(key);   
    }   
  
    public static int getInt(String key, int defaultValue) {   
        return config.getInt(key, defaultValue);   
    }   
  
    public static Integer getInteger(String key, Integer defaultValue) {   
        return config.getInteger(key, defaultValue);   
    }   
  
    public static Iterator<String> getKeys(String prefix) {   
        return config.getKeys(prefix);   
    }   
  
    public static Iterator<String> getKeys() {   
        return config.getKeys();   
    }   
  
    public static List<Object> getList(String key) {   
        return config.getList(key);   
    }   
  
    public static List<Object> getList(String key, List<Object> defaultValue) {   
        return config.getList(key, defaultValue);   
    }   
  
    public static long getLong(String key) {   
        return config.getLong(key);   
    }   
  
    public static long getLong(String key, long defaultValue) {   
        return config.getLong(key, defaultValue);   
    }   
  
    public static Long getLong(String key, Long defaultValue) {   
        return config.getLong(key, defaultValue);   
    }   
  
    public static Properties getProperties(String key) {   
        return config.getProperties(key);   
    }   
  
    public static Object getProperty(String key) {   
        return config.getProperty(key);   
    }   
  
    public static short getShort(String key) {   
        return config.getShort(key);   
    }   
  
    public static short getShort(String key, short defaultValue) {   
        return config.getShort(key, defaultValue);   
    }   
  
    public static Short getShort(String key, Short defaultValue) {   
        return config.getShort(key, defaultValue);   
    }   
  
    public static String getString(String key) {   
        return config.getString(key);   
    }   
  
    public static String getString(String key, String defaultValue) {   
        return config.getString(key, defaultValue);   
    }   
  
    public static String[] getStringArray(String key) {   
        return config.getStringArray(key);   
    }   
  
    public static boolean isEmpty() {   
        return config.isEmpty();   
    }   
    
    public static void main(String[] args) {
		System.out.println(Configuration.getString("test"));
	}
  
}  