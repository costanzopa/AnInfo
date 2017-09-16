package main.java.corp.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Cliente {

	private String cuit;
	private List<Producto> productos;
	
	
	public Cliente(String cuit) {
		this.cuit = cuit;
		this.productos = new ArrayList<Producto>();
	}


	public void agregarProducto(String nombre_producto, String version) {
		Producto producto = new Producto(nombre_producto,version);
		this.productos.add(producto);
	}


	public Producto obternerProducto(String nombre) {
		Producto productoBuscado = null;
	    for (Producto producto: this.productos) {
	    	if ((producto.obtenerNombre()).equals(nombre)) {
	    		productoBuscado = producto;
	        }
	    }
	    return productoBuscado;
	}

}
