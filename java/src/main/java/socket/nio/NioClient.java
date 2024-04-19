package socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class NioClient {
    // 创建一个套接字通道，注意这里必须使用无参形式
    private Selector selector = null;
    private volatile boolean stop = false;
    public ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue<String>(8);

    public void init() throws IOException {
        selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        // 设置为非阻塞模式，这个方法必须在实际连接之前调用(所以open的时候不能提供服务器地址，否则会自动连接)
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("127.0.0.1", 8888));
        channel.register(selector, SelectionKey.OP_CONNECT);

        //启动一个接受服务器反馈的线程
        //  new Thread(new ReceiverInfo()).start();


        while (!stop) {
            selector.select(1000);
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            SelectionKey key = null;
            while (it.hasNext()) {
                key = it.next();
                it.remove();
                SocketChannel sc = (SocketChannel) key.channel();
                // OP_CONNECT 两种情况，链接成功或失败这个方法都会返回true
                if (key.isConnectable()) {
                    // 由于非阻塞模式，connect只管发起连接请求，finishConnect()方法会阻塞到链接结束并返回是否成功
                    // 另外还有一个isConnectionPending()返回的是是否处于正在连接状态(还在三次握手中)
                    if (channel.finishConnect()) {
                  /*      System.out.println("准备发送数据");
                        // 链接成功了可以做一些自己的处理
                        channel.write(charset.encode("I am Coming"));
                        // 处理完后必须吧OP_CONNECT关注去掉，改为关注OP_READ
                        key.interestOps(SelectionKey.OP_READ);*/
                        //TODO 告诉服务端，“你可以读了”

                        sc.register(selector, SelectionKey.OP_READ);
                        //    new Thread(new DoWrite(channel)).start();
                        doWrite(channel, "你好我是客户端1");
                        System.out.println("当前通道数：" + selector.keys().size());

                    } else {
                        //链接失败，进程推出
                        System.exit(1);
                    }
                }

                if (key.isReadable()) {
                    //读取服务端的响应
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int readBytes = sc.read(buffer);
                    String content = "";
                    if (readBytes > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        content += new String(bytes);
                        stop = true;
                    } else if (readBytes < 0) {
                        //对端链路关闭
                        key.channel();
                        sc.close();
                    }
                    System.out.println(content);
                    key.interestOps(SelectionKey.OP_READ);
                }
            }
            System.out.println("🔄");
        }
    }

    private void doWrite(SocketChannel sc, String data) throws IOException {
        byte[] req = data.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(req.length);
        byteBuffer.put(req);
        byteBuffer.flip();
        sc.write(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            System.out.println("Send 2 client successed");
        }
    }

    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        nioClient.init();
    }
}