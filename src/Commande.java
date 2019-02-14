import java.text.DecimalFormat;
import java.text.NumberFormat;

//*********************************************************************
//
// Programmeur : Maxime Dery et Hamza Nassime
// Date : 13 février 2019
// Fichier : Commande.java
//
//*********************************************************************

public class Commande {
	private Clients client;
	private Plats plat;
	private int quantite;

	public Commande(Clients client, Plats plat, int quantite) {
		this.client = client;
		this.plat = plat;
		this.quantite = quantite;
	}

	public boolean Contains(Clients client) {
		return this.client.Equals(client);
	}

	public Plats getPlat() {
		return this.plat;
	}

	public Clients getClient() {
		return this.client;
	}

	public int getQuantitePlat() {
		return this.quantite;
	}

	public String getFacture() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(getPlat().getPrix() * getQuantitePlat());
	}
}
