package com.example.matriculas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Atividade {

    @Id
    private String idAtividade;
    private String descricao;

    @DBRef
    private Disciplina disciplina;
    @DBRef
    private List<Atributo> atributos;

}
