package loureiro.hc.ProdutoHC.domain.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import loureiro.hc.ProdutoHC.domain.produto.DadosAtualizacaoProduto;

@Table(name = "categoria")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  codigo;
    private String  descricao;
    private boolean ativo;

    public Categoria(DadosCadastroCategoria categoria){
        this.ativo = true;
        this.codigo = categoria.codigo();
        this.descricao = categoria.descricao();
    }
    public void atualizarInformacoes(DadosAtualizacaoCategoria dados) {
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
    }
    public void excluir() {
        this.ativo = false;
    }

    public void reativar(Long id) {
        this.ativo = true;
    }
}
