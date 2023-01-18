package Server.HttpServer.UtilsServer;

import Server.HttpServer.RequestUtils.RequestBuilder;
import Server.HttpServer.RequestUtils.RequestHandler;
import Server.HttpServer.RequestUtils.Route;

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
        Request request = null;
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("Server started ...");
            while(true) {
                Socket clientConnection = serverSocket.accept();
                executorService.execute(new RequestHandler(clientConnection));
            }
        }
    }
}