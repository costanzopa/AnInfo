package test.java.corp.core;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import main.java.corp.core.Proyecto;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Tiempodefs {
	private String idProyecto = "TPI-AR-2017-W1234";
	private Proyecto proyecto;

@Dado("^que mi proyecto tiene una fecha de finalizacion estimada para el \"(.*?)\"$")
public void que_mi_proyecto_tiene_una_fecha_de_finalizacion_estimada_para_el(String fFinalizacionEstimada) throws Throwable {
	this.proyecto = new Proyecto(idProyecto);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fFinalizacionEstimadaD = sdf.parse(fFinalizacionEstimada);
	this.proyecto.setFechaFinalizacionEstimada(fFinalizacionEstimadaD);
}

@Cuando("^la fecha de finalizacion del proyecto es hoy$")
public void la_fecha_de_finalizacion_del_proyecto_es_hoy() throws Throwable {
	this.proyecto.marcarFinalizado();
}

@Entonces("^el proyecto fue estimado correctamente y \"(.*?)\"\\.$")
public void el_proyecto_fue_estimado_correctamente_y(String desvio) throws Throwable {
	Date fechaEstimada = proyecto.getFechaEstimadaFinalizacion();
	Date fechaRealFinalizacion = proyecto.getFechaRealFinalizacion();
	String resultado = "";
	if (fechaEstimada.after(fechaRealFinalizacion)){
		resultado ="no hay desvio";
	}
	assertEquals(resultado,desvio);
}

@Entonces("^el proyecto fue estimado correctamente y \"(.*?)\" de mas de \"(.*?)\" dias\\.$")
public void el_proyecto_fue_estimado_correctamente_y_de_mas_de_dias(String desvio, Integer dias) throws Throwable {
	Date fechaEstimada = proyecto.getFechaEstimadaFinalizacion();
	Date fechaRealFinalizacion = proyecto.getFechaRealFinalizacion();
	String resultadoDesvio = "";
	Boolean diasDesvioResult = false;
	if (fechaRealFinalizacion.after(fechaEstimada)){
		resultadoDesvio ="hay desvio";
	}

	int diasDesvio = (int) ((fechaRealFinalizacion.getTime() - fechaEstimada.getTime())/86400000);
	
	if(diasDesvio >= 7)
		diasDesvioResult = true;

	assertEquals(resultadoDesvio,desvio);
	assertEquals(diasDesvioResult,true);

}

}