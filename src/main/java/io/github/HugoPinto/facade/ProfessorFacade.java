package io.github.HugoPinto.facade;

import io.github.HugoPinto.dao.ProfessorDao;
import io.github.HugoPinto.dto.AlunoDto;
import io.github.HugoPinto.dto.ProfessorDto;
import io.github.HugoPinto.exception.ProfessorNaoEncontradoException;
import io.github.HugoPinto.model.ProfessorModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


@ApplicationScoped
@Slf4j
public class ProfessorFacade {

    @Inject
    ProfessorDao professorDao;

    //@Inject
   // ProfessorModel professorModel;

    @Transactional
    public ProfessorDto cadastrarProfessor(ProfessorDto professor) {
        if (professor != null) {

            var cadastroProfessor = new ProfessorModel();

            cadastroProfessor.setNome(professor.getNome());
            cadastroProfessor.setEmail(professor.getEmail());
            cadastroProfessor.setCpf(professor.getCpf());
            cadastroProfessor.setMatricula(professor.getMatricula());
            cadastroProfessor.setDataNascimento(professor.getDataNascimento());
            cadastroProfessor.setTitulacao(professor.getTitulacao());
            cadastroProfessor.setAreaAtuacao(professor.getAreaAtuacao());
            cadastroProfessor.setAtivo(professor.isAtivo());
            cadastroProfessor.setTurmas(professor.getTurmas());
            cadastroProfessor.setDisciplinas(professor.getDisciplinas());

            log.info("Cadastrando o professor {} na base de dados!", professor);
            professorDao.persist(cadastroProfessor);

            professor.setId(cadastroProfessor.getId());

            log.info("Professor de id {} cadastrado com sucesso!", professor.getId());

            return professor;
        }
        log.error("O objeto professor nao pode ser vazio!");
        throw new ProfessorNaoEncontradoException("O objeto professor não pode ser vazio!");
    }


    public ProfessorDto findProfessoryById(Long id) {
        if (id != null) {
            ProfessorDto professorRetorno = new ProfessorDto();
            var professor = professorDao.findById(id);

            professorRetorno.setId(professor.getId());
            professorRetorno.setNome(professor.getNome());
            professorRetorno.setEmail(professor.getEmail());
            professorRetorno.setCpf(professor.getCpf());
            professorRetorno.setMatricula(professor.getMatricula());
            professorRetorno.setDataNascimento(professor.getDataNascimento());
            professorRetorno.setTitulacao(professor.getTitulacao());
            professorRetorno.setAreaAtuacao(professor.getAreaAtuacao());
            professorRetorno.setAtivo(professor.isAtivo());
            professorRetorno.setTurmas(professor.getTurmas());
            professorRetorno.setDisciplinas(professor.getDisciplinas());

            return professorRetorno;
        }
        throw new ProfessorNaoEncontradoException("Professor de id: " + id + " nao foi encontrado!", id);
    }

    //O professorDao.listAll() gera uma lista de ProfessorModel
    //.stream() pega esses objetos da lista e transforma em um fluxo
    //.map() pega cada objeto desse fluxo, no caso, cada ProfessorModel e instancia um novo objeto ProfessorDto
    //Por fim, .toList() gera uma lista desses dados. Neste caso, uma lista de ProfessorDto.
    public List<ProfessorDto> listarTodosProfessores() {
        return professorDao.listAll()
                .stream()
                .map(ProfessorDto::new)
                .toList();
    }

    @Transactional
    public ProfessorDto excluirProfessor(long id){
        var professor = professorDao.findById(id);

        if(professor != null){
            ProfessorDto professorRetornado = new ProfessorDto();

            professorRetornado.setId(professor.getId());
            professorRetornado.setNome(professor.getNome());
            professorRetornado.setEmail(professor.getEmail());
            professorRetornado.setCpf(professor.getCpf());
            professorRetornado.setMatricula(professor.getMatricula());
            professorRetornado.setDataNascimento(professor.getDataNascimento());
            professorRetornado.setTitulacao(professor.getTitulacao());
            professorRetornado.setAreaAtuacao(professor.getAreaAtuacao());
            professorRetornado.setAtivo(professor.isAtivo());
            professorRetornado.setTurmas(professor.getTurmas());
            professorRetornado.setDisciplinas(professor.getDisciplinas());

            professorDao.delete(professor);

            return professorRetornado;
        }
        else{
            throw new ProfessorNaoEncontradoException("O professor de ID: " + id + "nao foi encontrado na base de dados!");
        }
    }
}

