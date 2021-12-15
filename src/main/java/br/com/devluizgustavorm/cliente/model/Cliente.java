package br.com.devluizgustavorm.cliente.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @SequenceGenerator(name = "cliente_sequece", sequenceName = "cliente_sequece", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String ddd;
    private String telefone;

}
