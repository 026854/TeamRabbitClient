package com.rabbitmq.client.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class QueueMessage {
	private String id;
	private String menu, base, core;
	private BeverageType beverageType;
	private Date date;

	public QueueMessage() {
		// TODO Auto-generated constructor stub
	}

	public QueueMessage(String id, String menu) {
		super();
		this.id = id;
		this.menu = menu;
	}
	public QueueMessage(String id){
		super();
		this.id = id;
	}
	public QueueMessage(String id, String menu, String base, String core, BeverageType beverageType,Date date) {
		super();
		this.id = id;
		this.menu = menu;
		this.base = base;
		this.core = core;
		this.beverageType = beverageType;
		this.date = date;
	}

}
