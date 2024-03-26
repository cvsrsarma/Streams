package com.org.streams.first.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AccessDetails {
	
	private int accessId;
	private String accessName;
	private String accessDesc;
	private String accessDetls1;
	private String accessDetls2;

}
