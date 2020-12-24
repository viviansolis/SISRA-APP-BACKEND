package pe.edu.upeu.SISRA.entity;

public class Usuario {
private int id_usua;
private String username;
private String password;
private String estado;

public Usuario() {
	super();
}
public Usuario(int id_usua, String username, String password, String estado) {
	super();
	this.id_usua = id_usua;
	this.username = username;
	this.password = password;
	this.estado = estado;
}
public int getId_usua() {
	return id_usua;
}
public void setId_usua(int id_usua) {
	this.id_usua = id_usua;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}



}
