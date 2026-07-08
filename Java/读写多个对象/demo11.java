package IO;

import java.io.*;
import java.util.ArrayList;

public class demo11 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Student s1 = new Student("zhangsan",18);
        Student s2 = new Student("lisi",19);
        Student s3 = new Student("wangwu",20);

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);




       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\zhuomian\\IOliu\\ddd.txt"));
       oos.writeObject(list);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\zhuomian\\IOliu\\ddd.txt"));
         ArrayList<Student> list1 =(ArrayList<Student>)ois.readObject();
        for (Student student : list1) {
            System.out.println(student);
        }

        oos.close();
        ois.close();

    }
}
