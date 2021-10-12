package br.senac.devwebcommercial.venda;

import br.senac.devwebcommercial.cliente.Cliente;
import br.senac.devwebcommercial.endereco.Endereco;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "VENDA")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O cliente é obrigatório")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
    @JoinColumn(name = "ID_CLIENTE" )
    private Cliente cliente;

    @NotNull(message = "O endereço é obrigatório")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Endereco.class)
    @JoinColumn(name = "ID_ENDERECO" )
    private Endereco endereco;

    @Size(min = 1, max = 255, message = "O campo observação conter entre 1 e 255 caracteres")
    @Column(name = "OBSERVACAO")
    private String observacao;
}
