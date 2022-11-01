package com.example.matriculas.jpa;

import com.example.matriculas.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
