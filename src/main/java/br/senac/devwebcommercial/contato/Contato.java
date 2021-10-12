package br.senac.devwebcommercial.contato;

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
@Entity(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo email não pode ser nulo")
    @Size(min = 1, max = 100, message = "O campo email conter entre 1 e 100 caracteres")
    @Column(name = "EMAIL")
    private String email;

    @Size(min = 1, max = 30, message = "O campo email conter entre 1 e 30 caracteres")
    @Column(name = "TELEFONE")
    private String telefone;

    @Size(min = 1, max = 255, message = "O campo observação conter entre 1 e 255 caracteres")
    @Column(name = "OBSERVACAO")
    private String observacao;

    @NotNull(message = "O campo tipo não pode ser nulo")
    @Column(name = "TIPO")
    private Contato.Tipo tipo;

    @NotNull(message = "O campo recuperação não pode ser nulo")
    @Column(name = "RECUPERACAO")
    private Contato.Recuperacao recuperacao;

    @NotNull(message = "O cliente é obrigatório")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
    @JoinColumn(name = "ID_CLIENTE" )
    private Cliente cliente;

    public enum Recuperacao{
        EMAIL,
        TELEFONE
    }

    public enum Tipo{
        TESTE,
        TESTE2
    }
}
