package com.alekseysamoylov.saver;

import com.alekseysamoylov.saver.models.Operation;
import com.alekseysamoylov.saver.models.Order;
import com.alekseysamoylov.saver.parsing.ReadOrdersFromDB;
import com.alekseysamoylov.saver.xmlModels.Orders;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by alekseysamoylov on 4/25/16.
 */
public class WestWriteXml {

    @Test
    public void writeXml() throws XMLStreamException, IllegalAccessException, IntrospectionException, InvocationTargetException, IOException {
        Orders orders = new ReadOrdersFromDB().getOrders();


        StringWriter stringWriter = new StringWriter();

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);

        xmlStreamWriter.writeStartDocument("UTF-8");
        //<orders>
        xmlStreamWriter.writeStartElement(orders.getClass().getName().substring(36));

        for(Order order: orders.getOrderList()){
            //<Order>
            xmlStreamWriter.writeStartElement(order.getClass().getName().contains("com.alekseysamoylov.saver.models.")? order.getClass().getName().substring(33) : order.getClass().getName());

            perebor(xmlStreamWriter, order);
            xmlStreamWriter.writeEndElement();

        }
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();

        xmlStreamWriter.flush();
        xmlStreamWriter.close();

        String fin = stringWriter.getBuffer().toString();
        FileWriter fileWriter = new FileWriter("Orders.xml");
        fileWriter.write(fin);



    }

    public void perebor(XMLStreamWriter xmlStreamWriter, Object object) throws XMLStreamException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        for(Field field : object.getClass().getDeclaredFields()){
            //<id><...
            xmlStreamWriter.writeStartElement(field.getName());
            //If we find OperationList List<Operation>
            if(field.getName().equals("operationList")){
                for(Operation operation : (List<Operation>)new PropertyDescriptor(field.getName(), object.getClass()).getReadMethod().invoke(object)) {
                    xmlStreamWriter.writeStartElement(operation.getClass().getName().substring(33));
                    perebor(xmlStreamWriter, operation);
                    xmlStreamWriter.writeEndElement();
                }
            }
            //if we find class from Models
            else if(field.getType().toString().contains("com.alekseysamoylov.saver.models."))
            {
                perebor(xmlStreamWriter, new PropertyDescriptor(field.getName(), object.getClass()).getReadMethod().invoke(object));
            }
            //if we find primitive field of object
            else
            {
                try {
                    xmlStreamWriter.writeCharacters(new PropertyDescriptor(field.getName(), object.getClass()).getReadMethod().invoke(object).toString());
                }catch (NullPointerException e){
                    xmlStreamWriter.writeCharacters("Null");
                }
            }
                xmlStreamWriter.writeEndElement();
        }
    }
}
