package br.com.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.domain.GeradorLicenca;
import br.com.estudo.infra.util.exception.BusinessException;
import br.com.estudo.service.GeradorLicencaService;

@RestController
@RequestMapping(value = "/geradorLicenca")
public class GeradorLicencaController {

	@Autowired
	private GeradorLicencaService service;

	@RequestMapping(value = "/gerarToken", method = RequestMethod.POST)
	public ResponseRequestModel gerarToken(@RequestBody GeradorLicenca entity) {
		try {
			GeradorLicenca result = service.gerarTokenLicenca(entity);
			return new ResponseRequestModel(result, new ResponseRequestMsgModel("Sucesso", "Endpoint executado!"));
		} catch (BusinessException e) {
			return new ResponseRequestModel(null, new ResponseRequestMsgModel("Erro", e.getMessage()));
		}
	}
}