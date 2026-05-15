package io.github.HugoPinto.facade.alunofacade;

import io.github.HugoPinto.dao.alunodao.AlunoDao;
import io.github.HugoPinto.dto.alunodto.AlunoDto;
import io.github.HugoPinto.exception.AlunoNaoEncontradoException;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@ApplicationScoped
@Slf4j
public class AlunoFacade {

    @Inject
    AlunoDao alunoDao;
    AlunoModel alunoModel;

    public AlunoDto encontrarAluno(Long id){
        log.info("Buscando aluno com id: {} na base de dados", id);
        final var alunoEncontrado  = alunoDao.findById(id);

        if(alunoEncontrado != null){
            log.info("Aluno encontrado: {}", alunoEncontrado);
            return new AlunoDto(alunoEncontrado);
        }
        log.error("Aluno não foi encontrado na base de dados com id: {}", id);
        throw new AlunoNaoEncontradoException(id);
    }

    @Transactional
    public AlunoDto cadastrarAluno(AlunoDto aluno){
        if(aluno == null) {
            log.error("Não foi possível cadastrar aluno!");
            throw new IllegalArgumentException("Aluno DTO não pode ser nulo");
        }
            //Instancia um novo objeto aluno
            AlunoModel criarAluno = new AlunoModel();

            //seta os dados do DTO que foram passados no body para a model
            criarAluno.setNome(aluno.getNome());
            criarAluno.setIdade(aluno.getIdade());
            criarAluno.setCurso(aluno.getCurso());
            criarAluno.setEmail(aluno.getEmail());

            //Armazena na DAO, a model do aluno criado
            alunoDao.persist(criarAluno);
            log.info("Aluno cadastrado com sucesso no sistema: {}", criarAluno);

            //O id é gerado apenas qnd o aluno é inserido no banco, por isso retornamos o objeto com o id do banco.
            aluno.setId(criarAluno.getId());

            return aluno;
    }


    //Metodo tá AlunoDto mas poderia ser void, não sendo necessário instanciar objeto alunoDto e retorna-lo
    @Transactional
    public AlunoDto apagarAluno(Long id){
        //Instancia um novo objeto aluno e Encontra o Aluno na base de dados
        log.info("Buscando aluno de id {} para ser excluido da base de dados", id);
        AlunoModel alunoModel = alunoDao.findById(id);

        //Se o aluno não existe, lançar exceção.
        if(alunoModel != null){
            log.info("Excluindo aluno de id: {}", id);

            //Criamos este DTO apenas para exibir os dados na response, após apagar o objeto aluno na model. É apenas uma cópia temporária.
            AlunoDto alunoDto = new AlunoDto();
            //seta os dados do DTO que foram passados no body para a model
            alunoDto.setNome(alunoModel.getNome());
            alunoDto.setIdade(alunoModel.getIdade());
            alunoDto.setCurso(alunoModel.getCurso());
            alunoDto.setId(alunoModel.getId());
            alunoDto.setEmail(alunoModel.getEmail());

            //Exclui o Aluno da model
            alunoDao.delete(alunoModel);
            log.info("Aluno {} excluido", alunoDto);

            //Retorna o objeto alunoDto para a response
            return alunoDto;
        }
        log.error("Não foi possivel excluir aluno!");
        throw new AlunoNaoEncontradoException(id, "Aluno não encontrado! teste teste teste");
    }

    public List<AlunoDto> listarTodosAlunos(){
        return alunoDao.listAll()
                .stream()
                .map(AlunoDto::new)
                .toList();
    }
}
