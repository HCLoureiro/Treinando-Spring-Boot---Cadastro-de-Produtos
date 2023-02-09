package loureiro.hc.ProdutoHC.domain.produto;

public record DadosListagemProduto(Long id, String codigo, String descricao, Long categoriaID) {
    public DadosListagemProduto(Produto produto){
        this(produto.getId(), produto.getCodigo(), produto.getDescricao(), produto.getCategoriaID());
    }
}
