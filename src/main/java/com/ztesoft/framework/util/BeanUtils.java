package com.ztesoft.framework.util;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

/**
 * bean操作辅助类，如对象拷贝等
 */
public class BeanUtils {

    // 拷贝实例map
    private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<String, BeanCopier>();

    /**
     * 对象拷贝
     * 
     * @param source
     * @param target
     * @param overFlag ,true，覆盖原有值，false不覆盖，
     */
    public static void copyProperties(Object source, Object target,
            boolean overFlag) {
        // 组合主键
        String compKey = source.getClass().getName()
                + target.getClass().getName();
        BeanCopier copier = beanCopierMap.get(compKey);
        if (copier == null) {
            copier = BeanCopier.create(source.getClass(), target.getClass(),
                    !overFlag);
            beanCopierMap.put(compKey, copier);
            // synchronized (beanCopierMap) {
            // beanCopierMap.put(compKey, copier);
            // }
        }
        Converter converter = null;
        // 不覆盖拷贝
        if (!overFlag) {
            converter = new CustomConverter(target);
        }
        copier.copy(source, target, converter);
    }

    /**
     * 默认全量拷贝
     * 
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, true);
    }

    /**
     * 支持对象间值拷贝（不同类型则以属性名相同时映射）
     * 
     * @param orig
     * @param clazzT
     * @return
     */
    public static <T> T copy(Object orig, Class<T> clazzT) {
        try {
            T dest = clazzT.newInstance();

            if (orig == null) {
                return null;
            }

            PropertyDescriptor[] origDescriptors = PropertyUtils
                    .getPropertyDescriptors(orig);
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                if ("class".equals(name)) {
                    continue;
                }
                Object value = null;
                if (PropertyUtils.isReadable(orig, name)
                        && PropertyUtils.isWriteable(dest, name)) {
                    value = PropertyUtils.getSimpleProperty(orig, name);
                    PropertyUtils.setSimpleProperty(dest, name, value);
                }
            }
            return dest;
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * List值拷贝
     * 
     * @param origList
     * @param clazzT
     * @return
     */
    public static <T> List<T> copy(List<?> origList, Class<T> clazzT) {
        try {
            List<T> destList = new ArrayList<T>();
            if (origList == null || origList.size() <= 0) {
                return null;
            }

            for (int i = 0; i < origList.size(); i++) {
                destList.add(copy(origList.get(i), clazzT));
            }
            return destList;

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
