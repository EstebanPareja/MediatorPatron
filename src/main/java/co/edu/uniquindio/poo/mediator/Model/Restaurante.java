package co.edu.uniquindio.poo.mediator.Model;

/**
 * Implementación del mediador concreto (Concrete Mediator).
 * El `Restaurante` actúa como el intermediario que centraliza la comunicación
 * entre el `Cliente` y el `Chef`. Conoce a ambos colegas y gestiona el flujo
 * de mensajes entre ellos, evitando que se comuniquen directamente.
 */
public class Restaurante implements IMesero{

    private Cliente cliente;
    private Chef chef;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setChef(Chef chef) {
        this.chef = chef;
    }

    /**
     * Gestiona la comunicación de un mensaje recibido de un colega.
     * Si el emisor es el cliente, el mensaje se envía al chef.
     * Si el emisor es el chef, el mensaje se envía al cliente.
     *
     * @param mensaje El contenido del mensaje a transmitir.
     * @param emisor La persona (colega) que originó el mensaje.
     */
    @Override
    public void comunicarOrden(String mensaje, Persona emisor){
        if (emisor == cliente) {
            chef.recibirMensaje(mensaje);
        }else {
            cliente.recibirMensaje(mensaje);
            }
        }
    }

