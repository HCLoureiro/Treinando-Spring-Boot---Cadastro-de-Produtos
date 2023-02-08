package loureiro.hc.ProdutoHC.domain.categoria;

import loureiro.hc.ProdutoHC.domain.produto.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends  JpaRepository<Categoria, Long>{
        Page<Produto> findAllByAtivoTrue(Pageable paginacao);
}
