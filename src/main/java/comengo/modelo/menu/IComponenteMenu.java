/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comengo.modelo.menu;

/**
 * Interfaz común para el patrón <b>Composite</b>.
 * <p>
 * Define el contrato que deben cumplir tanto los elementos individuales ({@link ItemMenu})
 * como los contenedores ({@link Categoria}). Permite tratar a platos individuales y 
 * a jerarquías completas de menús de manera uniforme.
 * </p>
 * @author fernando
 */
public interface IComponenteMenu {
    
    /**
     * Obtiene el nombre del plato o de la categoría.
     * @return El nombre descriptivo.
     */
    public String getNombre();
    
    /**
     * Obtiene el precio del componente.
     * <p>
     * En un plato individual, es su precio base.
     * En una categoría, podría ser 0 o la suma de sus elementos (según lógica de negocio).
     * </p>
     * @return El precio en euros.
     */
    public double getPrecio();
    
    /**
     * Obtiene una descripción textual del componente.
     * @return Descripción de los ingredientes o del contenido de la categoría.
     */
    public String getDescripcion();
    
    /**
     * Método auxiliar para verificar si el componente es apto para celíacos.
     * Ejemplo de operación recursiva en el patrón Composite.
     * @return true si es libre de gluten.
     */
    public boolean esSinGluten();
}
