package br.com.estudo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudo.domain.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, String> {

	Perfil findByName(String name);
}