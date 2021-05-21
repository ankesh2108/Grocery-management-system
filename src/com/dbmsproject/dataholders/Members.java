package com.dbmsproject.dataholders;

public class Members {

	private int mem_id;
	private String memName;

	public Members(int mem_id, String memName) {
		this.mem_id = mem_id;
		this.memName = memName;
	}


	public int getMem_id() {
		return mem_id;
	}

	public String getMemName() {
		return memName;
	}
}
