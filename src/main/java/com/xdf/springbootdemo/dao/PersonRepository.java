package com.xdf.springbootdemo.dao;

import com.xdf.springbootdemo.pojo.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/12
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

    //查询指定用户姓名的用户
    public Person findByNameIs(String name);

    //查询指定用户姓名和密码都相同的用户
    public Person findByNameAndAge(String name,Integer age);

    //查询包含指定名字的用户
    public List<Person> findByNameContaining(String name);

    //查询指定姓名的用户
    @Query("select p from Person p where p.name=:name")
    public Person getPerson(@Param("name") String name);

    //用户登录验证
    @Query("select p from Person p where p.name=?1 and p.age=?2")
    public Person login(@Param("name") String name,@Param("age") Integer age);

    //模糊查询用户名里面包含指定字符
    @Query("select p from Person p where p.name like %:name%")
    public List<Person> getNamesLike(@Param("name") String name);

    //查询年龄位数是5位数的全部用户,使用mysql原始sql语句进行查询
    @Query(value = "select * from Person where length(age) = 5 ",nativeQuery = true)
    public List<Person> getAgeisFive();

    //修改用户名称，使用自定义语句来更新,需要显示声明开启写事务
    @Modifying
    @Transactional(readOnly = false)
    @Query("update Person p set p.name=?2 where p.id = ?1")
    int updateName(Long id,String name);

    //删除指定用户用户,需要显示声明开启写事务
    @Modifying
    @Transactional
    @Query("delete from Person  p where p.name = ?1")
    int deleteName(String name);

    // 排序查询，返回list集合
    List<Person> findByNameContaining(String name, Sort sort);

    //分页查询， 查询计算元素总个数、总页数，数据多的情况下，代价是昂贵的
    Page<Person> findByNameContaining(String name , Pageable pageable);

    //分页查询，返回的是一个片段，它只知道下一片段或者上一片段是否可用。
    Slice<Person> getByNameContaining(String name, Pageable pageable);

    //查询指定用户名称，按照id降序排序第一条记录
    Person findFirstByNameOrderByIdDesc(String name);

    //模糊查询指定用户名称，按照id降序排序前10条记录
    List<Person> findFirst10ByNameLikeOrderByIdDesc(String name);

    //查询指定用户名称，按照id升序排序第一条记录
    Person findTopByNameOrderByIdAsc(String name);

    //模糊查询指定用户名称，按照id升序排序前10条记录
    List<Person> findTop10ByNameLikeOrderByIdAsc(String name);

    @Query("select p from Person  p join p.dogs d where p.id = ?1")
    Person findPerson(@Param("id") Long id);
}
