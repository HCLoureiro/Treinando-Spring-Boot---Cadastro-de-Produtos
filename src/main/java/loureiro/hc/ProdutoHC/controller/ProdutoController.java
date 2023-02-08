package loureiro.hc.ProdutoHC.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import loureiro.hc.ProdutoHC.domain.produto.DadosCadastroProduto;
import loureiro.hc.ProdutoHC.domain.produto.Produto;
import loureiro.hc.ProdutoHC.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {

        var produto = new Produto(dados);
        repository.save(produto);
        return ResponseEntity.ok().build();
    }
}
