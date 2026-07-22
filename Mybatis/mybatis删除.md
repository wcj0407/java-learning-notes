# mybatis删除

## sql：delete form user where id =5;

```
@Delete("delete  from user where id =#{id}")
public void DeleteUserById(Integer id);
```

```
@Override
public void run(String... args) throws Exception {
    System.out.println("=======开始查询用户数据=======");
    List<user> userList = usermapper.findAll();
    userList.forEach(System.out::println);
    System.out.println("=======查询结束=======");
    run1(args);
}

public void run1(String... args) throws Exception {
    System.out.println("=======开始删除用户数据=======");
    usermapper.DeleteUserById(5);
    System.out.println("=======删除结束=======");
}
```