package classdemo;

import java.lang.reflect.Field;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //获取公共的成员变量
        Class clazz = Class.forName("classdemo.Student");
        Field[] a = clazz.getFields();
        for (Field field : a) {
            System.out.println(field);
        }
        System.out.println("-----------------------");
        //获取全部的成员变量
        Field[] b = clazz.getDeclaredFields();
        for (Field field : b) {
            System.out.println(field);
        }


        System.out.println("-----------------------");
        //获取单个公共的成员变量
        Field c = clazz.getField("gender");
        System.out.println(c);
        System.out.println("-----------------------");
        Field name = clazz.getDeclaredField("name");
        System.out.println(name);

        System.out.println("-----------------------");
        //获取修饰符
        name.setAccessible(true);
        int modifiers = name.getModifiers();
        System.out.println(modifiers);

        System.out.println("-----------------------");
        //获取成员变量的名字
        String name1 = name.getName();
        System.out.println(name1);
        System.out.println("-----------------------");
        //获取成员变量的数据类型
        Class<?> type = name.getType();
        System.out.println(type);
        System.out.println("-----------------------");
        //获取成员变量记录的值
        Student stu = new Student("zhangsan",18);
        String o =(String) name.get(stu);
        System.out.println(o);
        System.out.println("-----------------------");
        name.set(stu,"lisi");
        System.out.println(stu);
    }
}
