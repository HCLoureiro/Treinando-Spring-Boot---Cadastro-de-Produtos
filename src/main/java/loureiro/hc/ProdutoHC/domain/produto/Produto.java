package loureiro.hc.ProdutoHC.domain.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produto")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  codigo;
    private String  descricao;
    private Long    categoriaID;
    private boolean ativo;

    public Produto(DadosCadastroProduto produto){
        this.ativo  = true;
        this.codigo = produto.codigo();
        this.descricao = produto.descricao();
        this.categoriaID = produto.categoriaID();
    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
