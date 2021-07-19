package br.com.gmauricio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;

import br.com.gmauricio.entity.Produto;

public interface ProdutoRepository extends RevisionRepository<Produto, Long, Long>, CrudRepository<Produto, Long> {

}
