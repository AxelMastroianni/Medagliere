/**
 * @author Axel Mastroianni Simone Pitossi Luigi Amarante
 * @version 1.0
 * questa classe serve per inizializzare una gara dando anche dei punteggi a 
 * ciascuna nazione in maniera casuale
 * si occupa anche di riordinare i punteggi delle nazioni(selezionando le prime 3) e
 * poi aumenta i loro ori
 */
package il.nostro.medagliere.olimpico;
import java.util.*;
import java.lang.*;
public class Gara {
	public static final int NUMERO_MEDAGLIE=3;
	private String nomeGara="";
	private ArrayList<Double> punteggi=new ArrayList<Double>();
	private ArrayList<Nazione> partecipanti=new ArrayList<Nazione>(); //partecipano alla gara
	private Random r=new Random();
	//metodi getters e setters
	public Gara(String nomeGara) {
		this.nomeGara=nomeGara;
	}
	public void setNomeGara(String nomeGara) {
		this.nomeGara=nomeGara;
	}
	public String getNomeGara() {
		return nomeGara;
	}
	public void aggiungiNazione(Nazione n) {
		partecipanti.add(n);
	}
	/**
	 * 
	 * @param maxPunteggio
	 * aggiunge punteggi casuali alle nazioni
	 */
	public void impostaPunteggio(double maxPunteggio) {
		for(int i=0;i<partecipanti.size();i++) {
			punteggi.add(r.nextDouble()*maxPunteggio);
		}
	}
	/**
	 * ordina i punteggi mettendo in testa le prime tre nazioni
	 */
	public void ordinaPunteggiNazioni() {
		for(int i=0;i<NUMERO_MEDAGLIE;i++) {
			for(int j=i+1;j<punteggi.size();j++) {
				if(punteggi.get(i)<punteggi.get(j)) {
					double tmp=punteggi.get(i);
					punteggi.set(i, punteggi.get(j)); //algoritmo di scambio
					punteggi.set(j, tmp);
					Nazione tmp2=partecipanti.get(i);
					partecipanti.set(i, partecipanti.get(j));
					partecipanti.set(j, tmp2);
				}
			}
		}
	}
	public void stampaPunteggiNazioni() {
		for(int i=0;i<punteggi.size();i++)
			System.out.printf("%.2f \n",punteggi.get(i));
	}
	public void stampaNazioni() {
		for(int i=0;i<partecipanti.size();i++)
			System.out.println(partecipanti.get(i).getNome());
	}
	/*
	 * aumenta le medaglie delle prime 3 classificate
	 */
	public void aumentaMedaglie() {
		partecipanti.get(0).aumentaOri();
		partecipanti.get(1).aumentaArgenti();
		partecipanti.get(2).aumentaBronzi();
	}
	public void visualizzaVincitori() {
		for(int i=0;i<3;i++)
			System.out.println(partecipanti.get(i).getNome());
	}
	public ArrayList<Nazione> getPartecipanti(){
		return partecipanti;
	}
	public void setPartecipanti(ArrayList<Nazione> partecipanti) {
		this.partecipanti=partecipanti;
	}

}
