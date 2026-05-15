package io.github.HugoPinto.facade.professorfacade;

import io.github.HugoPinto.dao.professordao.ProfessorDao;
import io.github.HugoPinto.dao.TurmaDao;
import io.github.HugoPinto.dto.professordto.ProfessorDto;
import io.github.HugoPinto.exception.professorexception.ProfessorNaoEncontradoException;
import io.github.HugoPinto.model.professormodel.ProfessorModel;
import io.github.HugoPinto.model.turmamodel.TurmaModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class CriarProfessorFacade {

    @Inject
    ProfessorDao professorDao;

    @Inject
    TurmaDao turmaDao;

    @Transactional
    public ProfessorDto executar(ProfessorDto professorDto) {
        validarProfessor(professorDto);
        return cadastrarProfessor(professorDto);
    }

    private void validarProfessor(ProfessorDto dto){

        if(dto == null){
            log.error("O objeto professor nao pode ser vazio!");
            throw new IllegalArgumentException(
                    "Professor não pode ser nulo"
            );
        }

        if(dto.getNome() == null || dto.getNome().isBlank()){
            throw new IllegalArgumentException(
                    "Nome é obrigatório"
            );
        }

        if(dto.getCpf() == null || dto.getCpf().isBlank()){
            throw new IllegalArgumentException(
                    "CPF é obrigatório"
            );
        }
    }

    private ProfessorDto cadastrarProfessor(ProfessorDto professorDto){

            ProfessorModel professor = toEntity(professorDto);

            log.info("Cadastrando o professor {} na base de dados!", professor);

            professorDao.persist(professor);

            log.info("Professor de id {} cadastrado com sucesso!", professor.getId());

            return new ProfessorDto(professor);
    }


    private ProfessorModel toEntity(ProfessorDto dto) {
        ProfessorModel entity = new ProfessorModel();

        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setCpf(dto.getCpf());
        entity.setMatricula(dto.getMatricula());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setTitulacao(dto.getTitulacao());
        entity.setAreaAtuacao(dto.getAreaAtuacao());
        entity.setAtivo(dto.isAtivo());

        // Tratamento das turmas
        if (dto.getTurmas() != null && !dto.getTurmas().isEmpty()) {
            Set<TurmaModel> turmas = dto.getTurmas().stream()
                    .map(t -> turmaDao.findById(t.getId()))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());
            entity.setTurmas(turmas);
        }

        return entity;
    }
}

