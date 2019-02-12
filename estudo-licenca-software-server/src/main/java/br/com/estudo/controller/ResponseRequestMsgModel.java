package br.com.estudo.controller;

public class ResponseRequestMsgModel {

	private String tipoMsg;

	private String msg;

	public ResponseRequestMsgModel(String tipoMsg, String msg) {
		this.tipoMsg = tipoMsg;
		this.msg = msg;
	}

	/**
	 * @return the tipoMsg
	 */
	public String getTipoMsg() {
		return tipoMsg;
	}

	/**
	 * @param tipoMsg
	 *            the tipoMsg to set
	 */
	public void setTipoMsg(String tipoMsg) {
		this.tipoMsg = tipoMsg;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}