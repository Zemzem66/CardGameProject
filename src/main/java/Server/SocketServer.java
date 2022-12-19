package Server;

import java.net.ServerSocket;

    public class SocketServer {
        public static void main(String[] args) {

            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                while (true) { // next call, while its true
                    var socket = serverSocket.accept();
                    new SocketHandler(socket);
                }
            }catch (Exception e) {

            }
        }
}
