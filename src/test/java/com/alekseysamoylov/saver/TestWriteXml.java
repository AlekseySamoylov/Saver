package com.alekseysamoylov.saver;

import com.alekseysamoylov.saver.parsing.WriteOrdersToXML;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by alekseysamoylov on 4/25/16.
 */
public class TestWriteXml {

    @Test
    public void writeXml() throws XMLStreamException, IllegalAccessException, IntrospectionException, InvocationTargetException, IOException {
        new WriteOrdersToXML().writeOrders();
        try(FileInputStream fileInputStream = new FileInputStream("Orders.xml")){
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        String fin = br.readLine();
        System.out.println(fin);
    }
    }
}
