package main.java.corp.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Proyecto {
	
	private String idProyecto;
	private List<Hito> hitos;
	private String estado;
	private String prioridad;
	private Date fechaInicio;
	private Date fechaEstimadaFin;
	private Date fechaFin;
	private ArrayList<Trabajador> trabajadores;
	
	public Proyecto(String idProyecto) {
		this.idProyecto = idProyecto;
		this.hitos = new ArrayList<Hito>();
		Calendar calendar = Calendar.getInstance();
		this.fechaInicio = calendar.getTime();
		this.prioridad="Baja";
		this.estado = "Active";
		this.trabajadores = new ArrayList<Trabajador>();
	}

	public Hito crearHito(String id, Date fEstimadaEntrega, int costoEstimado) {
		Hito hito = new Hito(id,fEstimadaEntrega,costoEstimado);
		this.hitos.add(hito);
		return hito;
	}
	public Hito obtenerHito(String id) {
        Hito hitoBuscado = null;
        for (Hito hito: this.hitos) {
            if (hito.getid().equals(id)) {
                hitoBuscado = hito;
            }
        }
		return hitoBuscado;
	}
	public void setearCostoRealHito(String id, int cReal) {
        Hito hitoBuscado = null;
        for (Hito hito: this.hitos) {
            if (hito.getid() == id) {
                hitoBuscado = hito;
            }
        }
        if (hitoBuscado != null)
        	hitoBuscado.setCostoReal(cReal);	
	}

	public int calcularCostoTotal() {
		int costoTotal = 0;
		for (Hito hito: this.hitos) {
			costoTotal += hito.getCostoReal();
	    }
		return costoTotal;
	}

	public int calcularCostoEstimado() {
		int costoEstimado = 0;
		for (Hito hito: this.hitos) {
			costoEstimado += hito.getCostoEstimado();
	    }
		return costoEstimado;
	}
	
	public void setFechaFinalizacionEstimada(Date fechaEstimadaFin) {
		this.fechaEstimadaFin = fechaEstimadaFin;
	}


	public void marcarFinalizado() {
		this.estado = "Finalizado";
		Calendar calendar = Calendar.getInstance();
		this.fechaFin = calendar.getTime();
	}

	public Date getFechaRealFinalizacion() {
	 	return this.fechaFin;
	}

	public Date getFechaEstimadaFinalizacion() {
	 	return this.fechaEstimadaFin;
	}

	public void agregarTrabajador(Trabajador trabajador) {
		this.trabajadores.add(trabajador);
		
	}
	
	public String getId() {
		return idProyecto;
	}

	public ArrayList<Trabajador> getTrabajadores() {
		return this.trabajadores;
	}

	
}
