package com.example.matriculas;

import com.example.matriculas.dto.AlunoCadastroDto;
import com.example.matriculas.dto.AlunoDto;
import com.example.matriculas.jpa.AlunoRepository;
import com.example.matriculas.jpa.AtividadeRepository;
import com.example.matriculas.jpa.AtributoRepository;
import com.example.matriculas.jpa.DisciplinaRepository;
import com.example.matriculas.model.Aluno;
import com.example.matriculas.model.Atributo;
import com.example.matriculas.model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtividadesServico {

    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final AtributoRepository atributoRepository;
    private final AtividadeRepository atividadeRepository;

    @Autowired
    public AtividadesServico(AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository, AtributoRepository atributoRepository, AtividadeRepository atividadeRepository) {
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.atributoRepository = atributoRepository;
        this.atividadeRepository = atividadeRepository;
    }

    public void cadastrarAtividade() {

    }

    public void cadastrarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public void cadastrarDisciplina(List<Disciplina> disciplinas) {
        disciplinaRepository.saveAll(disciplinas);
    }

    public void cadastrarAtributo(List<Atributo> atributos) {
        atributoRepository.saveAll(atributos);
    }
}
