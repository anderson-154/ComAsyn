package client.control;

import client.comm.TCPConnection;
import client.event.OnConnectionListener;
import client.view.ConnectionWindow;
import javafx.application.Platform;

public class ConnectionController implements OnConnectionListener {

	private ConnectionWindow view;
	
	public ConnectionController(ConnectionWindow view) {
		this.view = view;
	}
	
	public void init() {
		view.getConnectBtn().setOnAction(event->{
			TCPConnection con = TCPConnection.getInstace();
			con.setConnectionListener(this);
			con.connect(view.getIpTF().getText(), Integer.parseInt(view.getPortTF().getText()));
		});	
	}
	
	
	@Override
	public void onConnection(boolean success) {
		Platform.runLater(()->{
			if(success) {
				view.openChatWindow();
			}else {
				System.out.println("fallo la coneccion");
			}
		});
	}
}

