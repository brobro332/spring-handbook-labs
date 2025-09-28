package com.jnbr.common.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponseDto<T> {
	private boolean success;
	private T data;
	private String message;
	private Map<String, Object> error;
}
