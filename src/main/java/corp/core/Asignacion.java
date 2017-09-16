package main.java.corp.core;
public class Asignacion {
	Tarea tarea;
	public Trabajador trabajador;
	int horas;
	public Asignacion(Tarea ta, Trabajador tr, int h) {
		this.tarea = ta;
		this.trabajador = tr;
		this.horas = h;
	}
}
