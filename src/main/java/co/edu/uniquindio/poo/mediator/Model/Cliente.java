package co.edu.uniquindio.poo.mediator.Model;

/**
 * Representa a un colega concreto (Concrete Colleague) en el patrón Mediator.
 * El `Cliente` es una de las partes que se comunica a través del mediador (`IMesero`).
 * Puede enviar mensajes (pedidos) y recibir respuestas del chef.
 */
public class Cliente extends Persona {

    /**
     * Constructor para crear un nuevo cliente.
     *
     * @param mesero El mediador que gestionará la comunicación.
     * @param nombre El nombre del cliente.
     */
    public Cliente(IMesero mesero, String nombre) {
        super(mesero, nombre);
    }

    /**
     * Envía un mensaje (pedido) al mediador para que sea entregado al chef.
     *
     * @param mensaje El pedido o mensaje que el cliente desea enviar.
     */
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println(nombre + " dice: " + mensaje);
        mesero.comunicarOrden(mensaje, this);

    }

    /**
     * Recibe un mensaje del mediador, usualmente una respuesta del chef.
     *
     * @param mensaje El mensaje recibido.
     */
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println(nombre + " recibe: " + mensaje);

    }
}
