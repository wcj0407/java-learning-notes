package Mysocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerdemo {
    public static void main(String[] args) throws IOException {

        // 1. 创建 ServerSocket，监听 9999 端口
        ServerSocket server = new ServerSocket(9999);

        // 2. accept() 阻塞等待客户端连接，返回 Socket
        Socket socket = server.accept();  // 一个客户端连上了
        System.out.println("客户端：" + socket.getInetAddress() + " 已连接");

        // 3. 读客户端发来的数据
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        System.out.println("收到：" + new String(buffer, 0, len));

        // 4. 给客户端回消息
        OutputStream os = socket.getOutputStream();
        os.write("收到，已回复！".getBytes());

        // 5. 关闭
        socket.close();
        server.close();
    }
}
