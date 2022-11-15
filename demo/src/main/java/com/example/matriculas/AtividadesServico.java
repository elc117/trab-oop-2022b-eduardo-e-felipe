package com.example.matriculas;

import com.example.matriculas.jpa.AlunoRepository;
import com.example.matriculas.jpa.AtividadeRepository;
import com.example.matriculas.model.Aluno;
import com.example.matriculas.model.Atividade;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

@Component
public class AtividadesServico {

    private final AlunoRepository alunoRepository;
    private final AtividadeRepository atividadeRepository;

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Autowired
    public AtividadesServico(AlunoRepository alunoRepository, AtividadeRepository atividadeRepository) {
        this.alunoRepository = alunoRepository;
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

    public Optional<Aluno> buscarAluno(String id) {
        return alunoRepository.findById(id);
    }

    public byte[] gerarRelatorio(String idAluno) throws FileNotFoundException, DocumentException {

        Aluno aluno = getAlunoById(idAluno);
        if (aluno == null) return null;

        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        addInfosBasicasAluno(aluno, document, font);

        for(String chave : aluno.getAvaliacoes().keySet()) {
            Paragraph paragraph = new Paragraph("Disciplina: "+chave, font);
            paragraph.setSpacingAfter(10);
            paragraph.setSpacingBefore(15);
            document.add(paragraph);

            PdfPTable table = criarHeader();
            for(Atividade atividade : aluno.getAvaliacoes().get(chave)) {
                adicionarInfosTabela(table, atividade);
            }
            document.add(table);
            document.add(new Paragraph("\n"));
        }
        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    private Aluno getAlunoById(String idAluno) {
        Aluno aluno = null;
        Optional<Aluno> alunoOptional = buscarAluno(idAluno);
        if(alunoOptional.isPresent())
            aluno = alunoOptional.get();
        else
            return null;
        return aluno;
    }

    private void adicionarInfosTabela(PdfPTable table, Atividade atividade) {
        table.addCell(atividade.getNome());
        table.addCell(atividade.getNota().toString());
        table.addCell(atividade.getPeso().toString());
        table.addCell(atividade.getObservacoes());
        table.addCell(atividade.getNota()* atividade.getPeso()/10.0 + "");
    }

    private PdfPTable criarHeader() {
        PdfPTable table = new PdfPTable(5);
        table.addCell("Atividade");
        table.addCell("Nota");
        table.addCell("Peso");
        table.addCell("Observação");
        table.addCell("Nota Final");
        return table;
    }

    private void addInfosBasicasAluno(Aluno aluno, Document document, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph("Relatório do aluno: " + aluno.getNome(), font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        Paragraph paragraph2 = new Paragraph("Matrícula: " + aluno.getMatricula(), font);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(15);
        document.add(paragraph2);

        Paragraph paragraph3 = new Paragraph("Curso: " + aluno.getCurso(), font);
        paragraph3.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(15);
        document.add(paragraph3);
    }

}
