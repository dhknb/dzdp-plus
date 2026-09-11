package com.dong.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
import com.dong.enums.BaseCode;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 业务异常
 * @author Dong
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class HmdpFrameException extends BaseException {
	
	private Integer code;
	
	private String message;

	public HmdpFrameException() {
		super();
	}

	public HmdpFrameException(String message) {
		super(message);
	}
	
	public HmdpFrameException(Integer code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	
	public HmdpFrameException(BaseCode baseCode) {
		super(baseCode.getMsg());
		this.code = baseCode.getCode();
		this.message = baseCode.getMsg();
	}

	public HmdpFrameException(Throwable cause) {
		super(cause);
	}

	public HmdpFrameException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
}
