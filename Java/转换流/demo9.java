package IO;

import java.io.*;

public class demo9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\zhuomian\\IOliu\\ccc.txt")));
        String s = br.readLine();
        System.out.println(s);
    }
}
