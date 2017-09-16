package test.java.corp.core;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import main.java.corp.core.Producto;
import main.java.corp.core.Proyecto;
import main.java.corp.core.Hito;
import main.java.corp.core.Requerimiento;
import main.java.corp.core.Tarea;
import main.java.corp.core.Trabajador;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Productodefs {
	
	private Producto producto;
	private Proyecto proyecto;
	private String uniqueName;

	@Dado("^que \"(.*?)\" trabajo en el proyecto \"(.*?)\" y \"(.*?)\" en el proyecto \"(.*?)\"$")
	public void que_trabajo_en_el_proyecto_y_en_el_proyecto(String trabajador1, String proyecto1, String trabajador2, String proyecto2) throws Throwable {
   	 	this.producto = new Producto("CRM");
   	 	Proyecto proyecto_10 = new Proyecto(proyecto1);
   	 	Proyecto proyecto_11 = new Proyecto(proyecto2);
   	 	Trabajador juan = new Trabajador(trabajador1);
   	 	Trabajador pedro = new Trabajador(trabajador2);
   	 	proyecto_10.agregarTrabajador(pedro);
   	 	proyecto_11.agregarTrabajador(juan);
   	 	this.producto.agregarProyecto(proyecto_10);
   	 	this.producto.agregarProyecto(proyecto_11);
   	 	
	}

	@Cuando("^quiero saber quien trabajo en el producto \"(.*?)\"$")
	public void quiero_saber_quien_trabajo_en_el_producto(String producto) throws Throwable {
		this.uniqueName = producto;
	}

	@Entonces("^en el producto trabajo \"(.*?)\" y \"(.*?)\"$")
	public void en_el_producto_trabajo_y(String trabajador1, String trabajador2) {
		ArrayList<Trabajador> trabajadores = this.producto.determinarTrabajadores(this.uniqueName);
		String resultado =  trabajador2+" " + trabajador1;
		String test="";
		for (Trabajador trabajador: trabajadores) {
			test +=trabajador.getNombre();
			test +=" ";
		}
		test = test.trim();
		assertEquals(resultado,test);
		
	}

	@Dado("^que \"(.*?)\" trabajo \"(.*?)\" horas para la tarea \"(.+?)\" del requerimiento no funcional \"(.*?)\" del hito \"(.+?)\" del proyecto \"(.*?)\"$")
	public void que_trabajo_horas_para_la_tarea_del_requerimiento_no_funcional_del_proyecto(String nom_trabj, String horas, String nom_tarea, String nom_req, String nom_hito, String nom_proyecto) throws Throwable {
		/*
		crear trabajador, tarea (horas, titulo),
		requerimiento (no func, titulo, proy)
		crear proyecto (titulo)
		*/

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_est = sdf.parse("2017-06-29");
		this.proyecto = new Proyecto(nom_proyecto);
		
		Hito hito = this.proyecto.crearHito(nom_hito, fecha_est, 100);
		Requerimiento req = hito.agregarRequerimiento(hito, nom_req, false);
		
		Tarea tarea = req.agregarTarea(nom_tarea, Integer.parseInt(horas));

		Trabajador trabj = new Trabajador(nom_trabj);
		trabj.trabajarEnTarea(tarea, Integer.parseInt(horas));
	}

	@Cuando("^pido quien trabajo en el requerimiento \"(.*?)\" del hito \"(.+?)\" del proyecto \"(.*?)\"$")
	public void pido_quien_trabajo_en_el_requerimiento_del_proyecto(String nom_req, String nom_hito, String nom_proy) throws Throwable {
		Hito h = this.proyecto.obtenerHito(nom_hito);
		Requerimiento req = h.obtenerRequerimiento(nom_req);
		ArrayList<Trabajador> quienTrabajo = req.obtenerQuienesTrabajaron();
		//quien trabajo != quienes trabajaron
		assertTrue(quienTrabajo.size() == 1);
		this.uniqueName = quienTrabajo.get(0).getNombre();
	}

	@Entonces("^el que trabajo fue \"(.*?)\"$")
	public void el_que_trabajo_fue(String trabajador) throws Throwable {
		assertEquals(this.uniqueName, trabajador);
	}

}
