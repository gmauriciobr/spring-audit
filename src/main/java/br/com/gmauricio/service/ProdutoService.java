package br.com.gmauricio.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gmauricio.dto.CreateProdutoForm;
import br.com.gmauricio.dto.UpdateProdutoForm;
import br.com.gmauricio.entity.Produto;
import br.com.gmauricio.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto cadastrar(CreateProdutoForm dto) {
		return produtoRepository.save(dto.parse(dto));
	}

	public Produto atualiza(Long id, UpdateProdutoForm dto) {
		var produto = produtoRepository.findById(id).get();
		BeanUtils.copyProperties(dto, produto);
		return produtoRepository.save(produto);
	}

}
