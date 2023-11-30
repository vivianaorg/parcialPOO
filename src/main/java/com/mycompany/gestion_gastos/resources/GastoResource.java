/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_gastos.resources;
import Controller.GastoController;
import com.edu.ufps.gestion_gastos.modelo.entity.Gasto;
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
 * @author ASUS
 */
@Path("gasto")
public class GastoResource {
    GastoController gastoController = new GastoController();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Path("/gastos/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getGastos() {
        List<Gasto> gastos = new ArrayList();
        gastos = gastoController.consultar();

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(gastos)
                .build();
    }
//GET ACA
    @GET
    @Path("/gastosFecha/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getGastoFecha() {
        List<Gasto> gastos = new ArrayList();
        gastos = gastoController.gastoFecha();

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(gastos)
                .build();
    }
    
    @GET
    @Path("/gastos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGastoId(@PathParam("id") int id) {
        Gasto gasto = new Gasto(id);
        Gasto gastoR = gastoController.consultarId(gasto);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(gastoR)
                .build();
    }

    @POST
    @Path("/gastos/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarGasto(Gasto gasto) {
        try {
            gastoController.agregarGasto(gasto);
            return Response.status(Response.Status.CREATED).entity(gasto).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/gastos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") int id) {
        Gasto gasto = new Gasto(id);
        int i = gastoController.eliminar(gasto);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Access-Control-Allow-Origin", "*")
                    .entity("Gasto not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }

}