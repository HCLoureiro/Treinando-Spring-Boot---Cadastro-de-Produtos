package loureiro.hc.ProdutoHC.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import loureiro.hc.ProdutoHC.domain.categoria.Categoria;
import loureiro.hc.ProdutoHC.domain.categoria.CategoriaRepository;
import loureiro.hc.ProdutoHC.domain.categoria.DadosCadastroCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder uriBuilder) {

        var categoria = new Categoria(dados);
        repository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
