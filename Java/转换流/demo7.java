package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class demo7 {
    public static void main(String[] args) throws IOException {
        //指定字符编码来读写
        FileReader fr = new FileReader("D:\\zhuomian\\IOliu\\bbb.txt", Charset.forName("GBK"));
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();
    }
}
