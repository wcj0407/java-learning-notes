# ##HashMap练习



创建一个HashMap集合，键是学生对象(Student)，值是籍贯(String)。
以
存储三个键值对元素，并遍历
要求：同姓名，同年龄认为是同一个学生

‘’‘java

```
package com.xiaowang.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapdemo {
    public static void main(String[] args) {
        Studentdemo1 s1 = new Studentdemo1("张三",18);
        Studentdemo1 s2 = new Studentdemo1("李四",19);
        Studentdemo1 s3 = new Studentdemo1("王五",20);
        Studentdemo1 s4 = new Studentdemo1("张三",18);

        Map<Studentdemo1,String> m = new HashMap<Studentdemo1,String>();
        m.put(s1,"广西");
        m.put(s2,"北京");
        m.put(s3,"重庆");
        m.put(s4,"湖北");

       //Lambda表达遍历
//        m.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//
//        });

        //键找值

//        Set<Studentdemo1> s = m.keySet();
//        for (Studentdemo1 a : s) {
//            String value = m.get(a);
//            System.out.println(a+"="+value);
//
//
//        }
         //键值对遍历
          Set<Map.Entry<Studentdemo1,String>> s =  m.entrySet();
          for(Map.Entry<Studentdemo1,String> a:s) {
              Studentdemo1 a1 = a.getKey();
              String a2 = a.getValue();
              System.out.println(a1);
              System.out.println(a2);
          }
    }
}
```

'''

'''java

```
package com.xiaowang.map;

import java.util.Objects;

public class Studentdemo1 {
    private String name;
    private int age;


    public Studentdemo1() {
    }

    public Studentdemo1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studentdemo1 that = (Studentdemo1) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return "Studentdemo1{name = " + name + ", age = " + age + "}";
    }
}
```

'''