package br.com.estudo.estruesc.servico;

import br.com.estudo.estruesc.models.Mensagem;
import br.com.estudo.estruesc.models.Professor;
import br.com.estudo.estruesc.repositorio.ProfessorRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> cadastrarProfessor(Professor obj) {
        if (obj.getNome().equals("")) {
            mensagem.setMensagem("Nome do professor não pode ser nulo");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getSalario().floatValue() <= 0) {
            mensagem.setMensagem("O salário deve ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            mensagem.setMensagem("Professor cadastrado com sucesso");
            professorRepository.save(obj);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> alterarProfessor(Professor obj) {
        if (obj.getNome().equals("")) {
            mensagem.setMensagem("Nome do professor não pode ser nulo");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getSalario().floatValue() <= 0) {
            mensagem.setMensagem("O salário deve ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            mensagem.setMensagem("Professor alterado com sucesso");
            professorRepository.save(obj);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deletarProfessor(Integer id) {
        try{
            professorRepository.deleteById(id);
            mensagem.setMensagem("Professor deletado com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (JDBCException e2){
            mensagem.setMensagem(e2.getMessage());
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
    }
}
