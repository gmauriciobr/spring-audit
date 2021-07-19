package br.com.gmauricio.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gmauricio.dto.CreateProdutoForm;
import br.com.gmauricio.dto.UpdateProdutoForm;
import br.com.gmauricio.repository.ProdutoRepository;
import br.com.gmauricio.service.ProdutoService;
import br.com.gmauricio.view.ProtudoViewModel;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping("/produto")
	public ResponseEntity<ProtudoViewModel> cadastras(@RequestBody CreateProdutoForm dto, UriComponentsBuilder uriBuilder) {
		var produto = produtoService.cadastrar(dto);
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProtudoViewModel(produto));
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<ProtudoViewModel> buscaProduto(@PathVariable Long id) {
		var produto = produtoRepository.findById(id);
		if (produto.isEmpty()) {
			return ResponseEntity.notFound().build();	
		}
		return ResponseEntity.ok(new ProtudoViewModel(produto.get()));
	}
	
	@PutMapping("/produto/{id}")
	public ResponseEntity<ProtudoViewModel> alteraProduto(@PathVariable Long id, @RequestBody UpdateProdutoForm dto) {
		var produto = produtoRepository.findById(id);
		if (produto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		var update = produtoService.atualiza(id, dto);
		return ResponseEntity.ok(new ProtudoViewModel(update));
	}

}
