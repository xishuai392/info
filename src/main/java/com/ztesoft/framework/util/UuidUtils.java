package com.ztesoft.framework.util;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class UuidUtils {
	
	public static String generatorUUID(){
		UUID uuid=UUID.randomUUID();
		String uuidStr=uuid.toString();
		return StringUtils.replace(uuidStr, "-", "");
	}
	public static void main(String[] args) {
		String str=UuidUtils.generatorUUID();
		System.out.println(str);
	}
}
