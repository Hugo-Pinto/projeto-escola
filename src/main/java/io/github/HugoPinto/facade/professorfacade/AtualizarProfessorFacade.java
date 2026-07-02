package io.github.HugoPinto.facade.professorfacade;

import io.github.HugoPinto.dao.TurmaDao;
import io.github.HugoPinto.dao.professordao.ProfessorDao;
import io.github.HugoPinto.dto.professordto.ProfessorDto;
import io.github.HugoPinto.exception.professorexception.ProfessorNaoEncontradoException;
import io.github.HugoPinto.model.professormodel.ProfessorModel;
import io.github.HugoPinto.model.turmamodel.TurmaModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
public class AtualizarProfessorFacade {

    @Inject
    ProfessorDao professorDao;

    @Inject
    TurmaDao turmaDao;

    @Transactional
    public ProfessorDto executar(Long id, ProfessorDto dto){
        validarProfessor(id, dto);

        ProfessorModel professor = buscarProfessor(id);

        atualizarCampos(professor, dto);

        return new ProfessorDto(professor);
    }

    private void validarProfessor(Long id, ProfessorDto professorDto){
        if(id == null){
            throw new IllegalArgumentException(
                    "Id não pode ser nulo"
            );
        }

        if(professorDto == null){
            throw new IllegalArgumentException(
                    "Professor não pode ser nulo"
            );
        }
    }

    private ProfessorModel buscarProfessor(Long id){

        return professorDao
                .findByIdOptional(id)
                .orElseThrow(() ->
                        new ProfessorNaoEncontradoException(
                                "Professor de id " + id + " não encontrado"
                        ));
    }

    private void atualizarCampos(
            ProfessorModel entity,
            ProfessorDto dto){

        // Atualização parcial
        if(dto.getNome() != null){
            entity.setNome(dto.getNome());
        }

        if(dto.getEmail() != null){
            entity.setEmail(dto.getEmail());
        }

        if(dto.getCpf() != null){
            entity.setCpf(dto.getCpf());
        }

        if(dto.getMatricula() != null){
            entity.setMatricula(dto.getMatricula());
        }

        if(dto.getDataNascimento() != null){
            entity.setDataNascimento(dto.getDataNascimento());
        }

        if(dto.getTitulacao() != null){
            entity.setTitulacao(dto.getTitulacao());
        }

        if(dto.getAreaAtuacao() != null){
            entity.setAreaAtuacao(dto.getAreaAtuacao());
        }

        // boolean precisa cuidado
        entity.setAtivo(dto.isAtivo());

        // Atualização das turmas
        if(dto.getTurmas() != null){

            Set<TurmaModel> turmas = dto.getTurmas()
                    .stream()
                    .map(t -> turmaDao.findById(t.getId()))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());

            entity.setTurmas(turmas);
        }
    }
}
