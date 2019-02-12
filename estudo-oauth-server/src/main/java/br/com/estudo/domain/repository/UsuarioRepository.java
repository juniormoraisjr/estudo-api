package br.com.estudo.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.estudo.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	@Query("SELECT u FROM Usuario u WHERE LOWER(u.username) = LOWER(:username)")
	Optional<Usuario> findByUsername(@Param("username") String username);
}