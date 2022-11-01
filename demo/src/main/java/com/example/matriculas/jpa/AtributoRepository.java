package com.example.matriculas.jpa;

import com.example.matriculas.model.Atributo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AtributoRepository extends MongoRepository<Atributo, String> {

}

