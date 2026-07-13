package classdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取class文件
        Class<?> clazz = Class.forName("classdemo.Student");
        //获取公共的构造方法（Constructors）
        Constructor[] a = clazz.getConstructors();
        for (Constructor constructor : a) {
            System.out.println(constructor);
        }
        System.out.println("------------------------------------------------------");
        //获取全部的构造方法包括private修饰的，Declared表示带权限的
        Constructor[] b = clazz.getDeclaredConstructors();
        for (Constructor constructor : b) {
            System.out.println(constructor);
        }
        System.out.println("------------------------------------------------------");
        //获取单个对象的构造方法
        Constructor c = clazz.getConstructor(String.class, int.class);
        System.out.println(c);
        System.out.println("------------------------------------------------------");
        //获取带有权限的单个对象的构造方法
        Constructor<?> d = clazz.getDeclaredConstructor(int.class);
        System.out.println(d);
        System.out.println("------------------------------------------------------");
        //获取修饰符
        //暴利获取
         d.setAccessible(true);
        int modifiers = d.getModifiers();
        System.out.println(modifiers);

        //获取里面的参数
        System.out.println("------------------------------------------------------");
        Parameter[] parameters = d.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        System.out.println("------------------------------------------------------");
        //创建对象
        Student o = (Student) c.newInstance("张三", 18);
        System.out.println(o);

    }
}
