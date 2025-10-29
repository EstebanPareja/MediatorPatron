package co.edu.uniquindio.poo.mediator.Model;

public class Chef extends Persona {

    public Chef(IMesero mesero, String nombre) {
        super(mesero, nombre);

    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("chef " +nombre + " dice:" + mensaje);
        mesero.comunicarOrden(mensaje, this);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("chef " +nombre + " recibe:" + mensaje);
        enviarMensaje("Pedido recibido");
    }
}
