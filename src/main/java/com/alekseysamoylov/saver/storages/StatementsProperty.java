package com.alekseysamoylov.saver.storages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class StatementsProperty implements MyProperties {
    @Override
    public Properties getProperties() {
        Properties properties = new Properties();
        try{
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("statements.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
