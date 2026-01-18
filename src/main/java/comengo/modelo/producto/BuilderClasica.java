/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.producto;

/**
 *
 * @author fernando
 */
public class BuilderClasica extends HamburguesaBuilder {

    @Override
    public void buildPan() {
        hamburguesa.setTipoPan("Pan con Sésamo");
    }

    @Override
    public void buildCarne() {
        // La clásica es al punto por defecto
        hamburguesa.setPuntoCarne("Al punto");
    }

    @Override
    public void buildSalsa() {
        hamburguesa.setSalsa("Ketchup y Mostaza");
    }
}
