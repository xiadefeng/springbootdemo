package com.xdf.springbootdemo.controller;

import com.xdf.springbootdemo.dao.PersonRepository;
import com.xdf.springbootdemo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/12
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }

    @GetMapping("/getAllPerson")
    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @DeleteMapping("/deletePerson")
    public void deletePerson(@RequestParam Long id){
        personRepository.deleteById(id);
    }

    @PutMapping("/updatePerson")
    public void updatePerson(@RequestBody Person person){
        personRepository.saveAndFlush(person);
    }

    @GetMapping("/findByNameIs/{name}")
    public Person findByNameIs(@PathVariable String name){
        Person per = personRepository.findByNameIs(name);
        return per;
    }

    @GetMapping("/findByNameIsAndAge/{name}/{age}")
    public Person findByNameIsAndAge(@PathVariable String name,@PathVariable Integer age){
        return personRepository.findByNameAndAge(name,age);
    }

    @GetMapping("/findByNameContaining/{name}")
    public List<Person> findByNameContaining(@PathVariable String name){
        return personRepository.findByNameContaining(name);
    }

    @GetMapping("/getPerson/{name}")
    public Person getPerson(@PathVariable("name") String name){
       return personRepository.getPerson(name);
    }

    @GetMapping("/login/{name}/{age}")
    public Person login(@PathVariable("name") String name,@PathVariable("age") Integer age){
        return personRepository.login(name,age);
    }

    @GetMapping("/getNamesLike/{name}")
    public List<Person> getNamesLike(@PathVariable("name") String name) {
        return personRepository.getNamesLike(name);
    }

    @GetMapping("/getAgeisFive")
    public List<Person> getAgeisFive() {
        return personRepository.getAgeisFive();
    }

    @PutMapping("/updateName/{id}/{name}")
    public int updateName(@PathVariable("id") Long id,@PathVariable("name") String name) {
        return personRepository.updateName(id,name);
    }

    @DeleteMapping("/deleteName/{name}")
    public int DeleteName(@PathVariable("name") String name) {
        return personRepository.deleteName(name);
    }

    /**
     * 查询包含指定账号名称，按照id进行排序，可以指定排序规则：asc升序、desc降序
     * @param sort
     * @param name
     * @return
     */
    @GetMapping("/findByNameSort/{sort}/{name}")
    public List<Person> findByNameSort(@PathVariable("sort") String sort,@PathVariable("name") String name){
        return personRepository.findByNameContaining(name, Sort.by(Sort.Direction.fromString(sort),"id"));
    }

    /**
     * 查询包含指定账号名称，设置游标开始位置、每页记录数，可以指定按id排序:要计算总记录数（耗费sql资源较大）
     * @param name
     * @param page
     * @param size
     * @param sort
     * @return
     */
    @GetMapping("findByNamePage1/{page}/{size}/{sort}/{name}")
    public Page<Person> findByNamePage1(@PathVariable String name, @PathVariable int page, @PathVariable int size, @PathVariable String sort) {
        return personRepository.findByNameContaining(name, PageRequest.of(page, size,Sort.by(Sort.Direction.fromString(sort),"id")));
    }

    /**
     * 查询包含指定账号名称，设置游标开始位置、每页记录数，可以指定按id排序
     * @param name
     * @param page
     * @param size
     * @param sort
     * @return
     */
    @GetMapping("findByNamePage2/{page}/{size}/{sort}/{name}")
    public Slice<Person> findByNamePage2(@PathVariable String name, @PathVariable int page, @PathVariable int size, @PathVariable String sort) {
        return personRepository.getByNameContaining(name,PageRequest.of(page,size,Sort.by(Sort.Direction.fromString(sort),"id")));
    }

    @GetMapping("findFirstByNameOrderByIdDesc/{name}")
    public Person findFirstByNameOrderByIdDesc(@PathVariable("name") String name){
        return personRepository.findFirstByNameOrderByIdDesc(name);
    }

    @GetMapping("findFirst10ByNameLikeOrderByIdDesc/{name}")
    public List<Person> findFirst10ByNameLikeOrderByIdDesc(@PathVariable("name") String name) {
        return personRepository.findFirst10ByNameLikeOrderByIdDesc("%"+name+"%");
    }

    @GetMapping("findTopByNameOrderByIdAsc/{name}")
    public Person findTopByNameOrderByIdAsc(@PathVariable("name") String name) {
        return personRepository.findTopByNameOrderByIdAsc(name);
    }

    @GetMapping("findTop10ByNameLikeOrderByIdAsc/{name}")
    public List<Person> findTop10ByNameLikeOrderByIdAsc(@PathVariable String name) {
        return personRepository.findTop10ByNameLikeOrderByIdAsc("%"+name+"%");
    }

    @GetMapping("findPerson/{id}")
    public Person findPerson(@PathVariable Long id) {
        return personRepository.findPerson(id);
    }

}
