package main.java.corp.core;
import java.util.ArrayList;

public class Requerimiento {
	boolean esFuncional;
	public String titulo;
	Hito hito;
	private ArrayList<Tarea> tareas;

	public Requerimiento(Hito h, String nombre, boolean esfunc) {
		this.hito = h;
		this.titulo = nombre;
		this.esFuncional = esfunc;
		this.tareas = new ArrayList<Tarea>();
	}
	public Tarea agregarTarea(String titulo, int horas_estim) {
		Tarea t = new Tarea(this, titulo, horas_estim);
		this.tareas.add(t);
		return t;
	}
	public ArrayList<Trabajador> obtenerQuienesTrabajaron() {
		ArrayList<Trabajador> trabajadores_req = new ArrayList<Trabajador>();
		for(Tarea tarea : this.tareas) {
			ArrayList<Trabajador> trabajadores_tarea = tarea.obtenerQuienesTrabajaron();
			for(Trabajador t : trabajadores_tarea) {
				if(!trabajadores_req.contains(t)) {
					trabajadores_req.add(t);
				}
			}
		}
		return trabajadores_req;
	}

}
