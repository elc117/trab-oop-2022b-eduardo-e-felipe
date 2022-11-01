package com.example.matriculas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoDto {
    private String nome;
    private String idAluno;
}
