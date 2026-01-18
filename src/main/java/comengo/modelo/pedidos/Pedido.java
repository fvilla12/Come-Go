/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comengo.modelo.pedidos;

import comengo.modelo.producto.IPlato;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un pedido genérico.
 * <p>
 * Define los atributos comunes como el ID, el estado y la lista de productos.
 * Actúa como el <b>Producto Abstracto</b> en el patrón Factory Method.
 * </p>
 * @author fernando
 */
public abstract class Pedido {
    
    private final String id;
    private String estado;
    protected List<IPlato> productos;
    
    /**
     * Constructor base para un pedido.
     * @param id Identificador único del pedido.
     */
    public Pedido(String id) {
        this.id = id;
        this.estado = "Recibido"; // Estado inicial por defecto.
        this.productos = new ArrayList<>();
    }
    
    /**
     * Añade un plato personalizado al pedido.
     * @param producto Objeto que implementa la interfaz Plato.
     */
    public void añadirProducto(IPlato producto) {
        if (producto != null) {
            this.productos.add(producto);
        }
    }
    
    /**
     * Método abstracto para calcular el total, permitiendo que cada tipo 
     * de pedido añada sus propios costes (ej. envío).
     * @return Importe total en euros.
     */
    public abstract double calcularTotal();

    public String getId() {
        return id;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<IPlato> getProductos() {
        return productos;
    }
}
