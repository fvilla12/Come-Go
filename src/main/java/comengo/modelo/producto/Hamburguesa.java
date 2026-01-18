/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.producto;

import comengo.modelo.menu.ItemMenu;
import java.util.*;

/**
 * Implementación concreta de una hamburguesa sin decorar.
 * <p>
 * Actúa como el componente base sobre el que se aplicarán los decoradores.
 * Mantiene una referencia al {@link ItemMenu} original para acceder a los
 * datos base (nombre, precio base, etc.).
 * </p>
 * 
 * @author fernando
 */
public class Hamburguesa implements IPlato {
    
    private final ItemMenu itemMenu;
    
    // La modificación de estos atributos no implican subidas de precio
    private String tipoPan;
    private String puntoCarne;
    private String salsa;
    private String notaCocina;
    
    /**
     * Constructor protegido. Se debe utilizar {@link HamburguesaBuilder} para instanciar.
     * @param itemMenu La definición del plato en el catálogo.
     */
    protected Hamburguesa(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
        this.tipoPan = "Estándar";
        this.puntoCarne = "Al punto";
        this.salsa = "Ninguna";
        this.notaCocina = "";
    }
    
    // Setters con acceso protegido para que solo HamburguesaBuilder pueda llamarlos
    protected void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }
    protected void setPuntoCarne(String puntoCarne) {
        this.puntoCarne = puntoCarne;
    }
    protected void setSalsa(String salsa) {
        this.salsa = salsa;
    }
    protected void setNotaCocina(String notaCocina) {
        this.notaCocina = notaCocina;
    }
    
    /**
     * Acceso al ItemMenu original por si se necesita información extra (alergenos, etc).
     */
    public ItemMenu getItemMenu() {
        return itemMenu;
    }
    
    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder();
        
        // 1. Nombre base del menú (ej. "Hamburguesa Gourmet")
        sb.append(itemMenu.getNombre());
        
        // 2. Detalles de configuración
        sb.append("\n - Pan: ").append(tipoPan);
        sb.append("\n - Carne: ").append(puntoCarne);
        
        if (salsa != null && !salsa.equals("Ninguna")) {
            sb.append("\n - Salsa: ").append(salsa);
        }
        
        if (notaCocina != null && !notaCocina.isEmpty()) {
            sb.append("\n **Nota: ").append(notaCocina);
        }
        
        return sb.toString();
    }
    
    @Override
    public double getPrecio() {
        return itemMenu.getPrecio();
    }
    
    @Override
    public Map<String, Integer> getIngredientes() {
        Map<String, Integer> requisitos = new HashMap<>();
        requisitos.put("Pan", 1);
        requisitos.put("Carne", 1); // O 2 si es Smash, según tu lógica del Builder
        return requisitos;
    }
}