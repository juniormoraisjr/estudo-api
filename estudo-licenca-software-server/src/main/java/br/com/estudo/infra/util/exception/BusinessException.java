package br.com.estudo.infra.util.exception;

public class BusinessException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = -4996872884513628003L;

	public static String MSG_NOME_EMPRESA_NULO_VAZIO = "Nome Empresa nulo/vazio.";

	public static String MSG_ID_EMPRESA_NULO_VAZIO = "Id Empresa nulo/vazio.";

	public static String MSG_ID_ORGANIZACAO_EMPRESARIAL_NULO_VAZIO = "Id Organização Empresarial nulo/vazio.";

	public static String MSG_CNPJ_EMPRESA_NULO_VAZIO = "Cnpj Empresa nulo/vazio.";

	public static String MSG_CNPJ_EMPRESA_INVALIDO = "Cnpj Empresa inválido.";

	public static String MSG_DATA_NULO_VAZIO = "Data nulo/vazio.";
	
	public static String MSG_OBJETO_NULO_VAZIO = "Objeto Gerador Licença nulo/vazio.";

	public BusinessException(String msg) {
		super(msg);
	}
}