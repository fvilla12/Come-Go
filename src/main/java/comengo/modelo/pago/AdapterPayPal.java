/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.pago;

import comengo.modelo.excepciones.ErrorPagoException;

/**
 * Adaptador para la pasarela de pago PayPal.
 * <p>
 * Implementa el patrón <b>Adapter</b> envolviendo la lógica específica
 * de la API de PayPal para que sea compatible con la interfaz {@link IPago}.
 * </p>
 * @author fernando
 */
public class AdapterPayPal implements IPago {

    // En una implementación real, aquí tendríamos el objeto de la API de PayPal
    // private PayPalAPI apiExterna;
    
    @Override
    public boolean procesarPago(double importe) throws ErrorPagoException {
        System.out.println("Conectando con pasarela PayPal...");
        // Simulación de lógica específica de PayPal:
        // apiExterna.sendPayment(importe, "EUR");
        System.out.println("Pago de " + importe + "€ procesado con éxito vía PayPal.");
        return true;
    }
    
    // En una implementación real, aquí tendríamos el objeto de la API de PayPal
    // private PayPalAPI apiExterna;
    
}
