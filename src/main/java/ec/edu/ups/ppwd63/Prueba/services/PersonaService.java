package ec.edu.ups.ppwd63.Prueba.services;

import java.util.List;

import ec.edu.ups.ppwd63.Prueba.business.GestionPersonas;
import ec.edu.ups.ppwd63.Prueba.model.Persona;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("Personas")
public class PersonaService {
	@Inject
	private GestionPersonas gPersonas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Persona persona) {
		try{
			gPersonas.guardarClientes(persona);
			return Response.ok(persona).build();
		}catch (Exception e) {
			// TODO: handle exception
		
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Persona persona) {
		try{
			gPersonas.actualizarCliente(persona);
			return Response.ok(persona).build();
		}catch (Exception e) {
			// TODO: handle exception
			
			return Response.status(Response.Status.NOT_FOUND)
					
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try{
			gPersonas.borrarCliente(codigo);;
			return "OK";
		}catch (Exception e) {
			// TODO: handle exception
			return "Error";
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer(@QueryParam("cedula") String cedula, @QueryParam("nombre") String nombre) {
		try{
			System.out.println("cedula " +  cedula + " nom=" + nombre);
			Persona per = gPersonas.getClientePorCedula(cedula);
			return Response.ok(per).build();
		}catch (Exception e) {
			// TODO: handle exception
		
			
			return Response.status(Response.Status.NOT_FOUND)
					
					.build();
		}
	}
	
	@GET
	@Path("{cedula}/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer2(@PathParam("cedula") String cedula, @PathParam("nombre") String nombre) {
		try{
			System.out.println("cedula " +  cedula + " nom=" + nombre);
			Persona cli = gPersonas.getClientePorCedula(cedula);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			
		
			return Response.status(Response.Status.NOT_FOUND)
					
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Persona> personas = gPersonas.getClientes();
		if(personas.size()>0)
			return Response.ok(personas).build();

	
		return Response.status(Response.Status.NOT_FOUND)
			
				.build();
		
	}
	
	
	
	

}

