package com.ztesoft.framework.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.ztesoft.core.common.JsonObjectMapper;
import com.ztesoft.framework.log.ZTEsoftLogManager;

public class JsonUtil {

    public static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(JsonUtil.class);
    private static final JsonObjectMapper mapper=new JsonObjectMapper();


    /**
     * 字符串转为bean
     * 
     * @param content
     * @param valueType
     * @return
     */
    public static <T> T toBean(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    /**
     * 把JavaBean转换为json字符串 <br>
     * 普通对象转换： toJson(Student) <br>
     * List转换：toJson(List) <br>
     * Map转换:toJson(Map) <br>
     * 我们发现不管什么类型，都可以直接传入这个方法
     * 
     * @param object JavaBean对象
     * @return json字符串
     */
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    /**
     * 字符串转为List
     * 
     * @param object
     * @param T
     * @return
     */
    public static <T> List<T> toList(String content, Class<T> T) {
        try {
            JavaType javaType = mapper.getTypeFactory()
                    .constructParametricType(List.class, T);
            return mapper.readValue(content, javaType);
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    /**
     * 字符串转为Array
     * 
     * @param object
     * @param T
     * @return
     */
    public static <T> T[] toArray(String content, Class<T> T) {
        try {
            List<T> list = JsonUtil.toList(content, T);
            @SuppressWarnings("unchecked")
            T[] a = (T[]) java.lang.reflect.Array.newInstance(T, list.size());
            return list.toArray(a);
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    /**
     * List串转为Array
     * 
     * @param list
     * @param T
     * @return
     */
    public static <T> T[] toArray(List<T> list, Class<T> T) {
        try {
            @SuppressWarnings("unchecked")
            T[] a = (T[]) java.lang.reflect.Array.newInstance(T, list.size());
            return list.toArray(a);
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    /**
     * 字符串转为Map<String, Object>
     * 
     * @param content
     * @return
     */
    public static Map<String, Object> toMap(String content) {
        try {
            return mapper.readValue(content,
                    new TypeReference<Map<String, Object>>() {
                    });
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    /**
     * 对象转为Map<String, Object>
     * 
     * @param content
     * @return
     */
    public static Map<String, Object> toMap(Object object) {
        try {
            return mapper.convertValue(object,
                    new TypeReference<Map<String, Object>>() {
                    });
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public static <T, V> Map<T, V> toJavaMap(String jsonString,
            Class<T> keyClass, Class<V> valueClass) throws Exception {
        return mapper.readValue(jsonString, mapper.getTypeFactory()
                .constructMapLikeType(Map.class, keyClass, valueClass));
    }

    /**
     * @param response
     * @param list 要输出的数据
     * @param idKey tree的id字段,可以是多个字段的组合逗号分割
     * @param textKey tree的text
     * @param cssKey tree的图标样式
     * @param requestTreeNode 传入的tree参数对象
     * @throws JSONException
     */

    /**
     * 输出
     * 
     * @param response
     * @param map
     */
    public static void writeJson(HttpServletResponse response, Map<?, ?> map) {
        response.setContentType("application/json");
        response.setCharacterEncoding(FrameWorkConstants.UTF_8_ENCODING);
        PrintWriter print = null;
        try {
            print = response.getWriter();
        }
        catch (IOException e) {
            logger.error(e);
        }
        print.write(toJson(map).toString());
    }

    /**
     * 输出
     * 
     * @param response
     * @param map
     */
    public static void writeJson(HttpServletResponse response, Object object) {
        response.setContentType("application/json");
        response.setCharacterEncoding(FrameWorkConstants.UTF_8_ENCODING);
        PrintWriter print = null;
        try {
            print = response.getWriter();
        }
        catch (IOException e) {
            logger.error(e);
        }
        print.write(toJson(object).toString());
    }

}
