package com.ztesoft.framework.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.log.ZTEsoftLogManager;

public class HtmlUtils {
    private final static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(HtmlUtils.class);
    
    /**
     * 用ISO-8859-1编码，再用UTF-8转码
     * 
     * @param str 需要解码的字符串
     * @return
     */
    public static String enCodeStr(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return new String(
                    str.getBytes(FrameWorkConstants.ISO_8859_1_ENCODING),
                    FrameWorkConstants.UTF_8_ENCODING);
        }
        catch (UnsupportedEncodingException e) {
            logger.error(e);
            return null;
        }
    }
}
