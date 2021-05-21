package com.dbmsproject.dataholders;

public class DataForPieChart {

	private String name;
	private float money;


	public DataForPieChart(String name, float money) {
		this.name = name;
		this.money = money;
	}


	public String getName() {
		return name;
	}

	public float getMoney() {
		return money;
	}
}
