package classdemo;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
       //第一种获取方法
        //最为常用
        Class aClass = Class.forName("classdemo.Student");
        System.out.println(aClass);

        //第二种获取方法
        //通常做为参数进行使用
        Class studentClass = Student.class;
        System.out.println(studentClass);

        //第三种获取方法
        //当我们有这个对象的时候才能使用
        Student student = new Student();
        Class aClass1 = student.getClass();
        System.out.println(aClass1);
    }
}
