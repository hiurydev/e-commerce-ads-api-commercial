package br.senac.devwebcommercial.cliente;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @Size(min = 1, max = 100, message = "O campo nome deve conter entre 1 e 100 caracteres")
    @Column(name = "NOME")
    private String nome;

    @NotNull(message = "O campo usuário não pode ser nulo")
    @Size(min = 1, max = 50, message = "O campo usuário deve conter entre 1 e 50 caracteres")
    @Column(name = "USUARIO")
    private String usuario;

    @NotNull(message = "O campo senha não pode ser nulo")
    @Size(min = 1, max = 255, message = "O campo senha deve conter entre 1 e 255 caracteres")
    @Column(name = "SENHA")
    private String senha;

    @NotNull(message = "O campo data de nascimento não pode ser nulo")
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo status não pode ser nulo")
    @Column(name = "STATUS")
    private Status status;

    public enum Status{
        INATIVO,
        ATIVO
    }
}
