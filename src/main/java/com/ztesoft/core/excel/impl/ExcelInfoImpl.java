/**
 * 
 */
package com.ztesoft.core.excel.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ztesoft.core.excel.IExcelInfo;
import com.ztesoft.core.excel.PropertyAnnotation;

/**
 * <Description> 获取相应类实例的有效信息<br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.excel.impl <br>
 */
public class ExcelInfoImpl implements IExcelInfo {
    private Class clazz = null;

    // 有效属性个数
    private int num = 0;

    // 有效属性数组
    private List<String> propertys = new ArrayList<String>();

    // 有效属性信息数组
    List<String> propertyNames = new ArrayList<String>();

    // 需导出字段
    List<String> fieldsName = new ArrayList<String>();

    /**
     * 得到类实例
     * 
     * @param className
     * @param fieldsName
     */
    public ExcelInfoImpl(String className, List<String> fieldsName) {
        this.fieldsName = fieldsName;
        try {
            clazz = Class.forName(className);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.IExcelInfo#getHeaders()
     */
    @Override
    public List<String> getHeaders() {
        // 得到类实例的所有属性
        Field[] fields = clazz.getDeclaredFields();
        // 属性信息
        String propertyName = "";

        int PropertySortKey = 0;

        Map mapPropertys = new HashMap();

        Map mapPropertyNames = new HashMap();

        boolean flag = false;
        // 通过循环比较得到有效属性

        if (0 != this.fieldsName.size()) {
            for (int i = 0; i < fields.length; i++) {
                if (null == fields[i].getAnnotation(PropertyAnnotation.class)) {
                    continue;
                }
                propertyName = fields[i]
                        .getAnnotation(PropertyAnnotation.class).PropertyName();
                for (String str : fieldsName) {
                    if (str.equals(propertyName)) {
                        propertys.add(fields[i].getName());
                        propertyNames.add(propertyName);
                    }
                }
            }
        }
        else {
            // 通过循环比较得到有效属性
            for (int i = 0; i < fields.length; i++) {
                // 得到相应属性的信息
                if (null == fields[i].getAnnotation(PropertyAnnotation.class)) {
                    continue;
                }
                propertyName = fields[i]
                        .getAnnotation(PropertyAnnotation.class).PropertyName();
                PropertySortKey = fields[i].getAnnotation(
                        PropertyAnnotation.class).PropertySortKey();
                // 判断是否为有效属性
                if (null != propertyName) {
                    if (!flag) {
                        if (PropertySortKey == -1) {
                            if ("Unknown".equals(propertyName)) {
                                propertys.add(fields[i].getName());
                                propertyNames.add(fields[i].getName());
                            }
                            else {
                                propertys.add(fields[i].getName());
                                propertyNames.add(propertyName);
                            }
                        }
                        else {
                            flag = true;
                        }
                    }
                    if (flag) {
                        if ("Unknown".equals(propertyName)) {
                            mapPropertys.put(PropertySortKey,
                                    fields[i].getName());
                            mapPropertyNames.put(PropertySortKey,
                                    fields[i].getName());
                        }
                        else {
                            mapPropertys.put(PropertySortKey,
                                    fields[i].getName());
                            mapPropertyNames.put(PropertySortKey, propertyName);
                        }
                    }

                }
            }
            if (flag) {
                sortPropertys(mapPropertys, mapPropertyNames);
            }
        }
        return propertyNames;
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.IExcelInfo#getContent(java.lang.Object, java.lang.String)
     */
    @Override
    public String getContent(Object obj, String methodName) throws Exception {
        String realMethodName = "get"
                + methodName.substring(0, 1).toUpperCase()
                + methodName.substring(1);
        Method method = clazz.getMethod(realMethodName, new Class[] {});
        if (null == method.invoke(obj, new Object[] {})
                || "".equals(method.invoke(obj, new Object[] {}))) {
            return "";
        }
        else {
            return method.invoke(obj, new Object[] {}).toString();
        }
    }

    /**
     * 有效属性排序
     * 
     * @author: panxb
     * @param mapPropertys
     * @param mapPropertyNames
     */
    public void sortPropertys(Map mapPropertys, Map mapPropertyNames) {
        for (int i = 1; i <= mapPropertys.size(); i++) {
            propertys.add((String) mapPropertys.get(i));
            propertyNames.add((String) mapPropertyNames.get(i));
        }
    }

    /**
     * 获取有效属性数组
     * 
     * @return
     */
    public List<String> getPropertys() {
        return propertys;
    }

    /**
     * 获取有效属性信息
     * 
     * @return
     */
    public List<String> getPropertyNames() {
        return propertyNames;
    }

    /**
     * 获取有效属性个数
     * 
     * @return
     */
    public int getNum() {
        num = getPropertys().size();
        if (num == 0) {
            getHeaders();
            num = getPropertys().size();
        }
        return num;
    }
}
