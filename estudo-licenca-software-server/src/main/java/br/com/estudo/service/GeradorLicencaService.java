package br.com.estudo.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.estudo.domain.GeradorLicenca;
import br.com.estudo.domain.repository.GeradorLicencaRepository;
import br.com.estudo.infra.util.cypher.PasswordUtils;
import br.com.estudo.infra.util.date.CalendarUtils;
import br.com.estudo.infra.util.date.CalendarUtilsFormatter;
import br.com.estudo.infra.util.exception.BusinessException;
import br.com.estudo.infra.util.number.NumberUtils;

@Service
public class GeradorLicencaService {

	@Autowired
	private GeradorLicencaRepository repository;

	public GeradorLicenca gerarTokenLicenca(GeradorLicenca entity) throws BusinessException {
		String nomeEmpresa = criarEmpresa(entity, true);
		String codigoEmpresa = criarIdEmpresa(entity, true);
		String codigoOrganizacaoEmpresarial = criarIdOrganizacaoEmpresarial(entity, true);
		String cnpjEmpresa = criarCnpjEmpresa(entity, true);

		String dataGeracao = criarDataGeracaoLicenca();
		Calendar dataCorrente = CalendarUtils.setZeroAllHourInCalendar(Calendar.getInstance());
		String dataInicialLicenca = criarDataInicialLicenca(dataCorrente);
		String dataFinalLicenca = criarDataFinalLicenca(entity, dataCorrente);

		String contraSenhaGeracaoLicenca = criarContraSenha(entity, true);
		String token = createTokenLicenca(nomeEmpresa, codigoEmpresa, cnpjEmpresa, codigoOrganizacaoEmpresarial, dataGeracao, dataInicialLicenca, dataFinalLicenca, contraSenhaGeracaoLicenca);

		entity.setToken(token);
		repository.save(entity);

		return entity;
	}

	public String criarDataFinalLicenca(GeradorLicenca entity, Calendar dataCorrente) throws BusinessException {
		if (entity != null) {
			if (dataCorrente != null) {
				dataCorrente.add(Calendar.DATE, entity.getQtdeDiaLicenca());
				dataCorrente = CalendarUtils.setLastHourInCalendar(dataCorrente);
				return "Data Final Licença&" + CalendarUtilsFormatter.format(dataCorrente, "dd/MM/yyyy HH:mm:ss");
			} else {
				throw new BusinessException(BusinessException.MSG_DATA_NULO_VAZIO);
			}
		} else {
			throw new BusinessException(BusinessException.MSG_OBJETO_NULO_VAZIO);
		}
	}

	public String criarDataInicialLicenca(Calendar dataCorrente) throws BusinessException {
		if (dataCorrente != null) {
			dataCorrente = CalendarUtils.setZeroAllHourInCalendar(dataCorrente);
			return "Data Inicial Licença&" + CalendarUtilsFormatter.format(dataCorrente, "dd/MM/yyyy HH:mm:ss");
		} else {
			throw new BusinessException(BusinessException.MSG_DATA_NULO_VAZIO);
		}
	}

	public String criarDataGeracaoLicenca() {
		return "Data Geração&" + CalendarUtilsFormatter.format(Calendar.getInstance(), "dd/MM/yyyy HH:mm:ss");
	}

	public String criarDigitoCnpj(GeradorLicenca entity) throws BusinessException {
		return criarCnpjEmpresa(entity, false).split("-")[1];
	}

	public String criarIdOrganizacaoEmpresarial(GeradorLicenca entity, boolean returnConcat) throws BusinessException {
		if (entity.getIdOrganizacao() != null && !entity.getIdOrganizacao().equals("")) {
			return returnConcat ? "Código Organizacao Empresarial Cliente&" + entity.getIdOrganizacao() : entity.getIdOrganizacao();
		} else {
			throw new BusinessException(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL_NULO_VAZIO);
		}
	}

	public String criarIdEmpresa(GeradorLicenca entity, boolean returnConcat) throws BusinessException {
		if (entity.getIdEmpresa() != null && !entity.getIdEmpresa().equals("")) {
			return returnConcat ? "Código Empresa&" + entity.getIdEmpresa() : entity.getIdEmpresa();
		} else {
			throw new BusinessException(BusinessException.MSG_ID_EMPRESA_NULO_VAZIO);
		}
	}

	public String criarEmpresa(GeradorLicenca entity, boolean returnConcat) throws BusinessException {
		if (entity.getEmpresa() != null && !entity.getEmpresa().equals("")) {
			return returnConcat ? "Empresa&" + entity.getEmpresa() : entity.getEmpresa();
		} else {
			throw new BusinessException(BusinessException.MSG_NOME_EMPRESA_NULO_VAZIO);
		}
	}

	public String criarCnpjEmpresa(GeradorLicenca entity, boolean returnConcat) throws BusinessException {
		if (entity.getCnpjEmpresa() != null && !entity.getCnpjEmpresa().equals("")) {
			CNPJValidator cnpjValidator = new CNPJValidator(true);

			try {
				cnpjValidator.assertValid(entity.getCnpjEmpresa());
				return returnConcat ? "Cnpj Empresa&" + entity.getCnpjEmpresa() : entity.getCnpjEmpresa();
			} catch (InvalidStateException vm) {
				throw new BusinessException(BusinessException.MSG_CNPJ_EMPRESA_INVALIDO);
			}
		} else {
			throw new BusinessException(BusinessException.MSG_CNPJ_EMPRESA_NULO_VAZIO);
		}
	}

	public String criarContraSenha(GeradorLicenca entity, boolean returnConcat) throws BusinessException {
		Long result = (NumberUtils.toLong(criarIdEmpresa(entity, false)) + NumberUtils.toLong(criarIdOrganizacaoEmpresarial(entity, false)) + NumberUtils.toLong(criarDigitoCnpj(entity))) * 10;
		return returnConcat ? "Contra Senha&" + PasswordUtils.encrip(result.toString()) : PasswordUtils.encrip(result.toString());
	}

	private String createTokenLicenca(String nomeEmpresa, String codigoEmpresa, String cnpjEmpresa, String codigoOrganizacaoEmpresarial, String dataGeracao, String dataInicialLicenca,
			String dataFinalLicenca, String contraSenhaGeracaoLicenca) {
		String token = PasswordUtils.encrip(nomeEmpresa + ";" + dataGeracao + ";" + dataInicialLicenca + ";" + dataFinalLicenca + ";" + codigoEmpresa + ";" + codigoOrganizacaoEmpresarial + ";"
				+ cnpjEmpresa + ";" + contraSenhaGeracaoLicenca);
		return token;
	}
}