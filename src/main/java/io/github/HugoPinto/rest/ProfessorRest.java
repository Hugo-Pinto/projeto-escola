package io.github.HugoPinto.rest;

import io.github.HugoPinto.dto.ProfessorDto;
import io.github.HugoPinto.facade.ProfessorFacade;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path("/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorRest {

    @Inject
    ProfessorFacade professorFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarProfessor(ProfessorDto professor){
        var resultado = professorFacade.cadastrarProfessor(professor);

        return Response.ok(resultado).build();
    }

    @GET
    @Path("/{id}")
    public Response findProfessoryById(@PathParam("id") long id){
        var professor = professorFacade.findProfessoryById(id);

        return Response.ok().status(200).entity(professor).build();
    }

    @GET
    @Path("/listar")
    public Response listarTodosProfessores(){
        List<ProfessorDto> professorDtoList = professorFacade.listarTodosProfessores();

        if(professorDtoList != null){
            return Response.ok(professorDtoList).status(200).build();
        }
        else{
            return Response.noContent().status(401).build();
        }
    }

    @DELETE
    @Path("/apagar/{id}")
    public Response excluirProfessor(@PathParam("id") long id){

        var professor = professorFacade.excluirProfessor(id);

        if(professor != null){
            return Response.ok(professor).status(200).build();
        }
        else{
            return Response.noContent().status(401).build();
        }
    }
}
