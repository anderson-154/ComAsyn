package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPConnection {

	private static TCPConnection instace;

	private TCPConnection() {

	}

	public static synchronized TCPConnection getInstace() {
		if (instace == null) {
			instace = new TCPConnection();
		}
		return instace;
	}

	// clase noral
	private Socket socket;
	private OnConnectionListener onConnectionListener = null;
	public void connect(String ip, int port) {
		new Thread(()->{
			try {
				socket = new Socket(ip,port);
				onConnectionListener.onConnection(true);
			} catch (UnknownHostException e) {
				e.printStackTrace();
				onConnectionListener.onConnection(false);
			} catch (IOException e) {
				e.printStackTrace();
				onConnectionListener.onConnection(false);
			}
		}).start();
	}
	
	//metodo de suscripcion
	public void setConnectionListener(OnConnectionListener onConnectionListener) {
		this.onConnectionListener = onConnectionListener;
	}

}
