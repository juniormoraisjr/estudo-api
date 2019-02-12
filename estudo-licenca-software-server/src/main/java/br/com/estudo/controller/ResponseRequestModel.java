package br.com.estudo.controller;

public class ResponseRequestModel {

	private Object object;

	private ResponseRequestMsgModel msg;

	public ResponseRequestModel(Object object, ResponseRequestMsgModel msg) {
		this.object = object;
		this.msg = msg;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @return the msg
	 */
	public ResponseRequestMsgModel getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(ResponseRequestMsgModel msg) {
		this.msg = msg;
	}
}