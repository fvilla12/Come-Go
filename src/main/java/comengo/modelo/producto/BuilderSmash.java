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
    public void configurarEstilo() {
        hamburguesa.setEsSmash(true); // Activa el doble de carne en getIngredientes()
    }
    
    @Override
    public void prepararPan() {
        // La Smash siempre usa pan brioche
        hamburguesa.setTipoPan("Pan Brioche Tostado");
    }
    
    @Override
    public void prepararCarne() {
        // La técnica Smash requiere carne aplastada y muy hecha
        hamburguesa.setPuntoCarne("Smash (Muy hecha y crujiente)");
    }
    
    @Override
    public void prepararSalsa() {
        hamburguesa.setSalsa("Salsa Secreta Smash");
    }
}
