# ##HashMap练习2

```
package com.xiaowang.map;

import java.util.*;

public class HashMapdemo2 {
    //某个班级80名学生，现在需要组成秋游活动，班长提供了四个景点依次是（A、B、C、D），每个学生只
    //能选择一个景点，请统计出最终哪个景点想去的人数最多。
    public static void main(String[] args) {
        String [] arr={"A","B","C","D"};
        ArrayList<String> list=new ArrayList<>();
        Random r = new Random();
        for(int i=0;i<80;i++){
            int a =r.nextInt(arr.length);
           list.add(arr[a]);
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(String name:list) {
            if(map.containsKey(name)){
                int count = map.get(name);
                count++;
                map.put(name,count);
            }else {
                map.put(name,1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry :entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());

        }






        int max=0;
        for(Map.Entry<String,Integer> entry :entries) {
            if(entry.getValue()>max){
                max=entry.getValue();
            }
        }
       System.out.println(max);

        for(Map.Entry<String,Integer> entry :entries) {
               int count = entry.getValue();
                if(count==max){
                    System.out.println(entry.getKey());
            }
        }

    }

}
```



#### Map 方法：

- `containsKey()` 判断是否存在 key
- `get()`  取值
- `put()`  存/更新值

#### List 方法：

- `add()`  添加数据

**entrySet 增强 for 遍历**

###  特点：

一次拿到 key + value

最常用 Map 遍历方式