package br.com.ads.gestaodefrete.modelo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String placa;
	
	private String modelo;
	
	@OneToOne // se colocar optional = true , da certo 
	@JoinColumn(name = "idCategoriaVeiculo", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_veiculo_categoriaVeiculo"))
	private CategoriaVeiculo categoriaVeiculo;
	
	private String chassi;
	
	private String observacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public CategoriaVeiculo getCategoriaVeiculo() {
		return categoriaVeiculo;
	}
	public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
		this.categoriaVeiculo = categoriaVeiculo;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categoriaVeiculo == null) ? 0 : categoriaVeiculo.hashCode());
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (categoriaVeiculo == null) {
			if (other.categoriaVeiculo != null)
				return false;
		} else if (!categoriaVeiculo.equals(other.categoriaVeiculo))
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
}
