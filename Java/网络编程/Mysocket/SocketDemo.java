package Mysocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        // 1. 创建 Socket 连接服务端（底层自动三次握手）
        Socket socket = new Socket("127.0.0.1", 9999);

        // 2. 获取输出流，写数据给服务端
        OutputStream os = socket.getOutputStream();
        os.write("你好，服务端！".getBytes());

        // 3. 获取输入流，读服务端返回的数据
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);  // 阻塞读
        System.out.println("收到：" + new String(buffer, 0, len));

        // 4. 关闭
        socket.close();  // 底层自动四次挥手
    }
}
