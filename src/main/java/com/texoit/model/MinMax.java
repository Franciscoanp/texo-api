package com.texoit.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MinMax {
	
	private List<Min> min = new ArrayList<>();
	private List<Max> max = new ArrayList<>();
	
}
