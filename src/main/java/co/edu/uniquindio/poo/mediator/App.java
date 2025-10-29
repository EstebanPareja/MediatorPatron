package co.edu.uniquindio.poo.mediator;

import co.edu.uniquindio.poo.mediator.Model.Chef;
import co.edu.uniquindio.poo.mediator.Model.Cliente;
import co.edu.uniquindio.poo.mediator.Model.Restaurante;

public class App {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        Cliente santi = new Cliente(restaurante, "Santi");
        Chef pedroChef = new Chef(restaurante, "Pedro");

        restaurante.setCliente(santi);
        restaurante.setChef(pedroChef);

        santi.enviarMensaje("Quiero una bandeja paisa con jugo de mora");
        pedroChef.enviarMensaje("Pedido en proceso");
    }
}
