package com.example.matriculas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoCadastroDto {
    private String nome;
    private String matricula;
}
