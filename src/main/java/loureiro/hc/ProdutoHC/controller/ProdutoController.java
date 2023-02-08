package loureiro.hc.ProdutoHC.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import loureiro.hc.ProdutoHC.domain.categoria.CategoriaRepository;
import loureiro.hc.ProdutoHC.domain.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository repCategoria;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {

        var produto = new Produto(dados);
        repository.save(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProduto>> listar(@PageableDefault(size = 10, sort = {"descricao"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProduto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados) {
        var produto = repository.getReferenceById(dados.id());
        var categoria = repCategoria.getReferenceById(produto.getCategoriaID());
        String descCategoria = categoria.getDescricao();

        produto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto, descCategoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);
        var categoria = repCategoria.getReferenceById(produto.getCategoriaID());
        String descCategoria = categoria.getDescricao();
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto, descCategoria));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);
        produto.excluir();

        return ResponseEntity.noContent().build();
    }
}
