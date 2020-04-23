package com.ithuang.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 
  * ClassName: ManagerException <br/>  
  * Function: TODO ADD FUNCTION. <br/>  
  * Reason: TODO ADD REASON(可选). <br/>  
  * date: 2019年12月13日 下午12:23:21 <br/>  
  *  
  * @author Administrator  
  * @version   
  * @since JDK 1.6
 */
@Getter
@Setter
public class ManagerException extends RuntimeException {

	private static final long serialVersionUID = 65232664313L;

	private String userErrMsg;
	private int errorCode;

	public ManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ManagerException(String userErrMsg) {
		super(userErrMsg);
		this.userErrMsg = userErrMsg;
		this.errorCode = 500;
	}

	public ManagerException(String userErrMsg, int errorCode) {
		super(userErrMsg);
		this.userErrMsg = userErrMsg;
		this.errorCode = errorCode;
	}

	public ManagerException(String userErrMsg, int errorCode, Throwable cause) {
		super(userErrMsg, cause);
		this.userErrMsg = userErrMsg;
		this.errorCode = errorCode;
	}

}
