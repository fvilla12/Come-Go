/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.producto;

import java.util.Map;

/**
 * Decorador concreto que añade "Extra de Queso" a un plato.
 * <p>
 * Este modificador aumenta el precio final del producto y actualiza 
 * la descripción para que el cliente y la cocina vean el extra solicitado.
 * </p>
 * @author fernando
 */
public class ExtraQueso extends DecoradorPlato {
    
    // Precio adicional por el extra de queso
    private static final double PRECIO_EXTRA = 1.25;

    /**
     * Crea un nuevo decorador de queso extra para el plato indicado.
     * @param plato El plato (u otro decorador) que se va a envolver.
     */
    public ExtraQueso(IPlato plato) {
        super(plato);
    }
    
    /**
     * Añade la mención del extra a la descripción del plato envuelto.
     * @return Descripción original seguida de ", con Extra de Queso".
     */
    @Override
    public String getDescripcion() {
        return platoDecorado.getDescripcion() + ", con Extra de Queso";
    }

    /**
     * Suma el precio del extra al precio del plato envuelto.
     * @return El precio acumulado hasta el momento más el precio del queso.
     */
    @Override
    public double getPrecio() {
        return platoDecorado.getPrecio() + PRECIO_EXTRA;
    }
    
    @Override
    public Map<String, Integer> getIngredientes() {
        Map<String, Integer> requisitos = platoDecorado.getIngredientes();
        requisitos.put("Queso", requisitos.getOrDefault("Queso", 0) + 1);
        return requisitos;
    }
}
