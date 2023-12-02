package dianome.reclama.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_RECLAMACOES")
public class ReclamacaoModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private int telefone;
	private String descricao;
	private String codRastreamento;
	private String descSolucao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodRastreamento() {
		return codRastreamento;
	}
	public void setCodRastreamento(String codRastreamento) {
		this.codRastreamento = codRastreamento;
	}
	public String getDescSolucao() {
		return descSolucao;
	}
	public void setDescSolucao(String descSolucao) {
		this.descSolucao = descSolucao;
	}

}
