package com.ithuang.common;

import java.io.Serializable;
import java.util.HashMap;

/**  
  * ClassName: Result <br/>  
  * Function: TODO ADD FUNCTION. <br/>  
  * Reason: TODO ADD REASON(可选). <br/>  
  * date: 2019年9月21日 下午9:32:55 <br/>  
  *  
  * @author huangpf  
  * @version   
  * @since JDK 1.6  
  */
public class Result extends HashMap<String, Object> implements Serializable {
	private static final long serialVersionUID = 64161316464L;

	public Result() {
		this.put("code", 0);
	}

	public static Result ok() {
		Result result = new Result();
		result.put("code", 200);
		return result;
	}

	public static Result error() {
		return error(500, "系统异常");
	}

	public static Result error(String msg) {
		return error(500, msg);
	}

	public static Result error(int code, String msg) {
		Result result = new Result();
		result.put("code", code);
		result.put("msg", msg);
		return result;
	}

	public Result put(Object data) {
		super.put("data", data);
		return this;
	}
}
