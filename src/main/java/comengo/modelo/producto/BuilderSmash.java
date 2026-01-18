/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.producto;

/**
 *
 * @author fernando
 */
public class BuilderSmash extends HamburguesaBuilder {
    
    @Override
    public void buildPan() {
        // La Smash siempre usa pan brioche
        hamburguesa.setTipoPan("Pan Brioche Tostado");
    }
    
    @Override
    public void buildCarne() {
        // La técnica Smash requiere carne aplastada y muy hecha
        hamburguesa.setPuntoCarne("Smash (Muy hecha y crujiente)");
    }
    
    @Override
    public void buildSalsa() {
        hamburguesa.setSalsa("Salsa Secreta Smash");
    }
}
