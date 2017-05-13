package domain.services;

import java.util.ArrayList;
import java.util.List;

import zad3.domain.Filmy;
import zad3.domain.Komentarz;

public class FilmyServices {
	
	private static List<Filmy> db = new ArrayList<Filmy>();
	private static int currentId = 1;
	public List<Filmy> getAll(){
		return db;
	}
	
	public Filmy get(int id){
		for(Filmy f : db){
			if(f.getId()==id)
				return f;
		}
		return null;
	}
	
	public void add(Filmy f){
		f.setId(++currentId);
		db.add(f);
	}

	public void update (Filmy filmy){
		for(Filmy f : db){
			if(f.getId()==filmy.getId()){
				f.setNazwa(filmy.getNazwa());
				f.setOpis_filmu(filmy.getOpis_filmu());
				
			}
		}
	}
	
	public void delete (Komentarz filmy){
		db.remove(filmy);
	}

	
	
}
