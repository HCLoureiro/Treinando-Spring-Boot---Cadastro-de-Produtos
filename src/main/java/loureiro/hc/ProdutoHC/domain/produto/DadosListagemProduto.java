package loureiro.hc.ProdutoHC.domain.produto;

public record DadosListagemProduto(long id, String codigo, String descricao, long categoriaID) {
    public DadosListagemProduto(Produto produto){
        this(produto.getId(), produto.getCodigo(), produto.getDescricao(), produto.getCategoriaID());
    }
}
