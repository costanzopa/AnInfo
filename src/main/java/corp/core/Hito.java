package main.java.corp.core;

import java.util.Date;
import java.util.ArrayList;

public class Hito {
	
	private String id;
	private Date fechaEntregaEstimada;
	private Date fechaEntregaReal;
	private int costoEstimado;
	private int costoReal;
	private ArrayList<Requerimiento> requerimientos;

	public Hito(String id, Date fEstimadaEntrega, int costoEstimado) {
		this.id = id;
		this.fechaEntregaEstimada =fEstimadaEntrega;
		this.costoEstimado = costoEstimado;
		this.costoReal = -1;
		this.requerimientos = new ArrayList<Requerimiento>();
	}

	public String getid() {
		return this.id;
	}

	public void setCostoReal(int cReal) {
		this.costoReal = cReal;
	}

	public int getCostoEstimado() {
		return this.costoEstimado;
	}

	public int getCostoReal() {
		return this.costoReal;
	}
	public Requerimiento agregarRequerimiento(Hito h, String nombre, boolean esfunc) {
		Requerimiento r = new Requerimiento(h, nombre, esfunc);
		this.requerimientos.add(r);
		return r;
	}
	public Requerimiento obtenerRequerimiento(String titulo) {
		for(Requerimiento r : this.requerimientos) {
			if(r.titulo == titulo)
				return r;
		}
		return null;
	}

}
