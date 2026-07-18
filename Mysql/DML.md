# DML

## Insert-添加

![image-20260715230658394](images/image-20260715230658394.png)





# DQL

![image-20260715232236076](images/image-20260715232236076.png)

![image-20260715232445690](images/image-20260715232445690.png)

![image-20260715233727440](images/image-20260715233727440.png)



## 分组查询伴随着聚合函数

![image-20260718140805652](images/image-20260718140805652.png)

![image-20260718142228113](images/image-20260718142228113.png)

![image-20260718142257581](images/image-20260718142257581.png)

```
select count(id) from emp;

select gender,count(*) from emp  group by gender having count(*)>15;
```



## 排序查询

![image-20260718143602520](images/image-20260718143602520.png)

```
select * from emp order by money asc,entry_date desc ;
```



## 分页查询

![image-20260718144518620](images/image-20260718144518620.png)

要是每一页查五个数据

那么起始索引=（页码-1）*每一页的数据