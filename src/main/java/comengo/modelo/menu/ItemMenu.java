/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.menu;

import comengo.modelo.inventario.GestorInventario;
import java.util.Collections;
import java.util.Map;

/**
 * Representa un plato individual o elemento final en el menú del restaurante.
 * <p>
 * En el patrón <b>Composite</b>, esta clase actúa como el nodo <b>Hoja (Leaf)</b>.
 * No contiene otros componentes, sino que define el comportamiento concreto de un ítem vendible.
 * </p>
 * <p>
 * Mantiene la información requerida por el sistema: ID, nombre, descripción, precio, 
 * fotografía y la lista de ingredientes necesarios para su elaboración, la cual se 
 * utiliza para verificar la disponibilidad contra el {@link GestorInventario}.
 * </p>
 *
 * @author fernando
 * @version 1.0
 */
public class ItemMenu implements IComponenteMenu {
    
    private final String id;
    private final String nombre;
    private final String descripcion;
    private final double precioBase;
    private final String imagenURL;
    private final boolean esSinGluten;
    private final Map<String, Integer> ingredientesRequeridos;
    
    /**
     * Constructor completo para dar de alta un plato.
     *
     * @param id            Identificador único interno (ej. "P-001").
     * @param nombre        Nombre comercial del plato.
     * @param descripcion   Descripción detallada para el cliente.
     * @param precioBase    Precio base en euros.
     * @param imagenURL     Ruta relativa o URL de la imagen del plato.
     * @param esSinGluten   Indicador de alérgenos (true si es apto).
     * @param ingredientes  Mapa de ingredientes necesarios para cocinar una unidad.
     */
    public ItemMenu(String id, String nombre, String descripcion, double precioBase, 
                   String imagenURL, boolean esSinGluten, Map<String, Integer> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.imagenURL = imagenURL;
        this.esSinGluten = esSinGluten;
        // Guardamos una copia inmutable para evitar modificaciones accidentales externas
        this.ingredientesRequeridos = (ingredientes != null) 
                                      ? Map.copyOf(ingredientes) 
                                      : Collections.emptyMap();
    }
    
    /**
     * Obtiene el identificador interno del plato.
     * @return El ID del plato.
     */
    public String getId() {
        return id;
    }
    
    /**
     * Obtiene la URL de la imagen del plato.
     * @return Cadena con la ruta de la imagen.
     */
    public String getImagenURL() {
        return imagenURL;
    }
    
    /**
     * Obtiene los ingredientes necesarios para preparar este plato.
     * @return Mapa inmutable con los ingredientes y sus cantidades.
     */
    public Map<String, Integer> getIngredientesRequeridos() {
        return ingredientesRequeridos;
    }
    
    /**
     * Consulta al Singleton de Inventario si hay stock suficiente para este plato.
     * <p>
     * Este método es útil para que la Vista (UI) sepa si debe habilitar o 
     * deshabilitar el botón de "Añadir al pedido" en tiempo real.
     * </p>
     *
     * @return {@code true} si hay ingredientes suficientes en el almacén.
     */
    public boolean estaDisponible() {
        return GestorInventario.getInstance().hayStockSuficiente(ingredientesRequeridos);
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean esSinGluten() {
        return esSinGluten;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %.2f€ (%s)", nombre, precioBase, 
                             estaDisponible() ? "Disponible" : "Agotado");
    }
}
