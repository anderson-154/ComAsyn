package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000);
			//esperar conexion
			System.out.println("waiting...");
			Socket socket = server.accept();
			System.out.println("conection successful");
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
			
			Scanner scanner = new Scanner(System.in);

			while(true) {
				String line = scanner.nextLine();
				writer.write(line+"\n");
				writer.flush();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
