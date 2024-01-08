package com.loop.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this class is designed to read properties file and send the data source code
 */
public class ConfigurationReader {

    public static Properties properties;

    static{
        try{
            String path = "configuration.properties";
            FileInputStream input =new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String getproperty(String keyname){
        return properties.getProperty(keyname);
    }

}
