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

public class Costodefs {
	private String idProyecto = "TPI-AR-2017-W1234";
	private Proyecto proyecto;

@Dado("^que mi proyecto tiene 3 hitos con costos estimados de \"(.*?)\" pesos \"(.*?)\" pesos y \"(.*?)\" pesos$")
public void que_mi_proyecto_tiene_hitos_con_costos_estimados_de_pesos_pesos_y_pesos(int cEstimado1, int cEstimado2, int cEstimado3) throws Throwable {
	this.proyecto = new Proyecto(idProyecto);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String fechaE1 ="2017-06-29"; 
	Date fechaEstimada1 = sdf.parse(fechaE1);

	String fechaE2 ="2017-07-29"; 
	Date fechaEstimada2 = sdf.parse(fechaE2);

	String fechaE3 ="2017-08-29"; 
	Date fechaEstimada3 = sdf.parse(fechaE3);

	proyecto.crearHito("0001",fechaEstimada1,cEstimado1);
	proyecto.crearHito("0002",fechaEstimada2,cEstimado2);
	proyecto.crearHito("0003",fechaEstimada3,cEstimado3);

}

@Cuando("^cuado el costo real de los hitos es \"(.*?)\" pesos, \"(.*?)\" pesos y \"(.*?)\" pesos respectivamente$")
public void cuado_el_costo_real_de_los_hitos_es_pesos_pesos_y_pesos_respectivamente(int cReal1, int cReal2, int cReal3) throws Throwable {
    proyecto.setearCostoRealHito("0001",cReal1);
	proyecto.setearCostoRealHito("0002",cReal2);
	proyecto.setearCostoRealHito("0003",cReal3);
}



@Entonces("^el proyecto es rentable y produce una ganancia extraordinaria de \"(.*?)\" pesos$")
public void el_proyecto_es_rentable_y_produce_una_ganancia_extraordinaria_de_pesos(int remanente) throws Throwable {
    int costoEstimadoTotal = proyecto.calcularCostoEstimado();
    int costoRealTotal = proyecto.calcularCostoTotal();
    boolean proyectoRentable = false;
    if (costoEstimadoTotal>= costoRealTotal)
    	proyectoRentable = true;

    assertTrue(proyectoRentable);
    assertEquals(remanente, costoEstimadoTotal - costoRealTotal);
}

@Entonces("^el proyecto no es rentable y produce una variacion de lo estipulado dee \"(.*?)\" pesos$")
public void el_proyecto_no_es_rentable_y_produce_una_variacion_de_lo_estipulado_dee_pesos(int remanente) throws Throwable {
	int costoEstimadoTotal = proyecto.calcularCostoEstimado();
    int costoRealTotal = proyecto.calcularCostoTotal();
    boolean proyectoRentable = false;
    if (costoEstimadoTotal>= costoRealTotal)
    	proyectoRentable = true;
    assertFalse(proyectoRentable);
    assertEquals(remanente,costoRealTotal-  costoEstimadoTotal);
}


}