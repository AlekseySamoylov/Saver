package com.alekseysamoylov.saver;

import com.alekseysamoylov.saver.storages.JDBConnection;
import com.alekseysamoylov.saver.storages.StatementsProperty;
import com.sun.xml.internal.stream.XMLOutputFactoryImpl;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.*;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class TestConnection {

    @Test
    public void readXml(){

    }


    @Test
    public void connect(){
        try(Connection connection = new JDBConnection().getConnection()){
            System.out.println(new StatementsProperty().getProperties().getProperty("getAllMasters"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    new StatementsProperty().getProperties().getProperty("getAllMasters"));
            try {
                StringWriter stringWriter = new StringWriter();

                XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
                XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);

                xmlStreamWriter.writeStartDocument("UTF-8");
                xmlStreamWriter.writeStartElement("slesars");
                while (resultSet.next()){
                    xmlStreamWriter.writeStartElement("slesar");
                    System.out.println(resultSet.getString("name"));

                        xmlStreamWriter.writeStartElement("id");
                        xmlStreamWriter.writeCharacters(resultSet.getString(1));
                        xmlStreamWriter.writeEndElement();

                        xmlStreamWriter.writeStartElement("name");
                        xmlStreamWriter.writeCharacters(resultSet.getString("name"));
                        xmlStreamWriter.writeEndElement();

                        xmlStreamWriter.writeStartElement("phone");
                        xmlStreamWriter.writeCharacters(resultSet.getString("phone"));
                        xmlStreamWriter.writeEndElement();

                    xmlStreamWriter.writeEndElement();
                }

                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndDocument();

                xmlStreamWriter.flush();
                xmlStreamWriter.close();

                String end = stringWriter.getBuffer().toString();
                System.out.println(end);

                FileWriter fileWriter = new FileWriter("masters.xml");
                fileWriter.write(stringWriter.getBuffer().toString());

                //CLOSE ALL!!!!
                fileWriter.close();
                stringWriter.close();

            } catch (XMLStreamException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
