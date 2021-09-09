package client.view;

import client.control.ConnectionController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConnectionWindow extends Stage{

	private TextField ipTF;
	private TextField portTF;
	private Button connectBtn;
	
	private ConnectionController conntroller;
	
	public ConnectionWindow() {
		VBox parent = new VBox();
		
		ipTF = new TextField("127.0.0.1");
		ipTF .setPromptText("ip direccion");
		portTF = new TextField("5000");
		portTF.setPromptText("Puerto de red");
		connectBtn = new Button("Conectar");
		
		parent.getChildren().add(ipTF);
		parent.getChildren().add(portTF);
		parent.getChildren().add(connectBtn);
		Scene scene = new Scene(parent,600,400);
		setScene(scene);
		
		conntroller = new ConnectionController(this);
	}

	//getters del view
	
	public TextField getIpTF() {
		return ipTF;
	}

	public TextField getPortTF() {
		return portTF;
	}

	public Button getConnectBtn() {
		return connectBtn;
	}

	public void openChatWindow() {
		this.close();
		ChatWindow chat = new ChatWindow();
		chat.show();	
	}
	
}
