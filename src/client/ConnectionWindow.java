package client;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConnectionWindow extends Stage implements OnConnectionListener{

	private TextField ipTF;
	private TextField portTF;
	private Button connectBtn;
	
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
		
		connectBtn.setOnAction(event->{
			TCPConnection con = TCPConnection.getInstace();
			con.setConnectionListener(this);
			con.connect(ipTF.getText(), Integer.parseInt(portTF.getText()));
		});
	}
	@Override
	public void onConnection(boolean success) {
		Platform.runLater(()->{
			if(success) {
				ChatWindow chat = new ChatWindow();
				chat.show();
			}else {
				System.out.println("fallo la coneccion");
			}
		});
	}
}
