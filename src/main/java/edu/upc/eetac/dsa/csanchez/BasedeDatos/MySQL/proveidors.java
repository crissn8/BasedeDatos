package edu.upc.eetac.dsa.csanchez.BasedeDatos.MySQL;

public class proveidors {
	public proveidors(int pieza, String provider, int precio) {
		super();
		this.pieza = pieza;
		this.provider = provider;
		this.precio = precio;
	}
public proveidors(){
	this.pieza=0;
	this.provider="";
	this.precio=0;
}
int pieza;
public int getPieza() {
	return pieza;
}
public void setPieza(int pieza) {
	this.pieza = pieza;
}
public String getProvider() {
	return provider;
}
public void setProvider(String provider) {
	this.provider = provider;
}
public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
String provider;
int precio;
	
}
