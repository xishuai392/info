package com.ztesoft.web.information.domain.req.scan;

public class ScanReqInfo {
	private String id;
	//申请人信息表主键uuid
	private String sqrxxId;
	//文件名
	private String fileName;
	//文件存放路径
	private String filePath;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSqrxxId() {
		return sqrxxId;
	}
	public void setSqrxxId(String sqrxxId) {
		this.sqrxxId = sqrxxId;
	}
	
	
}
