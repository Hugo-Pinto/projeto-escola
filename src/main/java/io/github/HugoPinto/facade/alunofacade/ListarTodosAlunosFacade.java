package io.github.HugoPinto.facade.alunofacade;

import io.github.HugoPinto.dao.alunodao.AlunoDao;
import io.github.HugoPinto.dto.alunodto.AlunoRequestDto;
import io.github.HugoPinto.dto.alunodto.AlunoResponseDto;
import io.github.HugoPinto.mapper.AlunoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
public class ListarTodosAlunosFacade {

    @Inject
    AlunoDao alunoDao;

    @Inject
    AlunoMapper alunoMapper;

    public List<AlunoResponseDto> executar() {
        return listarTodosAlunos();
    }

    private List<AlunoResponseDto> listarTodosAlunos() {

        log.info("Listando todos os alunos");

        return alunoMapper.toResponseDtoList(alunoDao.listAll());

        //Outra forma de fazer o metodo list all
//        return alunoDao.listAll()
//                .stream()
//                .map(alunoMapper::toDto)
//                //.map(AlunoDto::new)  Outra forma de fazer sem usar o mapper
//                .toList();
    }
}
