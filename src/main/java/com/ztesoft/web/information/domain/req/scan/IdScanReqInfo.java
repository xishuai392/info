package com.ztesoft.web.information.domain.req.scan;

public class IdScanReqInfo {
	//文件日志记录表的uuid
	private String cxrzId;
	//文件名
	private String fileName;
	//文件存放路径
	private String filePath;
	public String getCxrzId() {
		return cxrzId;
	}
	public void setCxrzId(String cxrzId) {
		this.cxrzId = cxrzId;
	}
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
	
	
}
