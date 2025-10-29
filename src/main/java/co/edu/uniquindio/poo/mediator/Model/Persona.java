package co.edu.uniquindio.poo.mediator.Model;

public abstract class Persona {
    protected IMesero mesero;
    protected String nombre;

    public Persona(IMesero mesero, String nombre) {
        this.mesero = mesero;
        this.nombre = nombre;
    }

    public abstract void enviarMensaje(String mensaje);
    public abstract void recibirMensaje(String mensaje);
}
