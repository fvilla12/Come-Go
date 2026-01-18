/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comengo.modelo.producto;

import java.util.Map;

/**
 * Interfaz fundamental que representa un plato servible en un pedido.
 * <p>
 * Es la base para aplicar el patrón <b>Decorator</b>. Tanto el plato principal
 * ({@link PlatoBase}) como los ingredientes extra (Decoradores) implementarán
 * esta interfaz, permitiendo anidar precios y descripciones.
 * </p>
 * 
 * @author fernando
 */
public interface IPlato {
    
    /**
     * Obtiene la descripción completa del plato, incluyendo personalizaciones.
     * @return Descripción del producto.
     */
    String getDescripcion();
    
    /**
     * Calcula el precio final del plato acumulando el precio base y los extras.
     * @return Precio total en euros.
     */
    double getPrecio();
    
    Map<String, Integer> getIngredientes();
    
}
