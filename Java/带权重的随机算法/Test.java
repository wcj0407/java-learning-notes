package IO2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        //读取文本文件到数组中
        ArrayList<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("D:\\zhuomian\\IOliu\\src\\IO2\\ccc.txt"));
        String line;
        //读取一整行的信息(readLine)
        while((line=br.readLine())!=null) {
            String[] arr = line.split("-");
            Student stu = new Student(arr[0],arr[1],Integer.parseInt(arr[2]),Double.parseDouble(arr[3]));
            list.add(stu);
        }
        br.close();
        Double weight=0.0;
        for (Student stu : list) {
           weight = weight+ stu.getWeiget();
        }

        double [] arr = new double[list.size()];
        int index = 0;
        for (Student stu : list) {
            arr[index] = stu.getWeiget() / weight;
            index++;
        }
       for (int i = 1; i < arr.length; i++) {
           arr[i]=arr[i]+arr[i-1];
       }

       double number = Math.random();
       int index1 = -Arrays.binarySearch(arr,number)-1;
        Student stu1 = list.get(index1);
        System.out.println(stu1);

        double v = stu1.getWeiget() / 2;
        stu1.setWeiget(v);

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\zhuomian\\IOliu\\src\\IO2\\ccc.txt"));
        for (Student s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();


    }



}
