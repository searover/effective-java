package io.effective;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author searover
 */
public class RequestHandler extends Thread {
    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
