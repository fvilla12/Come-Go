/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.pago;

/**
 * Adaptador para el sistema de pago Bizum.
 * <p>
 * Permite integrar los pagos mediante número de teléfono bajo la 
 * interfaz común de pagos del sistema.
 * </p>
 * @author fernando
 */
public class AdapterBizum implements IPago {
    
    @Override
    public boolean procesarPago(double importe) throws Exception {
        System.out.println("Iniciando transacción Bizum...");
        // Lógica simulada de validación de número y envío de clave
        System.out.println("Pago de " + importe + "€ confirmado por el cliente vía Bizum.");
        return true;
    }
}
