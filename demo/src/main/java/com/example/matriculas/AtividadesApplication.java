package com.example.matriculas;

import com.example.matriculas.model.Aluno;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@EnableMongoRepositories
public class AtividadesApplication {

	@Autowired(required = true)
	private AtividadesServico servico;

	public static void main(String[] args) {
		SpringApplication.run(AtividadesApplication.class, args);
	}

	@PutMapping("/atualizar-aluno")
	public void atualizarAluno(@RequestBody Aluno aluno){
		servico.cadastrarAluno(aluno);
	}

	@PostMapping("/cadastrar-aluno")
	public void cadastrarAluno(@RequestBody Aluno aluno){
		servico.cadastrarAluno(aluno);
	}

	@GetMapping("/listar-alunos")
	public List<Aluno> listarAlunos(){
		return servico.listarAlunos();
	}

	@GetMapping("/buscar-aluno/{id}")
	public Optional<Aluno> buscarAluno(@PathVariable(value="id") String id){
		return servico.buscarAluno(id);
	}

	@GetMapping("/gerar-relatorio/{id}")
	public ResponseEntity<byte[]> gerarRelatorio(@PathVariable(value = "id") String idAluno) throws DocumentException, FileNotFoundException {
		byte[] relatorio = servico.gerarRelatorio(idAluno);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		String filename = "relatorio.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(relatorio, headers, HttpStatus.OK);
		return response;
	}

}
