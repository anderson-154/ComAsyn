package client.view;

import client.comm.TCPConnection;
import client.event.OnInboxListener;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatWindow extends Stage implements OnInboxListener {

	private TextArea txtArea;
	private TextField txtField;
	private Button enviar;

	public ChatWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatWindow.fxml"));
			Parent root = loader.load();
			
			txtArea = (TextArea) loader.getNamespace().get("txtArea");
			txtArea.setEditable(false);
			txtField = (TextField) loader.getNamespace().get("txtField");
			enviar = (Button) loader.getNamespace().get("enviar");
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void init() {
		TCPConnection.getInstace().setOnInboxListener(this);
	}

	@Override
	public void onMessage(String msg) {
		Platform.runLater(()->{
			txtArea.appendText(msg+"\n");
		});
	}

}
