package io.effective._34;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EchoServer {
    public static void main(String[] args) throws IOException {
//        ExecutorService es = Executors.newFixedThreadPool(500);
        ExecutorService es = new ThreadPoolExecutor(50, 500, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2000), // 创建有界队列
                r -> new Thread(r, "echo-" + r.hashCode()), // 根据业务需求实现ThreadFactory
                new ThreadPoolExecutor.CallerRunsPolicy()); // 根据业务需求实现RejectedExecutionHandler
        final ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8090));
        try {
            while (true) {
                SocketChannel sc = ssc.accept();
                es.execute(() -> {
                    ByteBuffer rb = ByteBuffer.allocateDirect(1024);
                    try {
                        sc.read(rb);
                        Thread.sleep(100);
                        ByteBuffer wb = (ByteBuffer) rb.flip();
                        sc.write(wb);
                        sc.close();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            ssc.close();
            es.shutdown();
        }
    }
}
