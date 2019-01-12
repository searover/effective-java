import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class PlainBioServer {
    public void serve(int port) throws IOException {
        final ServerSocket server = new ServerSocket(port);
        System.out.println("Server start at port: " + port);
        while (true) {
            final Socket client = server.accept();
            System.out.println("Accepted connection from " + client);
            new Thread(() -> {
                try {
                    OutputStream out = client.getOutputStream();
                    out.write("Hi\r\n".getBytes(StandardCharsets.UTF_8));
                    out.flush();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        client.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }).start();
            ;
        }
    }

    public static void main(String[] args) throws IOException {
        new PlainBioServer().serve(8081);
    }
}
