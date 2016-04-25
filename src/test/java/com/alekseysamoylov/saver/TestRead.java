package com.alekseysamoylov.saver;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by alekseysamoylov on 4/25/16.
 */
public class TestRead {

    @Test
    public void readXmlTest() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(new SAXHandler());
        reader.parse(new InputSource(new FileReader("Orders.xml")));
}
}
