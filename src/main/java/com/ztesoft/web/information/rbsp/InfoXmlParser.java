/**
 * 
 */
package com.ztesoft.web.information.rbsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.rbsp <br>
 */

public class InfoXmlParser {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(InfoXmlParser.class);

    public static InfoResultVO parserXML(String xml) {
        SAXReader saxReader = new SAXReader();
        List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
        InfoResultVO resultVO = new InfoResultVO();
        resultVO.setTargetXml(xml);
        try {
            Document document = saxReader.read(xml);
            Element root = document.getRootElement();
            // 获取method级别
            for (Iterator i = root.elementIterator("Method"); i.hasNext();) {
                Element method = (Element) i.next();
                logger.debug(method.getName());
                for (Iterator<Element> j = method.elementIterator("Items"); j.hasNext();) {
                    Element items = j.next();
                    logger.debug(items.getName() + ":" + items.getText());
                    for (Iterator<Element> k = items.elementIterator("Item"); k.hasNext();) {
                        Element item = k.next();
                        for (Iterator<Element> l = item.elementIterator("Value"); l.hasNext();) {
                            Element Value = l.next();

                            int rowIndex = 0;// Row的索引
                            for (Iterator<Element> m = Value.elementIterator("Row"); m.hasNext();) {
                                Element row = m.next();
                                Map<String, String> mapRow = new HashMap<String, String>();
                                int dataIndex = 0;// Data的索引

                                if (0 == rowIndex) {
                                    // 第一行，获取返回值
                                    boolean isSuc = false;// 是否请求成功

                                    for (Iterator<Element> n = row.elementIterator("Data"); n.hasNext();) {
                                        Element data = n.next();
                                        logger.debug("First Row:"+ data.getStringValue());
                                        if (0 == dataIndex) {
                                            // targetCode:返回的应答码
                                            resultVO.setTargetCode(data.getStringValue());
                                            if ("000".equals(data.getStringValue())) {
                                                isSuc = true;
                                            }
                                            dataIndex++;
                                            continue;
                                        }

                                        if (!isSuc && 1 == dataIndex) {
                                            // 如果不成功，则去错误描述
                                            resultVO.setTargetMsg(data.getStringValue());
                                            dataIndex++;
                                            continue;
                                        }

                                        dataIndex++;
                                    }
                                    rowIndex++;
                                    continue;
                                }

                                if (1 == rowIndex) {
                                    // 第二行，如果有的话，证明是返回成功查询到的数据的，第二行是字段

                                    String fieldStr = "";

                                    for (Iterator<Element> n = row.elementIterator("Data"); n.hasNext();) {
                                        Element data = n.next();
                                        fieldStr += data.getStringValue() + ",";
                                        dataIndex++;
                                    }

                                    fieldStr = fieldStr.substring(0,fieldStr.length() - 1);
                                    resultVO.setTargetFields(fieldStr.split(","));

                                    logger.debug("Second Row:" + fieldStr);
                                    rowIndex++;
                                    continue;
                                }

                                for (Iterator<Element> n = row.elementIterator("Data"); n.hasNext();) {
                                    Element data = n.next();
                                    mapRow.put(
                                            resultVO.getTargetFields()[dataIndex],
                                            data.getStringValue());
                                    
                                    logger.debug("Row_Column[" + (rowIndex + 1) + "," + (dataIndex + 1) + "]:"
                                            + data.getStringValue());
                                    dataIndex++;
                                }
                                // 往list填充数据
                                rowList.add(mapRow);

                                rowIndex++;
                            }
                        }
                    }

                }
            }

            resultVO.setTargetDatas(rowList);
        }
        catch (Exception e) {
            logger.error("解析XML发生错误", e);
        }
        return resultVO;
    }

    public static List<Map<String, String>> parserResultVO(InfoResultVO infoResultVO) {
        if(!"000".equals(infoResultVO.getTargetCode())){
            //异常
            throw new RuntimeException(infoResultVO.getTargetMsg());
        }
        return infoResultVO.getTargetDatas();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
