/**
 * @author Axel Mastroianni Simone Pitossi Luigi Amarante
 * @version 1.0
 * questa classe gestisce l'intera olimpiade gestendo tutte le gare
 * sono caricate inoltre tutte le nazioni partecipanti alle olimpiadi
 */
package il.nostro.medagliere.olimpico;
import java.util.*;
public class Olimpiade {
	private String nome="";
	private ArrayList<Gara> discipline=new ArrayList<Gara>();
	private ArrayList<Nazione> iscritte=new ArrayList<Nazione>();

	public Olimpiade(String nome) {
		this.nome=nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
	
	public void aggiungiNazione(Nazione n) {
		iscritte.add(n);
	}
	public void aggiungiDisciplina(Gara g) {
		discipline.add(g);
	}
	/**
	 * 
	 * @param nome
	 * @return true or false vero se c'è altrimenti falso
	 * controlla se la nazione inserita è già presente oppure no
	 */
	public boolean controllaPresenzaNazione(String nome) {
		for(int i=0;i<iscritte.size()-1;i++) {
			if(iscritte.get(i).getNome().equals(nome))
				return true;
		}
		return false;
	}
	/**
	 * 
	 * @param nome
	 * @return true or false vero se c'è altrimenti falso
	 * controlla se la gara inserita è presente oppure no
	 */
	public boolean controllaNomeGara(String nome) {
		for(int i=0;i<discipline.size();i++) {
			if(discipline.get(i).getNomeGara().equals(nome))
				return true;
		}
		return false;
	}
	
	public void visualizzaMedagliere() {
		System.out.println("NOME \tORI \tARGENTI \tBRONZI");
		for(int i=0;i<iscritte.size();i++) {
			System.out.printf("%s \t%d \t%d	\t%d%n",iscritte.get(i).getNome(),iscritte.get(i).getNumOri(),
					iscritte.get(i).getNumArgenti(),iscritte.get(i).getNumBronzi());
		}
	}
	/**
	 * 
	 * @param n1
	 * @param n2
	 * @return true or false vero se vince la nazione 1 altrimenti falso
	 */
	private boolean controllaMedaglie(Nazione n1, Nazione n2) {
		//gli ori della prima sono di più di quelli della seconda?
		if(n1.getNumOri()>n2.getNumOri())
			return true;
		//se gli ori sono uguali confronta gli argenti
		else if(n1.getNumOri()==n2.getNumOri() && n1.getNumArgenti()>n2.getNumArgenti())
			return true;
		//se anche loro sono uguali confronta i bronzi
		else if(n1.getNumOri()==n2.getNumOri() && n1.getNumArgenti()==n2.getNumArgenti() && n1.getNumBronzi()>n2.getNumBronzi())
			return true;
		//vuol dire che la nazione 2 ha più ori/argenti/bronzi
		else
			return false;
	}
	public void ordinaPerOri() {
		for(int i=0;i<iscritte.size();i++) {
			//confronta una nazione con tutte le altre
			for(int j=i+1;j<iscritte.size();j++) {
				//controllo sulle medaglie di due nazioni della lista
				if(controllaMedaglie(iscritte.get(j),iscritte.get(i))) {
					Nazione tmp=iscritte.get(i);
					iscritte.set(i, iscritte.get(j));
					iscritte.set(j, tmp);
				}
			}
		}
	}
	public Nazione getNazione(int indice) {
		return iscritte.get(indice);
	}
	//si da per scontato che la nazione "doppiona" sia in ultima posizione
	public void rimuoviNazione() {
		iscritte.remove(iscritte.get(iscritte.size()-1));
	}
	/**
	 * 
	 * @param indice
	 * @return Gara 
	 * ritorna la gara all'indice indicato
	 */
	public Gara getGara(int indice) {
		return discipline.get(indice);
	}
	//serve per il metodo controllaNomeGara
	public void rimuoviGara() {
		//si da per scontato che la gara inserita sia in coda all'ArrayList
		discipline.remove(discipline.get(discipline.size()-1));
	}
	/**
	 * 
	 * @return ArrayList<Nazione>
	 * mischia l'ArrayList delle nazioni prima di una gara
	 */
	public ArrayList<Nazione> mischiaNazioni() {
		Collections.shuffle(iscritte);
		return iscritte;
	}
	public void visualizzaNazioni() {
		for(int i=0;i<iscritte.size();i++)
			System.out.println(iscritte.get(i).getNome());
	}
	public void visualizzaGare() {
		for(int i=0;i<discipline.size();i++)
			System.out.println(discipline.get(i).getNomeGara());
	}
	
	
}
