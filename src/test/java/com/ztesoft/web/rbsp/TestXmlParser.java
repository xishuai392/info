/**
 * 
 */
package com.ztesoft.web.rbsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.information.rbsp.InfoResultVO;
import com.ztesoft.web.information.rbsp.InfoXmlParser;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.rbsp <br>
 */

public class TestXmlParser {

    /**
     * @param args
     * @throws BaseAppException 
     */
    public static void main(String[] args) throws BaseAppException {
        String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                        +"<RBSPMessage>\n"
                        +"    <Version/>\n"
                        +"    <ServiceID>S35-00000016</ServiceID>                                 \n "
                        +"    <TimeStamp/>                                                        \n "
                        +"    <Validity/>                                                         \n "
                        +"    <Security>                                                          \n "
                        +"        <Signature Algorithm=\"\"/>                                     \n "
                        +"        <CheckCode Algorithm=\"\"/>                                     \n "
                        +"        <Encrypt/>                                                      \n "
                        +"    </Security>                                                         \n "
                        +"    <Method>                                                            \n "
                        +"        <Name>Query</Name>                                              \n "
                        +"        <Items>                                                         \n "
                        +"            <Item>                                                      \n "
                        +"                <Value Type=\"arrayOfArrayOf_string\">                  \n "
                        +"                    <Row>                                               \n "
                        +"                        <Data>000</Data>                                \n "
                        +"                        <Data/>                                         \n "
                        +"                        <Data/>                                         \n "
                        +"                        <Data/>                                         \n "
                        +"                        <Data/>                                         \n "
                        +"                        <Data/>                                         \n "
                        +"                        <Data/>                                         \n "
                        +"                        <Data/>                                         \n "
                        +"                    </Row>                                              \n "
                        +"                    <Row>                                               \n "
                        +"                        <Data>ZHSJC</Data>                              \n "
                        +"                        <Data>ZZXZ</Data>                               \n "
                        +"                        <Data>ZZSSX</Data>                              \n "
                        +"                        <Data>CSRQ</Data>                               \n "
                        +"                        <Data>MZ</Data>                                 \n "
                        +"                        <Data>XB</Data>                                 \n "
                        +"                        <Data>XM</Data>                                 \n "
                        +"                        <Data>ZJHM</Data>                               \n "
                        +"                    </Row>                                              \n "
                        +"                    <Row>                                               \n "
                        +"                        <Data>20150728145329</Data>                     \n "
                        +"                        <Data>湖北省咸宁市永楠路62号1幢405室</Data>     \n "
                        +"                        <Data>422301</Data>                             \n "
                        +"                        <Data>19400315</Data>                           \n "
                        +"                        <Data>1</Data>                                  \n "
                        +"                        <Data>0/未知的性别</Data>                       \n "
                        +"                        <Data>邱峡</Data>                               \n "
                        +"                        <Data>422301194003157646</Data>                 \n "
                        +"                    </Row>                                              \n "
                        +"                </Value>                                                \n "
                        +"            </Item>                                                     \n "
                        +"        </Items>                                                        \n "
                        +"    </Method>                                                           \n "
                        +"</RBSPMessage>                                                          \n ";     
        
        InfoResultVO xmlVO = InfoXmlParser.parserXML(xml);
        System.out.println(xmlVO);
        
        System.out.println("=====================================");
        
        
        String errorXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                +"<RBSPMessage>"
                +"    <Version/>"
                +"    <ServiceID>S35-00000016</ServiceID>"
                +"    <TimeStamp/>"
                +"    <Validity/>"
                +"    <Security>"
                +"        <Signature Algorithm=\"\"/>"
                +"        <CheckCode Algorithm=\"\"/>"
                +"        <Encrypt/>"
                +"    </Security>"
                +"    <Method>"
                +"        <Name>Query</Name>"
                +"        <Items>"
                +"            <Item>"
                +"                <Value Type=\"arrayOfArrayOf_string\">"
                +"                    <Row>"
                +"                        <Data>103</Data>"
                +"                        <Data>参数“返回结果数据项集”错误</Data>"
                +"                    </Row>"
                +"                </Value>"
                +"            </Item>"
                +"        </Items>"
                +"    </Method>"
                +"</RBSPMessage>";
        InfoResultVO errorXmlVO = InfoXmlParser.parserXML(errorXml);
        System.out.println(errorXmlVO);
        
        System.out.println("=====================================");
        
        
        String filePath="C://mvnLib//fail.xml";
        //String filePath="C://mvnLib//suc.xml";
        File file=new File(filePath);
        StringBuffer sbXml = new StringBuffer(); 
        
        try{
            InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                sbXml.append(lineTxt);
            }
            read.close();
            
            InfoResultVO vo = InfoXmlParser.parserXML(sbXml.toString());
            System.out.println(vo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
