package rest;



import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import domain.services.FilmyServices;

import zad3.domain.Filmy;
import zad3.domain.Komentarz;
import zad3.domain.Ocena;



@Path("/filmy")
public class FilmyResources {
	
	private FilmyServices db = new FilmyServices();
	
	/*wyswietlanie listy wszystkich filmow */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filmy> getAll()
	{
		return db.getAll();
	}
	
	
	/*dodanie nowego filmy */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Filmy filmy){
		db.add(filmy);
		return Response.ok(filmy.getId()).build();
	}
	
	/*wyswietlanie  filmu o podanym id */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id")int id){
		Filmy result = db.get(id);
		if(result==null){
			return Response.status(404).build();
		
		}
		return Response.ok(result).build();
	}
	/* aktualizacja opisu filmu */	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	     public Response update(@PathParam("id") int id, Filmy f){
			Filmy result = db.get(id);
			if(result == null)
				return Response.status(404).build();
			f.setId(id);
			db.update(f);
			return Response.ok().build();	
	}
	
	/* Wyswietlanie komenatarzy danego filmu po jego id */
	@GET
	@Path("/{filmyId}/komentarz")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Komentarz> getKomentarz(@PathParam("filmyId") int filmyId){
		Filmy result = db.get(filmyId);
		if(result==null)
			return null;
		if(result.getKomentarz()==null)
			result.setKomentarz(new ArrayList<Komentarz>());
		return result.getKomentarz();
	}
	
	/*dodanie komentarza pod konkretny film*/
	@POST
	@Path("/{filmyId}/komentarz")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addKomentarz(@PathParam("filmyId") int filmyId, Komentarz filmy){
		Filmy result = db.get(filmyId);
		if(result==null)
			return Response.status(404).build();
		if(result.getKomentarz()==null)
			result.setKomentarz(new ArrayList<Komentarz>());
		result.getKomentarz().add(filmy);
		return Response.ok().build();
	}
	
	/*Usuwanie komentarza*/
	@DELETE
	@Path("/{filmyId}/komentarz/{komentarzId}")
	public Response delete(@PathParam("filmyId") int filmyId, @PathParam("komentarzId") int komentarzId){
		Filmy result = db.get(filmyId);
		if(result==null)
			return Response.status(404).build();
		Komentarz tmp = null;
		for(Komentarz k : result.getKomentarz())
			if(k.getId()==komentarzId)
				tmp=k;
		result.getKomentarz().remove(tmp);
		db.update(result);
		return Response.ok().build();
	
	}
	
	
	/* Wyswietlanie oceny danego filmu po jego id */
	@GET
	@Path("/{filmyId}/ocena")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ocena> getOcena(@PathParam("filmyId") int filmyId){
		Filmy result = db.get(filmyId);
		if(result==null)
			return null;
		if(result.getOcena()==null)
			result.setOcena(new ArrayList<Ocena>());
		return result.getOcena();
	}
	/*Wystawianie oceny */
	
	@POST
	@Path("/{filmyId}/ocena")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOcena(@PathParam("filmyId") int filmyId, Ocena filmy){
		Filmy result = db.get(filmyId);
		if(result==null)
			return Response.status(404).build();
		if(result.getOcena()==null)
			result.setOcena(new ArrayList<Ocena>());
		result.getOcena().add(filmy);
		return Response.ok().build();
	}
	

}
