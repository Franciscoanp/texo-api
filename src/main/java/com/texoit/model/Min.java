package com.texoit.model;

import lombok.Data;

@Data
public class Min {

	private String producer;
	private int interval;
	private int previousWin;
	private int followingWin;
	
}
