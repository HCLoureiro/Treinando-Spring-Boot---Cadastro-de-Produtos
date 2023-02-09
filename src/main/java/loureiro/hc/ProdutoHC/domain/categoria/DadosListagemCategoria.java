package loureiro.hc.ProdutoHC.domain.categoria;

public record DadosListagemCategoria(Long id, String codigo, String descricao) {

    public DadosListagemCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getCodigo(), categoria.getDescricao());
    }
}
