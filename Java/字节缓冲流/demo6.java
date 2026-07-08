package IO;

import java.io.*;

public class demo6 {
    //字节缓冲流
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\zhuomian\\aaa\\a1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\zhuomian\\bbb.txt"));

        byte[] bytes = new byte[1024];
        int len = 0;
        while((len= bis.read(bytes))!=-1) {
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }
}
