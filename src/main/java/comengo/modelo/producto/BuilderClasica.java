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
public class BuilderClasica extends HamburguesaBuilder {

    public BuilderClasica(ItemMenu itemMenu) {
        super(itemMenu);
    }

    @Override
    public void configurarEstilo() {
        hamburguesa.setEsSmash(false);
    }
    
    @Override
    public void añadirNota(String nota) {
        super.añadirNota(nota);
    }

    @Override
    public void prepararSalsa(String salsa) {
        super.prepararSalsa(salsa);
    }

    @Override
    public void prepararCarne(String punto) {
        super.prepararCarne(punto); 
    }

    @Override
    public void prepararPan(String pan) {
        super.prepararPan(pan);
    }

    @Override
    public Hamburguesa getHamburguesa() {
        return super.getHamburguesa();
    }

    @Override
    public void crearNuevaHamburguesa() {
        super.crearNuevaHamburguesa(); 
    }
    
    
}
