package com.alekseysamoylov.saver;

import com.alekseysamoylov.saver.models.Orders;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Stack;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class SAXHandler extends DefaultHandler {

    Stack<Object> stack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        Object element;
        try{
            System.out.println(qName);
            System.out.println("com.alekseysamoylov.saver.models."+Character.toUpperCase(qName.charAt(0)) + qName.substring(1));

            element = Class.forName("com.alekseysamoylov.saver.models."+Character.toUpperCase(qName.charAt(0)) + qName.substring(1)).newInstance();
        } catch (Exception e) {
            element = new StringBuffer();
            System.out.println("Element StringBuffer!!!!!!");

        }

        stack.push(element);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String( ch, start, length);
        if(text.trim().length()==0){
            return;
        };
        ((StringBuffer)stack.peek()).append(text);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(stack.size()>1){
            Object element = stack.pop();
            try {
                setProperty(qName, stack.peek(), element);
            } catch (Exception e) {
                throw new SAXException("Error: ", e);
            }
        }
    }

    private void setProperty(String name, Object target, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);

        if (value instanceof StringBuffer){

            value = value.toString();
        }
        if ( field.getType() == Integer.class ){
            value = Integer.parseInt(value.toString());

        }
        if (field.getType() == Float.class){
            value = Float.parseFloat(value.toString());
        }


        if (field.getType() == value.getClass()) {
            field.setAccessible(true);
            field.set(target, value);
        }else if(Collection.class.isAssignableFrom(field.getType())) {
            Collection collection = (Collection) field.get(target);
            collection.add(value);
        }else{
            System.out.println("Невозможно установить свойство");
        }

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("AaAAAAAAAAAAAAAAAAAAAA");
        Orders orders = (Orders) stack.pop();
        System.out.println(orders);
    }
}
