package com.example.matriculas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
public class Aluno {

    @Id
    private String idAluno;
    private String nome;
    private String matricula;

    @DBRef
    private List<Atividade> atividades;

}
