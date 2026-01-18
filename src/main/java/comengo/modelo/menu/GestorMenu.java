/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package comengo.modelo.menu;

import comengo.modelo.excepciones.EntidadDuplicadaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton que gestiona el catálogo global de platos y categorías.
 * <p>
 * Valida que no se dupliquen platos por su ID o Nombre.
 * </p>
 * @author fernando
 */
public class GestorMenu {
    
    private final List<IComponenteMenu> catalogo;
    
    private GestorMenu() {
        this.catalogo = new ArrayList<>();
    }
    
    public static GestorMenu getInstance() {
        return GestorMenuHolder.INSTANCE;
    }
    
    private static class GestorMenuHolder {

        private static final GestorMenu INSTANCE = new GestorMenu();
    }
    
    /**
     * Añade un nuevo ítem al menú validando duplicados.
     * @param nuevoItem El plato o categoría a añadir.
     * @throws EntidadDuplicadaException Si el ID o Nombre ya existen.
     */
    public void añadirAlMenu(IComponenteMenu nuevoItem) throws EntidadDuplicadaException {
        for (IComponenteMenu item : catalogo) {
            // Verificamos si es un plato para comparar IDs
            if (item instanceof ItemMenu && nuevoItem instanceof ItemMenu) {
                ItemMenu actual = (ItemMenu) item;
                ItemMenu nuevo = (ItemMenu) nuevoItem;
                if (actual.getId().equalsIgnoreCase(nuevo.getId()) || 
                    actual.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
                    throw new EntidadDuplicadaException("El ID o Nombre del plato ya existe en el menú.");
                }
            }
        }
        catalogo.add(nuevoItem);
    }
    
    public List<IComponenteMenu> getCatalogo() {
        return catalogo;
    }
}
