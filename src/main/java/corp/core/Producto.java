package main.java.corp.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Producto {

	private String nombre;
	private String version;
	private List<Proyecto> proyectos;
	
	public Producto(String nombre_producto, String version) {
		this.nombre = nombre_producto;
		this.version = version;
	}

	public Producto(String nombre_producto) {
		this.nombre = nombre_producto;
		this.version = "";
		this.proyectos = new ArrayList<Proyecto>();
	}


	public String obtenerNombre() {
		return nombre;
	}

	public String obternerVersion() {
		return version;
	}

	public void agregarProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
		
	}


	public ArrayList<Trabajador> determinarTrabajadores(
			String uniqueName) {
			ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
			for (Proyecto proyecto: this.proyectos) {
				if ((proyecto.getId()).contains(uniqueName)) {
					for (Trabajador trabajador: proyecto.getTrabajadores()){
						trabajadores.add(trabajador);
					}
				}
			}
			return trabajadores;
	}
}
