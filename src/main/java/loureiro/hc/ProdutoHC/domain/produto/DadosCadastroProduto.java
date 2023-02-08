package loureiro.hc.ProdutoHC.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(

    @NotBlank(message = "{codigoproduto.obrigatorio}")
    String codigo,

    @NotBlank(message = "{descricaoproduto.obrigatorio}")
    String descricao,

    @NotNull(message = "{categoriaID.obrigatorio}")
    Long   categoriaID){
}
