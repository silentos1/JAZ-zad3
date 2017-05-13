package zad3.domain;

import java.util.List;

public class Filmy {

	private int id;
	private String nazwa;
	private String Opis_filmu;
	
	
	private List<Komentarz> komentarz;
	private List<Ocena> ocena;
	private List<Aktor> aktor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOpis_filmu() {
		return Opis_filmu;
	}
	public void setOpis_filmu(String opis_filmu) {
		this.Opis_filmu = opis_filmu;
	}
	
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public List<Komentarz> getKomentarz() {
		return komentarz;
	}
	public void setKomentarz(List<Komentarz> komentarz) {
		this.komentarz = komentarz;
	}
	public List<Ocena> getOcena() {
		return ocena;
	}
	public void setOcena(List<Ocena> ocena) {
		this.ocena = ocena;
	}
	public List<Aktor> getAktor() {
		return aktor;
	}
	public void setAktor(List<Aktor> aktor) {
		this.aktor = aktor;
	}
	
	
	
	
}
