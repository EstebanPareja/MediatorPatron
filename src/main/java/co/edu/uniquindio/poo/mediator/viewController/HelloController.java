package co.edu.uniquindio.poo.mediator.viewController;

import co.edu.uniquindio.poo.mediator.Model.Chef;
import co.edu.uniquindio.poo.mediator.Model.Cliente;
import co.edu.uniquindio.poo.mediator.Model.Restaurante;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField newClientName;
    @FXML
    private TextField newChefName;
    @FXML
    private ComboBox<Cliente> clientSelector;
    @FXML
    private ComboBox<Chef> chefSelector;
    @FXML
    private HBox chatPane;
    @FXML
    private Label clientChatLabel;
    @FXML
    private Label chefChatLabel;
    @FXML
    private TextArea clienteLog;
    @FXML
    private TextField clienteInput;
    @FXML
    private TextArea chefLog;
    @FXML
    private TextField chefInput;

    private Restaurante restaurante;
    private Cliente activeClient;
    private Chef activeChef;

    private final List<Cliente> clients = new ArrayList<>();
    private final List<Chef> chefs = new ArrayList<>();

    private final StringProperty clienteLogContent = new SimpleStringProperty();
    private final StringProperty chefLogContent = new SimpleStringProperty();

    @FXML
    public void initialize() {
        clienteLog.textProperty().bind(clienteLogContent);
        chefLog.textProperty().bind(chefLogContent);

        // Convertidores para mostrar nombres en ComboBox
        clientSelector.setConverter(new StringConverter<>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente != null ? cliente.getNombre() : "";
            }

            @Override
            public Cliente fromString(String string) {
                return null;
            }
        });

        chefSelector.setConverter(new StringConverter<>() {
            @Override
            public String toString(Chef chef) {
                return chef != null ? chef.getNombre() : "";
            }

            @Override
            public Chef fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    private void addClient() {
        String name = newClientName.getText();
        if (name != null && !name.isEmpty()) {
            Cliente newClient = new Cliente(null, name) { // Mediator se asigna al iniciar chat
                @Override
                public void recibirMensaje(String mensaje) {
                    super.recibirMensaje(mensaje);
                    if (this == activeClient) {
                        clienteLogContent.set(clienteLogContent.get() + "Recibido: " + mensaje + "\n");
                    }
                }
            };
            clients.add(newClient);
            clientSelector.setItems(FXCollections.observableArrayList(clients));
            newClientName.clear();
        }
    }

    @FXML
    private void addChef() {
        String name = newChefName.getText();
        if (name != null && !name.isEmpty()) {
            Chef newChef = new Chef(null, name) { // Mediator se asigna al iniciar chat
                @Override
                public void recibirMensaje(String mensaje) {
                    super.recibirMensaje(mensaje);
                    if (this == activeChef) {
                        chefLogContent.set(chefLogContent.get() + "Recibido: " + mensaje + "\n");
                    }
                }

                @Override
                public void enviarMensaje(String mensaje) {
                    super.enviarMensaje(mensaje);
                    if (this == activeChef) {
                        chefLogContent.set(chefLogContent.get() + "Enviado: " + mensaje + "\n");
                    }
                }
            };
            chefs.add(newChef);
            chefSelector.setItems(FXCollections.observableArrayList(chefs));
            newChefName.clear();
        }
    }

    @FXML
    private void startChat() {
        activeClient = clientSelector.getValue();
        activeChef = chefSelector.getValue();

        if (activeClient != null && activeChef != null) {
            restaurante = new Restaurante();
            activeClient.setMesero(restaurante);
            activeChef.setMesero(restaurante);
            restaurante.setCliente(activeClient);
            restaurante.setChef(activeChef);

            clientChatLabel.setText("Cliente (" + activeClient.getNombre() + ")");
            chefChatLabel.setText("Chef (" + activeChef.getNombre() + ")");

            clienteLogContent.set("Chat iniciado con " + activeChef.getNombre() + "\n");
            chefLogContent.set("Chat iniciado con " + activeClient.getNombre() + "\n");

            chatPane.setDisable(false);
        }
    }

    @FXML
    protected void onSendOrderClick() {
        String message = clienteInput.getText();
        if (message != null && !message.isEmpty() && activeClient != null) {
            clienteLogContent.set(clienteLogContent.get() + "Enviado: " + message + "\n");
            activeClient.enviarMensaje(message);
            clienteInput.clear();
        }
    }

    @FXML
    protected void onChefSendMessageClick() {
        String message = chefInput.getText();
        if (message != null && !message.isEmpty() && activeChef != null) {
            activeChef.enviarMensaje(message);
            chefInput.clear();
        }
    }
}
