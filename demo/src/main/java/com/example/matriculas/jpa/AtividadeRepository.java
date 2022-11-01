package com.example.matriculas.jpa;

import com.example.matriculas.model.Atividade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


@Component
public interface AtividadeRepository extends MongoRepository<Atividade, Long> {

}
