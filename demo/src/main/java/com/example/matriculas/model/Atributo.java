package com.example.matriculas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Atributo {
    @Id
    private String codigo;
    private String nome;
    private Double nota;
}
