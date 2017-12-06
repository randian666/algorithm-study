package com.algorithm.study.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author liuxun
 * @version V1.0
 * @Description: ServerSocketChannel 聊天室服务端
 * @date 2017/12/6
 */
public class ServerSocketChannelTest {
    // 用于检测所有Channel状态的Selector
    private Selector selector = null;
    // 定义实现编码、解码的字符集对象
    private Charset charset = Charset.forName("UTF-8");
    public void init() throws IOException {
        selector = Selector.open();
        // 通过open方法来打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 30000);
        // 将该ServerSocketChannel绑定到指定ip地址
        server.socket().bind(isa);
        // 设置ServerSocket以非阻塞方式工作
        server.configureBlocking(false);
        // 将server注册到指定Selector对象
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            // 依次处理selector上的每个已选择的SelectionKey
            for (SelectionKey sk : selector.selectedKeys()) {
                // 从selector上的已选择Key集中删除正在处理的SelectionKey
                selector.selectedKeys().remove(sk);
                // 如果sk对应的通信包含客户端的连接请求
                if (sk.isAcceptable()) {
                    // 调用accept方法接受连接，产生服务器端对应的SocketChannel
                    SocketChannel sc = server.accept();
                    // 设置采用非阻塞模式
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    sc.write(charset.encode("欢迎来骚扰我"));
                    // 将sk对应的Channel设置成准备接受其他请求
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }
                // 如果sk对应的通道有数据需要读取
                if (sk.isReadable()) {
                    // 获取该SelectionKey对应的Channel，该Channel中有可读的数据
                    SocketChannel sc = (SocketChannel) sk.channel();
                    // 定义准备之星读取数据的ByteBuffer
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    String content = "";
                    // 开始读取数据
                    try {
                        while (sc.read(buff) > 0) {
                            buff.flip();
                            content += charset.decode(buff);
                        }
                        // 打印从该sk对应的Channel里读到的数据
                        System.out.println(content);
                        // 将sk对应的Channel设置成准备下一次读取
                        sk.interestOps(SelectionKey.OP_READ);
                        // 如果捕捉到该sk对应的channel出现异常，即表明该channel对应的client出现了
                        // 异常，所以从selector中取消sk的注册
                    } catch (IOException e) {
                        // 从Selector中删除指定的SelectionKey
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
                    }
                    // 如果content的长度大于0，即聊天信息不为空
                    if (content.length() > 0) {

                        // 遍历该selector里注册的所有SelectKey
                        for (SelectionKey key : selector.keys()) {
                            // 选取该key对应的Channel
                            Channel targetChannel = key.channel();
                            // 如果该channel是SocketChannel对象
                            if (targetChannel instanceof SocketChannel) {
                                // 将独到的内容写入该Channel中
                                SocketChannel dest = (SocketChannel) targetChannel;
                                Scanner scan=new Scanner(System.in);
                                while(scan.hasNextLine()){
                                    //读取键盘输入
                                    String line=scan.nextLine();
                                    //将键盘输入的内容输出到SocketChannel中
                                    dest.write(charset.encode("zhaoyun:"+line));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new ServerSocketChannelTest().init();
    }
}
