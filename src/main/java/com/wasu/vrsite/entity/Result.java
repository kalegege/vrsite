/**
 * 
 */
package com.wasu.vrsite.entity;

/**
 * AO返回的结果类
 * 
 * @author wenguang
 * 
 */
public class Result<V> {

	/**
	 * 执行成功与否
	 */
	protected int success = 0;

	/**
	 * 消息编码
	 */
	private String code;

	/**
	 * 消息内容
	 */
	private String message;

	/**
	 * 返回的实体类
	 */
	private V data;

	public Result() {
		this(0);
	}

	public Result(int success) {
		this.success = success;
	}

	public Result(int success, V data) {
		this.success = success;
		this.data = data;
	}

	public Result<V> setMessage(String code, String message) {
		this.code = code;
		this.message = message;
		return this;
	}

	public Result<V> setErrorMessage(String code, String message) {
		this.code = code;
		this.message = message;
		this.setSuccess(0);
		return this;
	}

	public Result<V> setMessage(String message) {
		this.message = message;
		return this;
	}

	public void setSuccess(int success) {
		if(success==1){
			this.message="成功";
		}
		this.success = success;
	}

	public V getData() {
		return this.data;
	}

	public int getSuccess() {
		return success;
	}

	public void setData(V data) {
		this.data = data;
		this.success = 1;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * 转换成字符串的表示。
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Result {\n");
		buffer.append("    success    = ").append(success).append(",\n");
		if (success == 1) {
			buffer.append("    code     = ").append(getCode());
			buffer.append("    message     = ").append(getMessage());
		}
		return buffer.toString();
	}
}
