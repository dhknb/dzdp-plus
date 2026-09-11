package com.dong.exception;

import lombok.Data;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 参数错误
 * @author Dong
 **/
@Data
public class ArgumentError {
	
	private String argumentName;
	
	private String message;
}
