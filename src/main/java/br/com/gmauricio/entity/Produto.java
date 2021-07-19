package br.com.gmauricio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Audited
@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	//@RevisionNumber
	//private int pages;
	
	public Produto(String nome, String descricao, Double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

}
