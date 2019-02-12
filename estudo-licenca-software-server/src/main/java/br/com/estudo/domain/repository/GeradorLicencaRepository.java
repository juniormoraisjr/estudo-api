package br.com.estudo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudo.domain.GeradorLicenca;

public interface GeradorLicencaRepository extends JpaRepository<GeradorLicenca, Long> {

}