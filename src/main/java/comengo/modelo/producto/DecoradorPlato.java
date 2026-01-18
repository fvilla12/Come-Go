/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.producto;

/**
 * Clase base abstracta para todos los decoradores de platos.
 * <p>
 * Implementa el patrón <b>Decorator</b>. Su función es mantener una referencia
 * a un objeto de tipo {@link Plato} para poder añadirle funcionalidades o 
 * atributos (como extras) de forma dinámica sin modificar la clase original.
 * </p>
 * @author fernando
 */
public abstract class DecoradorPlato implements IPlato {
    
    protected IPlato platoDecorado;
    
    /**
     * Constructor que recibe el plato a envolver.
     * @param plato El objeto {@link Plato} al que se le añadirá el extra.
     */
    public DecoradorPlato(IPlato plato) {
        this.platoDecorado = plato;
    }
    
    @Override
    public String getDescripcion() {
        return platoDecorado.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return platoDecorado.getPrecio();
    }
}
