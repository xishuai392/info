/**
 * 
 */
package com.ztesoft.web.information.rbsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ztesoft.framework.dto.AbstractDto;

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

public class InfoResultVO extends AbstractDto {
    private String targetXml;// 待解析的XML

    private String[] targetFields;// 解析出来的字段数组

    private List<Map<String, String>> targetDatas = new ArrayList<Map<String, String>>();

    private String targetCode;// 返回的应答码

    private String targetMsg;// 返回的消息文本

    /**
     * @return the targetXml
     */
    public String getTargetXml() {
        return targetXml;
    }

    /**
     * @param targetXml the targetXml to set
     */
    public void setTargetXml(String targetXml) {
        this.targetXml = targetXml;
    }

    /**
     * @return the targetFields
     */
    public String[] getTargetFields() {
        return targetFields;
    }

    /**
     * @param targetFields the targetFields to set
     */
    public void setTargetFields(String[] targetFields) {
        this.targetFields = targetFields;
    }

    /**
     * @return the targetDatas
     */
    public List<Map<String, String>> getTargetDatas() {
        return targetDatas;
    }

    /**
     * @param targetDatas the targetDatas to set
     */
    public void setTargetDatas(List<Map<String, String>> targetDatas) {
        this.targetDatas = targetDatas;
    }

    /**
     * @return the targetCode
     */
    public String getTargetCode() {
        return targetCode;
    }

    /**
     * @param targetCode the targetCode to set
     */
    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    /**
     * @return the targetMsg
     */
    public String getTargetMsg() {
        return targetMsg;
    }

    /**
     * @param targetMsg the targetMsg to set
     */
    public void setTargetMsg(String targetMsg) {
        this.targetMsg = targetMsg;
    }

}
