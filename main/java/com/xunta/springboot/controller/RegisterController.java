package com.xunta.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.xunta.springboot.service.IRegisterService;
import com.xunta.springboot.entity.Register;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author school
 * @since 2024-03-28
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

        //动态生成
        @Resource
          private IRegisterService registerService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Register register) {
                return registerService.saveOrUpdate(register);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return registerService.removeById(id);
                }
        //批量删除
        @PostMapping("/del/batch")
         public boolean deleteBatch(@RequestBody List<Integer> ids){
            return registerService.removeByIds(ids);
        }
        //查询所有
        @GetMapping
          public List<Register> findAll() {
                return registerService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Register findOne(@PathVariable Integer id) {
                return registerService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Register> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Register> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return registerService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
}

