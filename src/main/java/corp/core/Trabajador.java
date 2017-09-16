package main.java.corp.core;

public class Trabajador {
	private String nombre;

	public Trabajador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	//Actualmente no es necesario el metodo agregar horas a tarea,
	//por eso simplemente tenemos un metodo que crea la asignacion.
	//Incluso, aprovechando el double dispatch, tarea podria ser la responsable
	//de saber que ya existe una asignacion para ese trabajador.
	public void trabajarEnTarea(Tarea t, int horas) {
		t.crearAsignacion(this, horas);
	}
}
