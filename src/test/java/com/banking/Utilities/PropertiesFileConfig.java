package com.banking.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class PropertiesFileConfig {
  
    public static String getKey(String key) throws Throwable {
    	File f=new File("./property/config.properties");
    	FileInputStream  fi= new FileInputStream(f);
    	Properties po =new Properties();
    	po.load(fi);
    	return po.getProperty(key);
    }
	
}
