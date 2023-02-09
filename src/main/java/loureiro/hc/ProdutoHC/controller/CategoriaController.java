package loureiro.hc.ProdutoHC.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import loureiro.hc.ProdutoHC.domain.categoria.*;
import loureiro.hc.ProdutoHC.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ProdutoRepository repProd;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder uriBuilder) {

        var categoria = new Categoria(dados);
        repository.save(categoria);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemCategoria>> listar(@PageableDefault(size = 10, sort = {"descricao"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemCategoria::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCategoria dados) {
        var categoria = repository.getReferenceById(dados.id());
        categoria.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalheCategoria(categoria));
    }

    @PutMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity reativar(@PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        categoria.reativar(id);
        return ResponseEntity.ok(new DadosDetalheCategoria(categoria));
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalheCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        if (repProd.existsByCategoriaID(id)){
            return ResponseEntity.badRequest().body("Erro: Existe produto associado a essa categoria");
        }
        var categoria = repository.getReferenceById(id);
        categoria.excluir();
        return ResponseEntity.noContent().build();
    }

}
