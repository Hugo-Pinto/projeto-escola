package io.github.HugoPinto.rest.alunorest;

import io.github.HugoPinto.dto.alunodto.AlunoRequestDto;
import io.github.HugoPinto.dto.alunodto.AlunoResponseDto;
import io.github.HugoPinto.facade.alunofacade.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

@Path("/aluno")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoRest {

    @Inject
    AtualizarAlunoFacade atualizarAlunoFacade;

    @Inject
    CriarAlunoFacade criarAlunoFacade;

    @Inject
    ExcluirAlunoFacade excluirAlunoFacade;

    @Inject
    ListarAlunoFacade listarAlunoFacade;

    @Inject
    ListarTodosAlunosFacade listarTodosAlunosFacade;

    @Inject
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/criar")
    public Response criarAluno(AlunoRequestDto aluno) {
        AlunoResponseDto alunoRequestDto = criarAlunoFacade.executar(aluno);

        var uri = uriInfo.getAbsolutePathBuilder()
                .path(alunoRequestDto.getId().toString())
                .build();

        return Response.
                created(uri).
                entity(alunoRequestDto).
                build();
    }

    @GET
    @Path("/{id}")
    public Response listarAluno(@PathParam("id") long id) {
        AlunoResponseDto aluno = listarAlunoFacade.executar(id);

        if (aluno != null) {
            return Response.
                    status(200).
                    entity(aluno).
                    build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosAlunos() {
        List<AlunoResponseDto> alunos = listarTodosAlunosFacade.executar();
        return Response.ok(alunos).build();   // se estiver vazio, retorna lista vazia
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarAluno(@PathParam("id") long id, AlunoRequestDto alunoDto) {
        AlunoResponseDto aluno = atualizarAlunoFacade.executar(id, alunoDto);
        return Response.ok(aluno).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirAluno(@PathParam("id") long id) {
        AlunoResponseDto aluno = excluirAlunoFacade.executar(id);

        return aluno != null
                ? Response.ok(aluno).build()  // ou 204 se preferir não retornar nada
                : Response.status(Response.Status.NOT_FOUND).build();
    }

}
