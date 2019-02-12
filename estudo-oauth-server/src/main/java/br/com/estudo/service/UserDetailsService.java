package br.com.estudo.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.estudo.domain.Perfil;
import br.com.estudo.domain.Usuario;
import br.com.estudo.domain.repository.UsuarioRepository;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username).map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user)))
				.orElseThrow(() -> new UsernameNotFoundException("User " + username + " Not found"));
	}

	@Autowired
	public void setUserRepository(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(Usuario usuario) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Perfil perfil : usuario.getPerfis()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perfil.getName());
			grantedAuthorities.add(grantedAuthority);
		}

		return grantedAuthorities;
	}
}