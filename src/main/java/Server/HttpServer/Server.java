package Server.HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int port;

    public static void main(String[] args) throws  IOException{
        Server server = new Server(10001);
        server.start();
    }

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("Server started ...");
            while(true) {
                Socket clientConnection = serverSocket.accept();
                executorService.execute(new RequestHandler(clientConnection));
            }
        }
    }
}