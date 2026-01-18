/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.producto;

import comengo.modelo.menu.ItemMenu;

/**
 *
 * @author fernando
 */
public abstract class HamburguesaBuilder {
    
    protected Hamburguesa hamburguesa;
    
    /**
     * Crea una nueva instancia de Hamburguesa para empezar a trabajar.
     */
    public void crearNuevaHamburguesa(ItemMenu itemMenu) {
        this.hamburguesa = new Hamburguesa(itemMenu);
    }
    
    public Hamburguesa getHamburguesa() {
        return hamburguesa;
    }
    
    // Pasos abstractos que cada receta concreta debe implementar a su manera
    public abstract void buildPan();
    public abstract void buildCarne();
    public abstract void buildSalsa();
    
    // Paso común (Hook) que puede ser usado por cualquier builder
    public void buildNota(String nota) {
        hamburguesa.setNotaCocina(nota);
    }
    
}
