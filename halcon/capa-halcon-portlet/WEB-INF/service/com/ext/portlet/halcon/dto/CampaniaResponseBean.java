package com.ext.portlet.halcon.dto;

import java.util.ArrayList;
import java.util.List;

public class CampaniaResponseBean {

	private List<CampaniaBean> campanias;
	
	public CampaniaResponseBean(){
		this.campanias = new ArrayList<CampaniaBean>();
	}
	
	public List<CampaniaBean> getCampanias() {
		return campanias;
	}

	public void setCampanias(List<CampaniaBean> campanias) {
		this.campanias = campanias;
	}



}
