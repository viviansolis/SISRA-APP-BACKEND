package pe.edu.upeu.SISRA.entity;

public class Tipo_Asociacion {
	
	private int id_asc_tipo;
	private String nom_tipo;
	private String estado;
	public Tipo_Asociacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tipo_Asociacion(int id_asc_tipo, String nom_tipo, String estado) {
		super();
		this.id_asc_tipo = id_asc_tipo;
		this.nom_tipo = nom_tipo;
		this.estado = estado;
	}
	public int getId_asc_tipo() {
		return id_asc_tipo;
	}
	public void setId_asc_tipo(int id_asc_tipo) {
		this.id_asc_tipo = id_asc_tipo;
	}
	public String getNom_tipo() {
		return nom_tipo;
	}
	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
