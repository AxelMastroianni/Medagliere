package il.nostro.medagliere.olimpico;
import java.util.*;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
public class LeOlimpiadi {
	public static Nazione inserisciNazione() {
		String nome=InputDati.leggiStringaNonVuota("Inserisci una nazione: ");
		return new Nazione(nome);
	}
	public static double inserisciMaxPunteggio() {
		double maxPunteggio=InputDati.leggiDouble("Inserisci il massimo punteggio della gara scelta: ");
		return maxPunteggio;
	}
	public static Gara inserisciGara() {
		String nomeGara=InputDati.leggiStringaNonVuota("Inserisci il nome della gara: ");
		return new Gara(nomeGara);
	}
	public static Olimpiade inserisciOlimpiade(){
		String nomeOlimpiade=InputDati.leggiStringaNonVuota("Inserisci il nome dell'Olimpiade: ");
		return new Olimpiade(nomeOlimpiade);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tastiera=new Scanner(System.in);
		Random r=new Random();
		String risposta="";
		int contaNazioni=0, contaGare=0;
		final String[] voci= {"Inserisci una nuova nazione","Inserisci una nuova gara","Fai una gara","Visualizza Medagliere",
				"Visualizza Nazioni","Visualizza Gare"};
		MyMenu menu=new MyMenu("Le Olimpiadi",voci);
		Olimpiade olimpiade=new Olimpiade("OlimpycMonogatari");
		System.out.println("COMINCIANO LE OLIMPIADI!");	
		while(!risposta.equalsIgnoreCase("no")) {
			int scegli=menu.scegli();
			switch(scegli) {
			case 1:{
				olimpiade.aggiungiNazione(inserisciNazione());
				//controlla che la nazione non esista altrimenti rimuovila
				//la gara riempie l'ArrayList di iscritte poi nel caso viene rimossa
				if(!olimpiade.controllaPresenzaNazione(olimpiade.getNazione(contaNazioni).getNome()))
					contaNazioni++;
				else
					olimpiade.rimuoviNazione();
				break;
			}
			case 2: {
				Gara garaInserita=inserisciGara();
				//idem per il case 1
				if(!olimpiade.controllaNomeGara(garaInserita.getNomeGara())) {
					olimpiade.aggiungiDisciplina(garaInserita);
					contaGare++;
				}
				else
					olimpiade.rimuoviGara();
				break;
			}
			case 3:{
				String nomeGara=InputDati.leggiStringaNonVuota("Quale gara vuoi fare? ");
				if(olimpiade.controllaNomeGara(nomeGara)) {
					Gara gara=new Gara(nomeGara);
					gara.setPartecipanti(olimpiade.mischiaNazioni());
					double maxPunteggio=InputDati.leggiDouble("Qual è il massimo punteggio raggiungibile? ");
					gara.impostaPunteggio(maxPunteggio);
					gara.ordinaPunteggiNazioni();
					gara.stampaPunteggiNazioni();
					System.out.println("Hanno vinto: ");
					gara.visualizzaVincitori();
					gara.aumentaMedaglie();
			}
				else
					System.out.println("Gara inesistente");
				break;
			}
			case 4:{
				olimpiade.ordinaPerOri();
				olimpiade.visualizzaMedagliere();
				break;
			}
			case 5:
				olimpiade.visualizzaNazioni(); break;
			case 6: olimpiade.visualizzaGare(); break;
		}
			risposta=InputDati.leggiStringaNonVuota("Continui le olimpiadi?" );
		}
		System.out.println("Le olimpiadi si sono concluse: ecco il medagliere");
		olimpiade.visualizzaMedagliere();
	}
}

