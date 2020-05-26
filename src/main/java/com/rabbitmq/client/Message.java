package com.rabbitmq.client;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	private String path;
	private long size;
	private String beforeType;
	private String afterType;
	private String id;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String path, long size, String beforeType, String afterType, String id) {
		super();
		this.path = path;
		this.size = size;
		this.beforeType = BeforeType.randomBeforeType();
		this.afterType = AfterType.randomBeforeType();
		this.id = id;
	}

}
