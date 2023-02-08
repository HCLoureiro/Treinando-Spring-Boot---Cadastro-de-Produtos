package loureiro.hc.ProdutoHC.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
        @NotNull
        long id,

        @NotBlank
        String descricao) {
}
