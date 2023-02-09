package loureiro.hc.ProdutoHC.domain.categoria;

public record DadosDetalheCategoria(Long id, String codigo, String descricao, boolean ativo) {
    public DadosDetalheCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getCodigo(), categoria.getDescricao(), categoria.isAtivo());
    }
}
