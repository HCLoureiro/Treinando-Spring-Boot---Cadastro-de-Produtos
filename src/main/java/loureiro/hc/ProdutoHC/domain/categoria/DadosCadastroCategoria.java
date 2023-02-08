package loureiro.hc.ProdutoHC.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(
        Long    id,

        @NotBlank(message = "{codigocategoria.obrigatorio}")
        String  codigo,

        @NotBlank(message = "{descricaocategoria.obrigatorio}")
        String  descricao,

        Boolean ativo){
}
