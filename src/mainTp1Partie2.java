import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

//*********************************************************************
//
// Programmeur : Maxime Dery et Hamza Nassime
// Date : 13 février 2019
// Fichier : mainTp1Partie2.java
//
//*********************************************************************

public class mainTp1Partie2 {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		ArrayList<Clients> listClients = new ArrayList<Clients>();
		ArrayList<Plats> listPlats = new ArrayList<Plats>();
		ArrayList<Commande> listCommandes = new ArrayList<Commande>();
		String nomFicCommande = "fichierCommande.txt";
		String nomFicFacture = "fichierFacture.txt";

		BufferedReader ficLecture;

		try {
			String ancienneLigne = null;
			String ligneActuelle = null;
			ficLecture = new BufferedReader( new FileReader( nomFicCommande ) );

			while ( ( ligneActuelle = ficLecture.readLine() ) != null ) {

				if ( ligneActuelle.endsWith( ":" ) ) {

					ancienneLigne = ligneActuelle.replace( " :", "" );

				} else if ( ancienneLigne.equals( "Clients" ) ) {

					Clients client = new Clients( ligneActuelle );
					listClients.add( client );

				} else if ( ancienneLigne.equals( "Plats" ) ) {

					Plats plat = new Plats( ligneActuelle.split( " " )[0],
							Double.parseDouble( ligneActuelle.split( " " )[1] ) );
					listPlats.add( plat );

				} else if ( ancienneLigne.equals( "Commandes" ) ) {

					for ( Clients client : listClients ) {

						if ( client.getNom().equals( ligneActuelle.split( " " )[0] ) ) {

							for ( Plats plat : listPlats ) {

								if ( plat.Equals( ligneActuelle.split( " " )[0] ) ) {

									Commande commande = new Commande( client, plat,
											Integer.parseInt( ligneActuelle.split( " " )[2] ) );
									listCommandes.add( commande );
									break;
								}
							}
						}
					}
				}
			}

			System.out.println( " " );
		} catch ( Exception e ) {

			try {
				BufferedWriter ficEcriture = new BufferedWriter( new FileWriter( nomFicFacture ) );
				ficEcriture.write( "Erreur de lecture. Assurez-vous que le format est correct." );
				System.out.println( "Erreur de lecture. Assurez-vous que le format est correct." );
				ficEcriture.close();
				System.exit( 0 );
			} catch ( Exception e2 ) {
				// TODO: handle exception

			}

		}

		BufferedWriter ficEcriture = null;

		try {
			ficEcriture = new BufferedWriter( new FileWriter( nomFicFacture ) );
			ficEcriture.write( "Bienvenue chez Barette !\r\n" + "Factures :" );
			System.out.println( "Bienvenue chez Barette !\r\n" + "Factures :" );

		} catch ( Exception e2 ) {
			// TODO: handle exception
		}

		try {
			for ( Clients clientCourrant : listClients ) {
				ficEcriture.write( clientCourrant.getNom() + ": " );
				System.out.println( clientCourrant.getNom() + ": " );

				for ( Commande commande : listCommandes ) {
					if ( commande.Contains( clientCourrant ) ) {
						ficEcriture.write( commande.getFacture() + "$\n" );
						System.out.println( commande.getFacture() + "$\n" );
						break;
					} else if ( commande == listCommandes.get( listCommandes.size() - 1 ) ) {
						ficEcriture.write( "0.00$\n" );
						System.out.println( "0.00$\n" );
					}
				}
			}
			ficEcriture.close();
		} catch ( Exception e2 ) {
			// TODO: handle exception
		}
	}

}
