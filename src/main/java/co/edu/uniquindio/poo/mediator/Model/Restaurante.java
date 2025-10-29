package co.edu.uniquindio.poo.mediator.Model;

public class Restaurante implements IMesero{

    private Cliente cliente;
    private Chef chef;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setChef(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void comunicarOrden(String mensaje, Persona emisor){
        if (emisor == cliente) {
            chef.recibirMensaje(mensaje);
        }else {
            cliente.recibirMensaje(mensaje);
            }
        }
    }

