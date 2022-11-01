package com.example.matriculas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Disciplina {
    @Id
    private String codigo;
    private String nome;
}
