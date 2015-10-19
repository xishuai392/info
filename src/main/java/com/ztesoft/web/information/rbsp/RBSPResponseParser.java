package com.ztesoft.web.information.rbsp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * RBSP xml解析器
 * 
 * @author Ocean
 *
 */
public class RBSPResponseParser   {
	private static final ZTEsoftLogManager logger =ZTEsoftLogManager.getLogger(RBSPResponseParser.class);
	private String xmlresponse;
	public RBSPResponseParser(String xml){
		this.xmlresponse=xml;
	}
	public List<Map<String,String>> parserXML(String[] paramInfoArr){
		SAXReader saxReader = new SAXReader();
		List<Map<String, String>> rowList=new ArrayList<Map<String,String>>();
        try {
            Document document = saxReader.read(xmlresponse);
            //Document document = DocumentHelper.parseText(xmlresponse); 
            Element root = document.getRootElement();
            //获取method级别
            for (Iterator i = root.elementIterator("Method"); i.hasNext();) {
                Element method = (Element) i.next();      
                logger.debug(method.getName());
                for (Iterator<Element> j = method.elementIterator("Items"); j.hasNext();) {
                	Element items = j.next();
                	logger.debug(items.getName() + ":" + items.getText());
                	for(Iterator<Element> k=items.elementIterator("Item");k.hasNext();){
                		Element item=k.next();
                		for(Iterator<Element> l=item.elementIterator("Value");l.hasNext();){
                			Element Value=l.next();
                			
                			int rowIndex = 0;//Row的索引
                			for(Iterator<Element> m=Value.elementIterator("Row");m.hasNext();){
                				Element row=m.next();
                				Map<String,String> mapRow=new HashMap<String, String>();
                				int count=0;
                				int dataIndex = 0;//Data的索引
                				for(Iterator<Element> n=row.elementIterator("Data");n.hasNext();){
                					Element data=n.next();
                					if(count>=paramInfoArr.length){
                						logger.error("parser xmlResponse may be error.please check it .responseXML:"+xmlresponse);
                						break;
                						
                						
                					}
                					mapRow.put(paramInfoArr[count],data.getStringValue());
                					count++;
                					
                				    logger.debug(data.getStringValue());	
                				}
                				//往list填充数据
                				rowList.add(mapRow);
                				
                				//解析行值。
                				
                				
                				rowIndex ++;
                			}
                		}
                	}
                   
                }
            }
            
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return rowList;
	}
	public static void main(String[] args) {
		String filePath="B://response.xml";
		File file=new File(filePath);
		String xml=file.toString();
		RBSPResponseParser parser=new RBSPResponseParser(xml);
		parser.parserXML(args);
		
	}
	
}
