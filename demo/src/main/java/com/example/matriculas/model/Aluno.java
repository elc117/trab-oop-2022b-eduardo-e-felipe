package com.example.matriculas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;


@Document
@Data
public class Aluno {

    @Id
    private String id;
    private String nome;

    @Indexed(unique = true)
    private String matricula;
    private String curso;

    private Map<String, List<Atividade>> avaliacoes;

}
