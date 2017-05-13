package domain.services;

import java.util.ArrayList;
import java.util.List;

import zad3.domain.Aktor;




public class AktorServices {

	
	private static List<Aktor> db = new ArrayList<Aktor>();
	private static int currentId = 1;
	public List<Aktor> getAll(){
		return db;
	}
	
	public Aktor get(int id){
		for(Aktor a : db){
			if(a.getId()==id)
				return a;
		}
		return null;
	}

	public void add(Aktor a){
		a.setId(++currentId);
		db.add(a);
	}
	
	
	}
	

