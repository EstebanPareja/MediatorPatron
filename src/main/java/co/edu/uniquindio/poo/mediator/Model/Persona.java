package co.edu.uniquindio.poo.mediator.Model;

/**
 * Clase abstracta que representa a un colega (Colleague) en el patrón Mediator.
 * Define la estructura base para todos los participantes que se comunicarán
 * a través del mediador (`IMesero`). Cada `Persona` tiene una referencia al
 * mediador para poder enviar mensajes sin conocer directamente a los otros colegas.
 */
public abstract class Persona {
    protected IMesero mesero;
    protected String nombre;

    /**
     * Constructor para crear una instancia de Persona.
     *
     * @param mesero El mediador a través del cual esta persona se comunicará.
     * @param nombre El nombre que identifica a esta persona.
     */
    public Persona(IMesero mesero, String nombre) {
        this.mesero = mesero;
        this.nombre = nombre;
    }

    /**
     * Envía un mensaje al sistema a través del mediador.
     * La implementación de este método define cómo un colega inicia la comunicación.
     *
     * @param mensaje El mensaje a enviar.
     */
    public abstract void enviarMensaje(String mensaje);

    /**
     * Recibe un mensaje que ha sido enviado por otro colega a través del mediador.
     * La implementación de este método define cómo un colega reacciona a los mensajes.
     *
     * @param mensaje El mensaje recibido.
     */
    public abstract void recibirMensaje(String mensaje);

    
    public String getNombre() {
        return nombre;
    }
    public void setMesero(IMesero mesero) {
        this.mesero = mesero;
    }
}
