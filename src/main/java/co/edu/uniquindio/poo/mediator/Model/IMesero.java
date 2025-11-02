package co.edu.uniquindio.poo.mediator.Model;

/**
 * Interfaz que define el contrato para el mediador (Mediator).
 * En el contexto del patrón Mediator, esta interfaz es implementada por la clase
 * que centraliza la comunicación entre los colegas (Colleagues).
 * Su único método, `comunicarOrden`, es el canal a través del cual los objetos
 * se comunican indirectamente.
 */
public interface IMesero {
    /**
     * Comunica un mensaje desde un emisor a los demás participantes del sistema.
     * El mediador se encarga de redirigir el mensaje al destinatario correcto.
     *
     * @param mensaje El contenido del mensaje a transmitir.
     * @param emisor  La persona (colega) que envía el mensaje.
     */
    public void comunicarOrden (String mensaje, Persona emisor);

}
