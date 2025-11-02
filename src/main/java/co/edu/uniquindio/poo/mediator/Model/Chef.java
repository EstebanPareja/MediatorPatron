package co.edu.uniquindio.poo.mediator.Model;

/**
 * Representa a otro colega concreto (Concrete Colleague) en el patrón Mediator.
 * El `Chef` recibe pedidos del cliente a través del mediador y puede enviar
 * respuestas o actualizaciones sobre el estado del pedido.
 */
public class Chef extends Persona {

    /**
     * Constructor para crear un nuevo chef.
     *
     * @param mesero El mediador que gestionará la comunicación.
     * @param nombre El nombre del chef.
     */
    public Chef(IMesero mesero, String nombre) {
        super(mesero, nombre);

    }

    /**
     * Envía un mensaje (respuesta) al mediador para que sea entregado al cliente.
     *
     * @param mensaje La respuesta o actualización que el chef desea enviar.
     */
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("chef " +nombre + " dice:" + mensaje);
        mesero.comunicarOrden(mensaje, this);
    }

    /**
     * Recibe un mensaje del mediador, que es el pedido de un cliente.
     * Al recibir el pedido, responde automáticamente con "Pedido recibido".
     *
     * @param mensaje El pedido recibido del cliente.
     */
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("chef " +nombre + " recibe:" + mensaje);
        enviarMensaje("Pedido recibido");
    }
}
