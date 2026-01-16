/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package comengo.modelo.inventario;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase que gestiona el stock de ingredientes del restaurante de forma
 * centralizada.
 * Implementa el patrón SINGLETON para asegurar una única fuente de datos.
 * 
 * @author fernando
 * @version 1.0
 */
public class GestorInventario {
    
    private final Map<String, Integer> stock;
    
    private GestorInventario() {
        this.stock = new ConcurrentHashMap<>();
        cargarDatosIniciales();
    }
    
    /**
     * Obtiene la única instancia disponible del gestor de inventario.
     * <p>
     * Utiliza el patrón <i>Holder</i> para garantizar una inicialización perezosa (lazy)
     * y segura en entornos multihilo (thread-safe) sin necesidad de sincronización explícita.
     * </p>
     *
     * @return La instancia única de {@link GestorInventario}.
     */
    public static GestorInventario getInstance() {
        return GestorInventarioHolder.INSTANCE;
    }
    
    /**
     * Clase interna estática encargada de mantener la instancia Singleton.
     * Solo se carga en memoria cuando se invoca {@link #getInstance()}.
     */
    private static class GestorInventarioHolder {

        private static final GestorInventario INSTANCE = new GestorInventario();
    }
    
    /**
     * Añade una cantidad específica al stock de un ingrediente.
     * Si el ingrediente no existe, lo crea.
     *
     * @param ingrediente Nombre del ingrediente (ej. "Tomate").
     * @param cantidad    Cantidad a añadir (debe ser positiva).
     * @throws IllegalArgumentException Si la cantidad es negativa.
     */
    public void agregarStock(String ingrediente, int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa");
        stock.merge(ingrediente, cantidad, Integer::sum);
    }
    
    /**
     * Descuenta del stock los ingredientes necesarios para un pedido de forma atómica.
     * <p>
     * Este método es {@code synchronized} para garantizar la atomicidad de la operación:
     * verifica y descuenta en un solo paso, evitando condiciones de carrera donde dos
     * pedidos consuman el mismo stock simultáneamente.
     * </p>
     *
     * @param ingredientesAConsumir Mapa con los ingredientes y cantidades requeridas.
     * @throws Exception Si no hay stock suficiente para cubrir todo el pedido.
     */
    public synchronized void consumirStock(Map<String, Integer> ingredientesAConsumir) throws Exception {
        if (!hayStockSuficiente(ingredientesAConsumir)) {
            throw new Exception("Stock insuficiente para procesar el pedido.");
        }
        
        for (Map.Entry<String, Integer> entry : ingredientesAConsumir.entrySet()) {
            String nombre = entry.getKey();
            int cantidad = entry.getValue();
            stock.put(nombre, stock.get(nombre) - cantidad);
        }
    }
    
    /**
     * Verifica si existe stock suficiente para una lista de requisitos sin modificar el inventario.
     *
     * @param ingredientesNecesarios Mapa con ingredientes y cantidades a comprobar.
     * @return {@code true} si hay suficiente stock de todos los ingredientes, {@code false} en caso contrario.
     */
    public boolean hayStockSuficiente(Map<String, Integer> ingredientesNecesarios) {
        for (Map.Entry<String, Integer> entry : ingredientesNecesarios.entrySet()) {
            String nombre = entry.getKey();
            int cantidad = entry.getValue();
            
            if (stock.getOrDefault(nombre, 0) < cantidad) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Consulta la cantidad actual disponible de un ingrediente.
     *
     * @param ingrediente Nombre del ingrediente.
     * @return Cantidad disponible (0 si el ingrediente no existe).
     */
    public int getStockActual(String ingrediente) {
        return stock.getOrDefault(ingrediente, 0);
    }
    
    /**
     * Método que carga estáticamente unos datos de prueba
     * TEMPORAL
     */
    private void cargarDatosIniciales() {
        stock.put("Pan Hamburguesa", 50);
        stock.put("Carne Picada", 40);
        stock.put("Queso", 30);
    }
}
