/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_gastos.resources;
import Controller.UsuarioController;
import com.edu.ufps.gestion_gastos.modelo.entity.Usuario;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author juan
 */
@Path("usuario")
public class UsuarioResource {
    UsuarioController usuarioController = new UsuarioController();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Path("/usuarios/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getUsuarios() {
        List<Usuario> usuario = new ArrayList();
        usuario = usuarioController.consultar();

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(usuario)
                .build();
    }
    
    @POST
    @Path("/usuarios/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Usuario usuario) {
        try {
            usuarioController.crear(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/usuarios/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("email") String email) {
        Usuario usuario = new Usuario(email);
        int i = usuarioController.eliminar(usuario);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Access-Control-Allow-Origin", "*")
                    .entity("Usuario not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
}
