//*********************************************************************
//
// Programmeur : Maxime Dery et Hamza Nassime
// Date : 13 f�vrier 2019
// Fichier : Clients.java
//
//*********************************************************************

public class Clients{
	private String nom;

	public Clients(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public boolean Equals(Clients clientComparer) {
		return nom.equals( clientComparer.getNom() );
	}
}