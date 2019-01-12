import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketTest {
    @Test
    public void socketTest() throws IOException {
        System.out.println("start");
        SocketAddress address = new InetSocketAddress("localhost", 8080);
        Socket socket = new Socket();
        socket.connect(address);
        byte[] output = new byte[]{1, 0, 0, 0, 1, 0};
        socket.getOutputStream().write(output);
        byte[] input = new byte[10240];
        int readByte = socket.getInputStream().read(input);
        System.out.println("read byte: " + new String(input));
        socket.close();
    }

    @Test
    public void socketChannelBlockTest() throws IOException {
        SocketAddress address = new InetSocketAddress("localhost", 8080);
        SocketChannel channel = SocketChannel.open(address);
        ByteBuffer output = ByteBuffer.allocate(5);
        output.put((byte) 1);
        output.putInt(0);
        output.flip();
        channel.write(output);
        ByteBuffer input = ByteBuffer.allocate(50);
        int readBytes = channel.read(input);
        System.out.println("read bytes: " + readBytes);
        input.flip();
        if (readBytes == -1)
            return;
        channel.finishConnect();
        channel.close();
        System.out.println(new String(input.array()));
    }

    @Test
    public void socketChannelConcurrentTest() throws IOException, InterruptedException {
        SocketAddress address = new InetSocketAddress("localhost", 8080);
        SocketChannel channel = SocketChannel.open(address);
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);

        ByteBuffer output = ByteBuffer.allocate(5);
        output.put((byte) 1);
        output.putInt(0);
        output.flip();
        channel.write(output);
        System.out.println("Write complete, start reading...");
        while (true){
            if(selector.selectNow() > 0){
                Set<SelectionKey> keySet = selector.selectedKeys();
                System.out.println("Start iterate keySet, size: " + keySet.size());
                Iterator<SelectionKey> iterator = keySet.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        System.out.println("Key is readable, start reading...");
                        ByteBuffer input = ByteBuffer.allocate(64);
                        SocketChannel keyChannel = (SocketChannel) key.channel();
                        int readBytes = keyChannel.read(input);
                        System.out.println("Read bytes: " + readBytes);
                        input.flip();
                        System.out.println(new String(input.array()));
                    }
                    iterator.remove();
                }
                break;
            }else {
                System.out.println("Sleep 1000ms.");
                Thread.sleep(1000);
            }
        }
    }
}
