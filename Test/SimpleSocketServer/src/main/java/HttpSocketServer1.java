import com.sun.source.tree.WhileLoopTree;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpSocketServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            Socket socket = serverSocket.accept();
            service(socket);
        }
    }

    private static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-type:text/html;charset=utf-8");
            String body = "hello,nio1";
            printWriter.println("Content-length:" + body.getBytes().length);
            printWriter.println();
            printWriter.println(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
