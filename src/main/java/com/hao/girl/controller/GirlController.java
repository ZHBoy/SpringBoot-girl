package com.hao.girl.controller;

import com.hao.girl.domain.Girl;
import com.hao.girl.domain.Result;
import com.hao.girl.repository.GrilRepository;
import com.hao.girl.service.GirlService;
import com.hao.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GrilRepository grilRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return grilRepository.findAll();
    }

    /**
     * 添加一条数据
     * @return
     */
    @PostMapping(value = "/girls/add")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(getGirlList());
    }

    /**
     * 查询指定一个的一条数据
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return grilRepository.findOne(id);
    }

    /**
     * 更新指定一条数据
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(
            @PathVariable("id") Integer id,
            @RequestParam("cupSize") String cupSize,
            @RequestParam("age") Integer age){

        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return grilRepository.save(girl);
    }

    /**
     * 删除指定一条数据
     * @param id
     */
    @DeleteMapping(value = "/girls_del/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        grilRepository.delete(id);
    }

    /**
     * 删除所有数据
     */
    @DeleteMapping(value = "/girls_del")
    public void girlDeleteAll(){
        grilRepository.deleteAll();
    }

    /**
     * 按照指定年龄搜索
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getListByAge(@PathVariable("age") Integer age){
        return grilRepository.findByAge(age);
    }

    /**
     * 测试事务，添加两条数据
     */
    @PostMapping(value = "girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    /**
     * 统一异常处理测试
     * @param id
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
