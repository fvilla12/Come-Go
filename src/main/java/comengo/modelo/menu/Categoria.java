/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una agrupación de platos o subcategorías en el menú del restaurante.
 * <p>
 * En el patrón <b>Composite</b>, esta clase actúa como el nodo <b>Composite</b>.
 * Mantiene una lista de hijos de tipo {@link IComponenteMenu} y delega o agrega
 * operaciones sobre ellos.
 * </p>
 * <p>
 * Ejemplo de uso: Una categoría "Bebidas" que contiene "Refrescos" (Subcategoría)
 * y "Agua Mineral" (ItemMenu).
 * </p>
 *
 * @author fernando
 * @version 1.0
 */
public class Categoria implements IComponenteMenu {
    
    private final String nombre;
    private final String descripcion;
    private final List<IComponenteMenu> componentes;
    
    /**
     * Constructor para crear una nueva categoría.
     *
     * @param nombre      Nombre de la categoría (ej. "Entrantes").
     * @param descripcion Breve descripción del grupo.
     */
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.componentes = new ArrayList<>();
    }
    
    /**
     * Añade un nuevo componente (plato o subcategoría) a esta categoría.
     *
     * @param componente El elemento a añadir.
     */
    public void agregar(IComponenteMenu componente) {
        if (componente != null) {
            componentes.add(componente);
        }
    }
    
    /**
     * Elimina un componente de la categoría.
     *
     * @param componente El elemento a eliminar.
     */
    public void eliminar(IComponenteMenu componente) {
        componentes.remove(componente);
    }
    
    /**
     * Obtiene la lista de hijos para que la Vista pueda iterar y mostrarlos.
     *
     * @return Lista de componentes contenidos.
     */
    public List<IComponenteMenu> getComponentes() {
        return componentes;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * En una categoría organizativa, el precio no suele ser relevante (es 0).
     * <p>
     * Nota: Si esto fuera un "Pack" o "Menú Degustación", aquí implementaríamos
     * la suma de los precios de los hijos:
     * {@code componentes.stream().mapToDouble(IComponenteMenu::getPrecio).sum();}
     * </p>
     *
     * @return 0.0, ya que la categoría en sí misma no se vende, se vende su contenido.
     */
    @Override
    public double getPrecio() {
        return 0.0;
    }
    
    /**
     * Determina recursivamente si toda la categoría es apta para celíacos.
     * <p>
     * Lógica del patrón Composite: Una categoría es "Sin Gluten" solo si 
     * TODOS sus hijos (platos o subcategorías) son "Sin Gluten".
     * </p>
     *
     * @return true si todos los elementos contenidos son aptos.
     */
    @Override
    public boolean esSinGluten() {
        if (componentes.isEmpty()) {
            return false; // Una categoría vacía no aporta información
        }
        for (IComponenteMenu componente : componentes) {
            if (!componente.esSinGluten()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Categoría: " + nombre + " (" + componentes.size() + " elementos)";
    }
}
