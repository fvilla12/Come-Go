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
    protected ItemMenu itemMenu;
    
    /**
     * Crea una nueva instancia de Hamburguesa para empezar a trabajar.
     */
    public void crearNuevaHamburguesa() {
        this.hamburguesa = new Hamburguesa(itemMenu);
    }
    
    /**
     * Devuelve el producto complejo que se construye.
     *
     * @return Producto Hamburguesa.
     */
    public Hamburguesa getHamburguesa() {
        return hamburguesa;
    }
    
    // Pasos abstractos que cada receta concreta debe implementar a su manera
    public abstract void configurarEstilo();
    public abstract void prepararPan();
    public abstract void prepararCarne();
    public abstract void prepararSalsa();
    public void añadirNota(String nota){
        this.hamburguesa.setNotaCocina(nota);
    }
}
