package br.com.estudo.estruesc.repositorio;

import br.com.estudo.estruesc.models.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
    List<Professor> findAll();
    List<Professor> findAllById(int id);

    Professor findById(Long id);

    void deleteById(Long id);
}
