package io.github.HugoPinto.rest;

import io.github.HugoPinto.dto.AlunoDto;
import io.github.HugoPinto.facade.AlunoFacade;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoRest {

    @Inject
    AlunoFacade alunoFacade;

    @Inject
    UriInfo uriInfo;

    @GET
    @Path("/{id}")
    public Response listarAluno(@PathParam("id") long id){
        AlunoDto aluno = alunoFacade.encontrarAluno(id);

        if (aluno != null) {
            return Response.
                    status(200).
                    entity(aluno).
                    build();
        }
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("criar")
    public Response criarAluno(AlunoDto aluno){
        if (aluno == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        AlunoDto criado = alunoFacade.cadastrarAluno(aluno);

        var uri = uriInfo.getAbsolutePathBuilder()
                .path(criado.getId().toString())
                .build();

        return Response.
                created(uri).
                entity(criado).
                build();
    }

    @DELETE
    @Path("/{id}")
    public Response apagarAluno(@PathParam("id") long id){

        AlunoDto aluno = alunoFacade.apagarAluno(id);

        if (aluno == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        var uri = uriInfo.getAbsolutePathBuilder()
                .path(aluno.getId().toString())
                .build();

        return Response.
                created(uri).
                entity(aluno).
                build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AlunoDto> listarTodosAlunos(){
        return alunoFacade.listarTodosAlunos();
    }

}


/*
SHIFT + ALT + SETINHA MEXE A LINHA

CTRL + / comenta o código com barras
CTRL + SHIFT + / comenta o código com comentário de multiplas linhas


No Quarkus, REST geralmente significa uma classe anotada com:

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

Ela é a porta de entrada HTTP da sua aplicação.

Ela NÃO contém regra de negócio.

Ela serve para:

Receber requisição HTTP

Validar entrada

Converter JSON → DTO

Chamar a camada de serviço/facade

Retornar resposta HTTP

Exemplo mental:

Usuário → HTTP → REST → Service → Repository → Banco

Se a REST expõe endpoints, o Client consome endpoints.



Use @QueryParam quando:

O parâmetro for opcional

For um filtro

For paginação

Ordenação

Pesquisa

Define um Path, consome e produz um json com os dados, dados esses sendo por exemplo neste caso, um objeto DTO de um perfil
 */
