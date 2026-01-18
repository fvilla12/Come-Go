/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.facturacion;

import comengo.modelo.pedidos.Pedido;
import comengo.modelo.producto.IPlato;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase encargada de la generación de facturas simplificadas en formato de texto.
 * <p>
 * Este servicio extrae la información de un {@link Pedido} procesado, incluye
 * el desglose de productos y el total pagado, y lo guarda en un fichero local
 * siguiendo las especificaciones de la empresa Come&Go.
 * </p>
 * @author fernando
 * @version 1.0
 */
public class GeneradorFactura {
    
    /**
     * Genera un fichero de texto con los detalles de la factura del pedido.
     * <p>
     * El nombre del fichero sigue el patrón: IDPedido_Fecha.txt.
     * </p>
     *
     * @param pedido El pedido finalizado y pagado.
     * @throws IOException Si ocurre un error al escribir el fichero en el sistema.
     */
    public void generarFacturaTexto(Pedido pedido) throws IOException {
        // 1. Preparar la fecha y el nombre del fichero
        LocalDateTime ahora = LocalDateTime.now();
        String fechaStr = ahora.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        String nombreFichero = String.format("%s_%s.txt", pedido.getId(), fechaStr);

        // 2. Crear el flujo de escritura
        try (FileWriter fileWriter = new FileWriter(nombreFichero);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Encabezado de la factura
            printWriter.println("========================================");
            printWriter.println("           COME & GO RESTAURANTE        ");
            printWriter.println("        Factura Simplificada (Ticket)   ");
            printWriter.println("========================================");
            printWriter.println("ID Pedido: " + pedido.getId());
            printWriter.println("Fecha: " + ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            printWriter.println("Estado: " + pedido.getEstado());
            printWriter.println("----------------------------------------");

            // 3. Desglose de productos
            printWriter.println("PRODUCTOS:");
            for (IPlato producto : pedido.getProductos()) {
                printWriter.printf("- %-25s %8.2f€%n", 
                    producto.getDescripcion().substring(0, Math.min(producto.getDescripcion().length(), 25)), 
                    producto.getPrecio());
            }

            // 4. Totales
            printWriter.println("----------------------------------------");
            double total = pedido.calcularTotal();
            printWriter.printf("TOTAL A PAGAR: %22.2f€%n", total);
            printWriter.println("========================================");
            printWriter.println("      ¡Gracias por su visita!           ");
            printWriter.println("========================================");
        }
    }
}
