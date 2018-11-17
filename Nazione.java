/**
 * @author Axel Mastroianni Simone Pitossi Luigi Amarante
 * @version 1.0
 * questa classe si occupa di creare una nazione e permette di aumentare le sue medaglie
 */
package il.nostro.medagliere.olimpico;

public class Nazione {
	private String nome="";
	private int posizione=0;
	private int numOri=0;
	private int numArgenti=0;
	private int numBronzi=0;
	
	public Nazione(String nome) {
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public int getNumOri() {
		return numOri;
	}

	public void setNumOri(int numOri) {
		this.numOri = numOri;
	}

	public int getNumArgenti() {
		return numArgenti;
	}

	public void setNumArgenti(int numArgenti) {
		this.numArgenti = numArgenti;
	}

	public int getNumBronzi() {
		return numBronzi;
	}

	public void setNumBronzi(int numBronzi) {
		this.numBronzi = numBronzi;
	}
	//metodi che aumentano le medaglie
	public void aumentaOri() {
		int nuoviOri=numOri+1;
		setNumOri(nuoviOri);
	}
	public void aumentaArgenti() {
		int nuoviArgenti=numArgenti+1;
		 setNumArgenti(nuoviArgenti);
	}
	public void aumentaBronzi() {
		int nuoviBronzi=numBronzi+1;
		setNumBronzi(nuoviBronzi);
	}

}
