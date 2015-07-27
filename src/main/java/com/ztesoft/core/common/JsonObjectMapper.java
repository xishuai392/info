package com.ztesoft.core.common;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonObjectMapper extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JsonObjectMapper() {
		super();
//		this.enable(SerializationFeature.INDENT_OUTPUT);//设置输出换行
		this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		this.getSerializationConfig().withSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		this.setVisibility(PropertyAccessor.GETTER, Visibility.PUBLIC_ONLY);
		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		

	}

}
