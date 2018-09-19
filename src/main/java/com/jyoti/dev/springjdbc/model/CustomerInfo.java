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
public class CustomerInfo {
	private String msisdn;
	private String lob;
	private String circle;
	private String channel;
	private String userType;

}
