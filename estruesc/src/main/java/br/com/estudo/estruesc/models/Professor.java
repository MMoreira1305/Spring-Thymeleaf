package br.com.estudo.estruesc.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private StatusProfessor status;

    public Professor(String nome, BigDecimal salario, StatusProfessor status) {
        this.nome = nome;
        this.salario = salario;
        this.status = status;
    }
}
