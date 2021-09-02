package client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatWindow extends Stage {

	private TextArea txtArea;
	private TextField txtField;
	private Button enviar;

	public ChatWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatWindow.fxml"));
			Parent root = loader.load();
			
			txtArea = (TextArea) loader.getNamespace().get("txtArea");
			txtField = (TextField) loader.getNamespace().get("txtField");
			enviar = (Button) loader.getNamespace().get("enviar");
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
