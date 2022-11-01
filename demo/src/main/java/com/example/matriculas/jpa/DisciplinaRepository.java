package com.example.matriculas.jpa;

import com.example.matriculas.model.Disciplina;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {

}

