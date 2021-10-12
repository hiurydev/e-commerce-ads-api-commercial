package br.senac.devwebcommercial.administrador;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "ADMINISTRADOR")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo usuário não pode ser nulo")
    @Size(min = 1, max = 50, message = "O campo usuário deve conter entre 1 e 50 caracteres")
    @Column(name = "USUARIO")
    private String usuario;

    @NotNull(message = "O campo senha não pode ser nulo")
    @Size(min = 1, max = 255, message = "O campo senha deve conter entre 1 e 255 caracteres")
    @Column(name = "SENHA")
    private String senha;

    @NotNull(message = "O campo email não pode ser nulo")
    @Size(min = 1, max = 100, message = "O campo email conter entre 1 e 100 caracteres")
    @Column(name = "EMAIL")
    private String email;

    //CORRIGIR
    @Column(name = "PERMISSAO")
    private String permission;
}
