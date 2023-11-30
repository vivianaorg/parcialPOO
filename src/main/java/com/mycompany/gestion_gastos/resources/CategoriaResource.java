/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_gastos.resources;
import Controller.CategoriaController;
import com.edu.ufps.gestion_gastos.modelo.entity.Categoria;
//import jakarta.ws.rs.DELETE;
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
 * @author ASUS
 */
@Path("categoria")
public class CategoriaResource {
    CategoriaController cController = new CategoriaController();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Path("/categorias/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getCategorias() {
        List<Categoria> categorias = new ArrayList();
        categorias = cController.consultar();

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(categorias)
                .build();
    }

    @GET
    @Path("/categorias/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoriaId(@PathParam("id") int id) {
        Categoria categoria = new Categoria(id);
        Categoria categoriaR = cController.consultarId(categoria);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(categoriaR)
                .build();
    }

    @POST
    @Path("/gastos/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarCategoria(Categoria categoria) {
        try {
            cController.agregarCategoria(categoria);
            return Response.status(Response.Status.CREATED).entity(categoria).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

}
