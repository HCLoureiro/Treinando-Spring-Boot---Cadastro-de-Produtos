package loureiro.hc.ProdutoHC.domain.produto;

public record DadosDetalhamentoProduto(Long id, String codigo, String descricao, String categoria) {
    public DadosDetalhamentoProduto(Produto produto, String categoria){
        this(produto.getId(), produto.getCodigo(), produto.getDescricao(), categoria);
    }
}
