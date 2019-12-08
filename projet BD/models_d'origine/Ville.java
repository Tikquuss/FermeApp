package models;

public class Ville {

	private int idVille = 0;
	private String nomV;
	private String agenceExpedition;
	private float montantExpedition = 0;

	public int getIdVille() {
		return this.idVille;
	}

	public String getNomV() {
		return this.nomV;
	}

	/**
	 * 
	 * @param idVille
	 */
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	/**
	 * 
	 * @param nomV
	 */
	public void setNomV(String nomV) {
		this.nomV = nomV;
	}

	public String getAgenceExpedition() {
		return this.agenceExpedition;
	}

	/**
	 * 
	 * @param agenceExpedition
	 */
	public void setAgenceExpedition(String agenceExpedition) {
		this.agenceExpedition = agenceExpedition;
	}

	public float getMontantExpedition() {
		return this.montantExpedition;
	}

	/**
	 * 
	 * @param montantExpedition
	 */
	public void setMontantExpedition(float montantExpedition) {
		this.montantExpedition = montantExpedition;
	}

}