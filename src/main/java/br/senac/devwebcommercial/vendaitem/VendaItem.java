package br.senac.devwebcommercial.vendaitem;

import br.senac.devwebcommercial.endereco.Endereco;
import br.senac.devwebcommercial.venda.Venda;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "VENDA_ITENS")
public class VendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    ID PRODUTO DO OUTRO SERVIÇO

    @NotNull(message = "O campo valor não pode ser nulo")
    @Column(name = "VALOR")
    private Double valor;

    @NotNull(message = "O campo quantidade não pode ser nulo")
    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Size(min = 1, max = 255, message = "O campo observação conter entre 1 e 255 caracteres")
    @Column(name = "OBSERVACAO")
    private String observacao;

    @NotNull(message = "A venda é obrigatória")
    //CORRIGIR
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Venda.class)
    @JoinColumn(name = "ID_VENDA")
    private Venda venda;
}
