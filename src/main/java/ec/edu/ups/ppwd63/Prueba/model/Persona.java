package ec.edu.ups.ppwd63.Prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {
	@Id 
	private int codigo ;
	private String cedula;
	private String nombre;
	private double vdeuda;
	private String mesesdeuda;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getVdeuda() {
		return vdeuda;
	}
	public void setVdeuda(double vdeuda) {
		this.vdeuda = vdeuda;
	}
	public String getMesesdeuda() {
		return mesesdeuda;
	}
	public void setMesesdeuda(String mesesdeuda) {
		this.mesesdeuda = mesesdeuda;
	}
}
