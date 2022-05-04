package gestione;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{
	
	ServerSocket ss; 
	Socket so;
	DataOutputStream out; 
	DataInputStream input;
	BufferedReader br;
	CountDown cd;
	//Lanciare il thread e insieme al setsotimeout
	
	public Server(int porta) {
		
		try {
	        //1)Apertura alla porta, avvio del servizio
	        ss = new ServerSocket(porta);	//il server si mette in ascolto
	        System.out.println("Server in ascolto");
		}
		catch (IOException ex) {
	        System.err.println("Errore avvio server sulla porta 2000");
	        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
		
	public void ascolto() {
		try {
			so=ss.accept();	//Attende che il server risponde 
			ss.close();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
	}
	
	public void scrivi() {
		try {
			out = new DataOutputStream(so.getOutputStream());
			String messaggio = out.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void leggi() {
		try {
			br = new BufferedReader(new InputStreamReader (so.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	        
       
}
