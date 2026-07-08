package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class demo8 {
    public static void main(String[] args) throws IOException {
        //对文件进行gbk转换成utf-8
        FileReader fr = new FileReader("D:\\zhuomian\\IOliu\\bbb.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("D:\\zhuomian\\IOliu\\ccc.txt", Charset.forName("utf-8"));

        int b;
        while ((b = fr.read()) != -1) {
            fw.write(b);
        }
        fr.close();
        fw.close();
    }
}
