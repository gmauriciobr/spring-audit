package br.com.gmauricio.view;

import br.com.gmauricio.entity.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProtudoViewModel {
	
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	
	public ProtudoViewModel(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getNome();
		this.preco = produto.getPreco();
	}

}
