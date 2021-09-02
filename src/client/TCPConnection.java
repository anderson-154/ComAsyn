package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

	// clase normal
	private Socket socket;
	private BufferedReader breader;
	private BufferedWriter bwriter;
	
	//listeners
	private OnInboxListener onInboxListener = null;
	private OnConnectionListener onConnectionListener = null;
	
	
	public void connect(String ip, int port) {
		new Thread(()->{
			try {
				socket = new Socket(ip,port);
				onConnectionListener.onConnection(true);
				
				//definir el lector y el escritor
				
				InputStream is = socket.getInputStream();
				breader = new BufferedReader(new InputStreamReader(is));
				
				OutputStream os = socket.getOutputStream();
				bwriter = new BufferedWriter(new OutputStreamWriter(os));
				
				while(true) {
					String line = breader.readLine();
					onInboxListener.onMessage(line);
				}
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
				onConnectionListener.onConnection(false);
			} catch (IOException e) {
				e.printStackTrace();
				onConnectionListener.onConnection(false);
			}
		}).start();
	}
	
	public void sendeMessage(String msg) {
		new Thread(()-> {
			try {
				bwriter.write(msg+"\n");
				bwriter.flush();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}).start();
	}
	//metodos de suscripcion
	public void setConnectionListener(OnConnectionListener onConnectionListener) {
		this.onConnectionListener = onConnectionListener;
	}

	public void setOnInboxListener(OnInboxListener onInboxListener) {
		this.onInboxListener = onInboxListener;
	}

	
}
