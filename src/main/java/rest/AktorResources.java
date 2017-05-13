package rest;


import java.util.List;


import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.services.AktorServices;

import zad3.domain.Aktor;




@Path("/aktorzy")
public class AktorResources {

	private AktorServices db = new AktorServices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aktor> getAll()
	{
		return db.getAll();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Aktor aktor){
		db.add(aktor);
		return Response.ok(aktor.getId()).build();
	}
	
}
