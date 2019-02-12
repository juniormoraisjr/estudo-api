package br.com.estudo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(updatable = false, nullable = false)
	private String username;

	@Size(min = 0, max = 500)
	private String password;

	@Size(min = 0, max = 50)
	private String email;

	private boolean activated;

	@Size(min = 0, max = 100)
	@Column(name = "activationkey")
	private String activationKey;

	@Size(min = 0, max = 100)
	@Column(name = "resetpasswordkey")
	private String resetPasswordKey;

	@ManyToMany
	@JoinTable(name = "USUARIO_PERFIL", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "perfil"))
	private Set<Perfil> perfis;

	public Usuario() {
	}

	public Usuario(String username, String password, String email, boolean activated, String firstName, String lastName, String activationKey, String resetPasswordKey, Set<Perfil> perfis) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.activated = activated;
		this.activationKey = activationKey;
		this.resetPasswordKey = resetPasswordKey;
		this.perfis = perfis;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * @param activated
	 *            the activated to set
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * @return the activationKey
	 */
	public String getActivationKey() {
		return activationKey;
	}

	/**
	 * @param activationKey
	 *            the activationKey to set
	 */
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	/**
	 * @return the resetPasswordKey
	 */
	public String getResetPasswordKey() {
		return resetPasswordKey;
	}

	/**
	 * @param resetPasswordKey
	 *            the resetPasswordKey to set
	 */
	public void setResetPasswordKey(String resetPasswordKey) {
		this.resetPasswordKey = resetPasswordKey;
	}

	/**
	 * @return the perfis
	 */
	public Set<Perfil> getPerfis() {
		return perfis;
	}

	/**
	 * @param perfis
	 *            the perfis to set
	 */
	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
}