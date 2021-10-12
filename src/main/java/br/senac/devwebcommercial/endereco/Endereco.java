package br.senac.devwebcommercial.endereco;

import br.senac.devwebcommercial.cliente.Cliente;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo estado não pode ser nulo")
    @Size(min = 1, max = 100, message = "O campo estado deve conter entre 1 e 100 caracteres")
    @Column(name = "ESTADO")
    private String estado;

    @NotNull(message = "O campo cidade não pode ser nulo")
    @Size(min = 1, max = 100, message = "O campo cidade conter entre 1 e 100 caracteres")
    @Column(name = "CIDADE")
    private String cidade;

    @NotNull(message = "O campo cep não pode ser nulo")
    @Size(min = 1, max = 8, message = "O campo cep conter entre 1 e 8 caracteres")
    @Column(name = "CEP")
    private String cep;

    @NotNull(message = "O campo logradouro não pode ser nulo")
    @Size(min = 1, max = 255, message = "O campo logradouro conter entre 1 e 255 caracteres")
    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @NotNull(message = "O campo tipo não pode ser nulo")
    @Column(name = "TIPO")
    private Endereco.Tipo tipo;

    @NotNull(message = "O campo status não pode ser nulo")
    @Column(name = "STATUS")
    private Endereco.Status status;

    @NotNull(message = "O cliente é obrigatório")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
    @JoinColumn(name = "ID_CLIENTE" )
    private Cliente cliente;

    public enum Status{
        INATIVO,
        ATIVO
    }

    public enum Tipo{
        COBRANCA,
        ENTREGA
    }
}
