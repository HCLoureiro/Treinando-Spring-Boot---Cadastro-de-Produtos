package loureiro.hc.ProdutoHC.domain.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
        @NotNull
        long id,

        String descricao,
        Long categoriaID
        )
{
}
