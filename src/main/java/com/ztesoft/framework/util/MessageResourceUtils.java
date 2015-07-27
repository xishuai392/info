package com.ztesoft.framework.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description>消息资源管理器 <br>
 * 
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年9月15日 <br>
 * @see com.ztesoft.framework.util <br>
 * @since V1.0<br>
 */

public class MessageResourceUtils {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(MessageResourceUtils.class);

    private static Locale locale = Locale.CHINA;

    private static ResourceBundleMessageSource resource = new ResourceBundleMessageSource();

    private MessageResourceUtils() {
    }

    private static Map<String, String> map = new HashMap<String, String>();

    static {

        ArrayList<String> baseNames = new ArrayList<String>();

        // resource.setBasenames(FrameWorkConstants.CONFIG_PROPERTIES_BASENAME,
        // FrameWorkConstants.ERORR_CODE_PROPERTIES_BASENAME);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        // 分别加载匹配的Resource，且通过ResourceLoader.getResource进行加载
        try {
            Resource[] config_resources = resolver.getResources("classpath:"
                    + FrameWorkConstants.CONFIG_PROPERTIES_BASENAME
                    + "/*.properties");

            Resource[] error_code_resources = resolver
                    .getResources("classpath:"
                            + FrameWorkConstants.ERORR_CODE_PROPERTIES_BASENAME
                            + "/*.properties");
            Resource[] props_resources = resolver.getResources("classpath:"
                    + FrameWorkConstants.PROPS_PROPERTIES_BASENAME
                    + "/*.properties");

            for (Resource resource : props_resources) {
                baseNames.add(FrameWorkConstants.PROPS_PROPERTIES_BASENAME
                        + "/"
                        + resource.getFilename().substring(0,
                                resource.getFilename().indexOf(".")));
            }
            for (Resource resource : error_code_resources) {
                baseNames.add(FrameWorkConstants.ERORR_CODE_PROPERTIES_BASENAME
                        + "/"
                        + resource.getFilename().substring(0,
                                resource.getFilename().indexOf(".")));
            }
            for (Resource resource : config_resources) {
                baseNames.add(FrameWorkConstants.CONFIG_PROPERTIES_BASENAME
                        + "/"
                        + resource.getFilename().substring(0,
                                resource.getFilename().indexOf(".")));
            }

        }
        catch (IOException e) {
            logger.error(e);
        }

        // 可以在这里增加多个配置文件
        resource.setBasenames((String[]) baseNames.toArray(new String[1]));
        resource.setDefaultEncoding(FrameWorkConstants.UTF_8_ENCODING);
    }

    /**
     * Description: 得到message <br>
     * 
     * @param key <br>
     * @return <br>
     */
    public static String getMessage(String key) {
        String resStr = map.get(key);
        if (StringUtils.isNotEmpty(resStr)) {
            return resStr;
        }
        resStr = getMessage(key, null);
        map.put(key, resStr);

        return resStr;
    }

    public static String getMessage(String key, Object[] args) {
        return getMessage(key, args, "");
    }

    public static String getMessage(String key, Object[] args,
            String defaultMessage) {
        return getMessage(key, args, defaultMessage, locale);
    }

    public static String getMessage(String key, Object[] args,
            String defaultMessage, Locale locale) {
        return resource.getMessage(key, args, defaultMessage, locale);
    }

    /**
     * Description: 清空缓存<br>
     */
    public static void clear() {
        map.clear();
    }

    public static void main(String[] args) {
        System.out.println("begin!!!");
        System.out.println(MessageResourceUtils.getMessage("APP-00-0001"));
        System.out.println(MessageResourceUtils.getMessage("APP-00-0002"));
        System.out.println(MessageResourceUtils.getMessage("APP-00-0003"));
        System.out.println("end!!!");
    }

}
