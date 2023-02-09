package loureiro.hc.ProdutoHC.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria(
        @NotNull
        long id,

        String descricao
        ) {
}
