package br.com.ads.gestaodefrete.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idEmpresa = 1;

	private Double taxaDeAdministracao;
	
	private Double seguroPorViagem;
	
	private String nomeEmpresa;
	
	private String Endereco;
	
	private String nomeCidade;
	
	private String cep;
	
	private String telefone1;
	
	private String telefone2;
	
	private String email;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Double getTaxaDeAdministracao() {
		return taxaDeAdministracao;
	}

	public void setTaxaDeAdministracao(Double taxaDeAdministracao) {
		this.taxaDeAdministracao = taxaDeAdministracao;
	}

	public Double getSeguroPorViagem() {
		return seguroPorViagem;
	}

	public void setSeguroPorViagem(Double seguroPorViagem) {
		this.seguroPorViagem = seguroPorViagem;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Endereco == null) ? 0 : Endereco.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
		result = prime * result
				+ ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
		result = prime * result
				+ ((nomeEmpresa == null) ? 0 : nomeEmpresa.hashCode());
		result = prime * result
				+ ((seguroPorViagem == null) ? 0 : seguroPorViagem.hashCode());
		result = prime
				* result
				+ ((taxaDeAdministracao == null) ? 0 : taxaDeAdministracao
						.hashCode());
		result = prime * result
				+ ((telefone1 == null) ? 0 : telefone1.hashCode());
		result = prime * result
				+ ((telefone2 == null) ? 0 : telefone2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (Endereco == null) {
			if (other.Endereco != null)
				return false;
		} else if (!Endereco.equals(other.Endereco))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idEmpresa == null) {
			if (other.idEmpresa != null)
				return false;
		} else if (!idEmpresa.equals(other.idEmpresa))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		if (nomeEmpresa == null) {
			if (other.nomeEmpresa != null)
				return false;
		} else if (!nomeEmpresa.equals(other.nomeEmpresa))
			return false;
		if (seguroPorViagem == null) {
			if (other.seguroPorViagem != null)
				return false;
		} else if (!seguroPorViagem.equals(other.seguroPorViagem))
			return false;
		if (taxaDeAdministracao == null) {
			if (other.taxaDeAdministracao != null)
				return false;
		} else if (!taxaDeAdministracao.equals(other.taxaDeAdministracao))
			return false;
		if (telefone1 == null) {
			if (other.telefone1 != null)
				return false;
		} else if (!telefone1.equals(other.telefone1))
			return false;
		if (telefone2 == null) {
			if (other.telefone2 != null)
				return false;
		} else if (!telefone2.equals(other.telefone2))
			return false;
		return true;
	}
}
