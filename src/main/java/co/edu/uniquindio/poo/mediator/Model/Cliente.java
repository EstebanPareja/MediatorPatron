package co.edu.uniquindio.poo.mediator.Model;

public class Cliente extends Persona {

    public Cliente(IMesero mesero, String nombre) {
        super(mesero, nombre);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println(nombre + " dice: " + mensaje);
        mesero.comunicarOrden(mensaje, this);

    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println(nombre + " recibe: " + mensaje);

    }
}
