package IO;

import java.io.*;

public class demo10 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Student s1 = new Student("zhangsan",18);

       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\zhuomian\\IOliu\\ddd.txt"));
       oos.writeObject(s1);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\zhuomian\\IOliu\\ddd.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        oos.close();
        ois.close();

    }
}
