package com.ztesoft.web.information.rbsp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author Alexia
 * 
 * Dom4j 解析XML文档
 */
public class Dom4jDemo  {

    public void parserXml() {
    	String fileName="C:\\mvnLib\\response.xml";
    	
        File inputXml = new File(fileName);
        System.out.println(inputXml.length());
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            Element root = document.getRootElement();
            //获取method级别
            for (Iterator i = root.elementIterator("Method"); i.hasNext();) {
                Element method = (Element) i.next();
              
                System.out.println(method.getName());
                for (Iterator<Element> j = method.elementIterator("Items"); j.hasNext();) {
                	Element items = j.next();
                	System.out.println(items.getName() + ":" + items.getText());
                	for(Iterator<Element> k=items.elementIterator("Item");k.hasNext();){
                		Element item=k.next();
                		for(Iterator<Element> l=item.elementIterator("Value");l.hasNext();){
                			Element Value=l.next();
                			for(Iterator<Element> m=Value.elementIterator("Row");m.hasNext();){
                				Element row=m.next();
                				for(Iterator<Element> n=row.elementIterator("Data");n.hasNext();){
                					Element data=n.next();
                				   System.out.println(data.getStringValue());	
                				}
                				
                				//解析行值。
                				
                			}
                		}
                	}
                   
                }
            }
            
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    public static void main(String[] args) {
		new Dom4jDemo().parserXml();
	}
}