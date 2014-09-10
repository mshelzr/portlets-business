package com.ext.portlet.halcon.dto;

import java.io.File;

public class BeanFile {
	
	private String version="";
	private File file;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
}
