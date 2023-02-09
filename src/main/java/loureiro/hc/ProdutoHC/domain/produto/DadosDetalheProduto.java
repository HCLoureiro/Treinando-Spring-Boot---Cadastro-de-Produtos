package loureiro.hc.ProdutoHC.domain.produto;

public record DadosDetalheProduto(Long id, String codigo, String descricao, String categoria, boolean ativo) {
    public DadosDetalheProduto(Produto produto, String categoria){
        this(produto.getId(), produto.getCodigo(), produto.getDescricao(), categoria, produto.isAtivo());
    }
}
