package com.getconfidetails;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigDetails {
    private static Properties properties;
    public boolean loadProperties(){
        boolean status = true;
        try
        {
            System.out.println("Load properties in Read configdetails");
            File f = new File("Configurations.properties");
            FileInputStream  fis = new FileInputStream(f);
            properties= new Properties();
            properties.load(fis);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            status=false;

        }
        return status;


    }
    public String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}

