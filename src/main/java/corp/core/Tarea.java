package main.java.corp.core;
import java.util.ArrayList;

public class Tarea {
	boolean esFuncional;
	public String titulo;
	Requerimiento requerimiento;
	private ArrayList<Asignacion> asignaciones;
	int horas_estim;

	public Tarea(Requerimiento r, String nombre, int horas_estim) {
		this.requerimiento = r;
		this.titulo = nombre;
		this.horas_estim = horas_estim;
		this.asignaciones = new ArrayList<Asignacion>();
	}
	public void crearAsignacion(Trabajador t, int h) {
		Asignacion asig = new Asignacion(this, t, h);
		this.asignaciones.add(asig);
	}
	public ArrayList<Trabajador> obtenerQuienesTrabajaron() {
		ArrayList<Trabajador> trabajadores_tarea = new ArrayList<Trabajador>();
		for(Asignacion asig : this.asignaciones) {
			if(!trabajadores_tarea.contains(asig.trabajador)) {
				trabajadores_tarea.add(asig.trabajador);
			}
		}
		return trabajadores_tarea;
	}


}
