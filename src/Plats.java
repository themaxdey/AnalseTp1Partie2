//*********************************************************************
//
// Programmeur : Maxime Dery et Hamza Nassime
// Date : 13 février 2019
// Fichier : Plats.java
//
//*********************************************************************

public class Plats{
	private String nomPlat;
	private double prix = 0.0;

	public Plats(String nomPlat, double prix) {
		this.nomPlat = nomPlat;
		this.prix = prix;
	}

	public double getPrix() {
		return this.prix;
	}

	public boolean Equals(String string) {
		return nomPlat.equals(string.toString());
	}
}