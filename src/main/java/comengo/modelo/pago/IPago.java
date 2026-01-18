/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comengo.modelo.pago;

/**
 * Interfaz común para el procesamiento de pagos en el sistema.
 * <p>
 * Define el contrato que deben seguir todos los adaptadores de pago 
 * (Patrón <b>Adapter</b>). Esto permite al sistema procesar transacciones
 * de forma polimórfica, independientemente del proveedor externo.
 * </p>
 * @author fernando
 */
public interface IPago {
    
    /**
     * Procesa un pago por un importe determinado.
     *
     * @param importe Cantidad total a cobrar en euros.
     * @return {@code true} si la transacción fue exitosa, {@code false} en caso contrario.
     * @throws Exception Si ocurre un error crítico durante la comunicación con la pasarela.
     */
    boolean procesarPago(double importe) throws Exception;
}
