package com.xdf.springbootdemo.controller;

import com.xdf.springbootdemo.pojo.Car;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/10
 */
@RestController
@Validated
@RequestMapping("/car")
public class CarController {

//    @RequestMapping("/findOne")
//    public Car findOneCar(){
//        Car car = new Car(1,"audi",555555.44f,new Date());
//        return car;
//    }
//
//    @RequestMapping("/getAll")
//    public List<Car> getAll(){
//        List<Car> cars = new ArrayList<>();
//        Car car = new Car(2,"audi",555555.44f,new Date());
//        Car car1 = new Car(3,"audi",55566.44f,new Date());
//        Car car2 = new Car(4,"audi",55577555.44f,new Date());
//        Car car3 = new Car(5,"audi",55855.44f,new Date());
//        cars.add(car);
//        cars.add(car1);
//        cars.add(car2);
//        cars.add(car3);
//        return  cars;
//    }

    @RequestMapping("/getCar/{name}")
    public Car getCarById(@RequestParam(name = "id") Integer id, @PathVariable(name = "name") String name){
        Car car = new Car();
        car.setId(id);
        car.setName(name);
        car.setPrice(55555555.5f);
        car.setCreatedate(new Date());
        return  car;
    }
    @RequestMapping("/getCar3")
    public Car getByCarId(@RequestBody Car car){
        return car;
    }
    @RequestMapping("/getcar4")
    public Car getCarById(Car car) {
        return car;
    }
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/valid/{group:[a-zA-Z0-9_]+}/{userid}")
    public String valid1(@PathVariable("group") String group,@PathVariable("userid") String userid){
        return group+":"+userid;
    }

    @RequestMapping("/valid2")
    public String param(@NotBlank(message = "group不能为空")
                        @RequestParam("group") String group,
                        @NotBlank(message = "email不能为空")
                        @Email(message = "不符合邮箱规格")
                        @RequestParam("email") String email){
        return group + ":" + email;
    }

    @RequestMapping("/getcarvalidation1")
    public Car getcarvalidation1(@RequestBody @Validated Car car) {

        return car;
    }

    @RequestMapping("/carvalid2")
    public String getcarvalidation4(@Validated Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return car.toString();
    }
    @InitBinder
    private void initBinder1(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    public void fenzhi(){
        System.out.println("fenzhi1创建");
        System.out.println("夏");
        System.out.println("德锋");
    }

}
