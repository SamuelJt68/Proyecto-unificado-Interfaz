package Logica;

import java.util.ArrayList;

public class Vehiculo {

	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String tipoTransmision;
	private int capacidad;
	private Categoria categoria;
	private Estado estadoActual;
	private ArrayList<Estado> estados;
	
	public Vehiculo(String placa, String marca, String modelo, String color, String tipoTransmision, int capacidad,
			Categoria categoria) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		this.capacidad = capacidad;
		this.categoria = categoria;
		estados = new ArrayList<Estado>();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipoTransmision() {
		return tipoTransmision;
	}

	public void setTipoTransmision(String tipoTransmision) {
		this.tipoTransmision = tipoTransmision;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
		añadirEstado(estadoActual);
	}
	
	public ArrayList<Estado> getEstados(){
		return estados;
	}
	
	public void añadirEstado(Estado estado) {
		estados.add(estado);
	}
}
