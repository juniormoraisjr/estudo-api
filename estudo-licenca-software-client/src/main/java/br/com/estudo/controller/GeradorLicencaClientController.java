package br.com.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.config.UserFeignClientInterceptor;
import br.com.estudo.consumer.microservicos.GeradorLicencaClientService;
import br.com.estudo.controller.model.GeradorLicencaClientModel;
import feign.RequestInterceptor;

@RestController
@RequestMapping(value = "/geradorLicencaClient")
public class GeradorLicencaClientController {

	@Autowired
	GeradorLicencaClientService geradorLicencaClientService;

	@RequestMapping(value = "/gerarTokenClient", method = RequestMethod.POST)
	public Object gerarTokenClient(@RequestBody GeradorLicencaClientModel model) {
		return geradorLicencaClientService.gerarToken(model);
	}

	@Bean
	public RequestInterceptor getUserFeignClientInterceptor() {
		return new UserFeignClientInterceptor();
	}
}