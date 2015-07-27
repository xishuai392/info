package com.ztesoft.framework.util;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.thoughtworks.xstream.XStream;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description>XStream XML操作工具类 <br>
 */
public class XmlUtils {

    private final static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(XmlUtils.class);

    public static String bean2XML(Object bean) {
        XStream xstream = new XStream();
        return xstream.toXML(bean);
    }

    public static String bean2XML(Object bean, Class clazz) {
        XStream xstream = new XStream();
        xstream.aliasPackage("", clazz.getPackage().getName());
        return xstream.toXML(bean);
    }

    public static String beanList2XML(Object bean, Class clazz) {
        XStream xstream = new XStream();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.aliasPackage("", clazz.getPackage().getName());
        return xstream.toXML(bean);
    }

    public static String beanList2XML(Object bean) {
        XStream xstream = new XStream();
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(bean);
    }

    public static <T> List<T> xml2BeanList(String xml) {
        XStream xstream = new XStream();
        List<T> ret = (List<T>) xstream.fromXML(xml);
        return ret;
    }

    public static <T> T xml2Bean(String xml) {
        XStream xstream = new XStream();
        T ret = (T) xstream.fromXML(xml);
        return ret;
    }

    /**
     * 将对象序列化成xml
     * 
     * @param bean
     * @return
     */
    public static String serialize(Object bean) {
        Serializer serializer = new Persister();

        try {
            Writer writer = new StringWriter();
            serializer.write(bean, writer);
            return writer.toString();
        }
        catch (Exception e) {
            logger.error(e);
        }
        return "";
    }

    /**
     * 将xml反序列化
     * 
     * @param xml
     * @param clazz
     * @return
     */
    public static Object deserialize(String xml, Class clazz) {
        Serializer serializer = new Persister();
        try {
            return serializer.read(clazz, xml);
        }
        catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

}
