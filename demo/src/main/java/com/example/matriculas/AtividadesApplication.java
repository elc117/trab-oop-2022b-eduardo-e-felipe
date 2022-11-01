package com.example.matriculas;

import com.example.matriculas.data.AlunoCommand;
import com.example.matriculas.dto.AlunoCadastroDto;
import com.example.matriculas.dto.AlunoDto;
import com.example.matriculas.model.Aluno;
import com.example.matriculas.model.Atividade;
import com.example.matriculas.model.Atributo;
import com.example.matriculas.model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableMongoRepositories
public class AtividadesApplication {

	@Autowired(required = true)
	private AtividadesServico servico;

	public static void main(String[] args) {
		SpringApplication.run(AtividadesApplication.class, args);
	}

	@PostMapping("/cadastrar-atividade")
	public void cadastrarAtividade(@RequestBody Atividade atividade) {
		servico.cadastrarAtividade();
	}

	@PostMapping("/cadastrar-aluno")
	public void cadastrarAluno(@RequestBody Aluno aluno){
		servico.cadastrarAluno(aluno);
	}

	@PostMapping("/cadastrar-disciplina")
	public void cadastrarDisciplina(@RequestBody List<Disciplina> disciplinas){
		servico.cadastrarDisciplina(disciplinas);
	}

	@PostMapping("/cadastrar-atributo")
	public void cadastrarAtributo(@RequestBody List<Atributo> atributos){
		servico.cadastrarAtributo(atributos);
	}

	@GetMapping("/listar-alunos")
	public List<Aluno> listarAlunos(){
		return servico.listarAlunos();
	}

}
