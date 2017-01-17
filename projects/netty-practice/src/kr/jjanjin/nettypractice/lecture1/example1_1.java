package kr.jjanjin.nettypractice.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Example1_1 {

	public static void main(String[] args) throws IOException {
		
		ServerSocket sersverSocket = new ServerSocket(1234);
		while(true){
			Socket clientSocket = sersverSocket.accept();
			System.out.println("한글로변경");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			String request, response;
			
			while((request = in.readLine()) != null){
				if("Done".equals(request)){
					break;
				}
				
				System.out.println(request);
				out.println(request + "out");
			}
		}
	}

}
