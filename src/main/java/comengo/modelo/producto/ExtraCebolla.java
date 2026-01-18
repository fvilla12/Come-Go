/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.producto;

import java.util.Map;

/**
 *  Decorador concreto que añade "Extra de Cebolla" a un plato.
 * <p>
 * Al igual que otros decoradores de esta familia, incrementa el precio final
 * del producto y modifica la descripción textual para informar tanto al 
 * cliente como al personal de cocina.
 * </p>
 * @author fernando
 */
public class ExtraCebolla extends DecoradorPlato {
    
    private static final double PRECIO_EXTRA = 0.50;
    
    /**
     * Crea un nuevo decorador de cebolla extra para el plato indicado.
     * @param plato El objeto {@link Plato} (base o ya decorado) que se va a envolver.
     */
    public ExtraCebolla(IPlato plato) {
        super(plato);
    }

    /**
     * Añade la mención del extra a la descripción del plato envuelto.
     * @return La descripción acumulada del plato seguida de ", con Extra de Cebolla".
     */
    @Override
    public String getDescripcion() {
        return platoDecorado.getDescripcion() + ", con Extra de Cebolla";
    }

    /**
     * Suma el precio del extra al coste total del plato envuelto.
     * @return El precio total incluyendo este ingrediente adicional.
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
