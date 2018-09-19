package com.jyoti.dev.springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiModel {
	private String apiName;
	private String version;
	private String adminAddr;
	private String adminName;
	private String platform;
	

}
