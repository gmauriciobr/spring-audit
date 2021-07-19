package br.com.gmauricio.dto;

import br.com.gmauricio.entity.Produto;
import lombok.Data;

@Data
public class CreateProdutoForm {
	
	private String nome;
	private String descricao;
	private Double preco;

	public Produto parse(CreateProdutoForm dto) {
		return new Produto(nome, descricao, preco);
	}

}
