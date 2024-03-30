package com.xunta.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.xunta.springboot.service.IComplainService;
import com.xunta.springboot.entity.Complain;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author school
 * @since 2024-03-29
 */
@RestController
@RequestMapping("/complain")
public class ComplainController {

        //动态生成
        @Resource
          private IComplainService complainService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Complain complain) {
                return complainService.saveOrUpdate(complain);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return complainService.removeById(id);
                }
        //批量删除
        @PostMapping("/del/batch")
         public boolean deleteBatch(@RequestBody List<Integer> ids){
            return complainService.removeByIds(ids);
        }
        //查询所有
        @GetMapping
          public List<Complain> findAll() {
                return complainService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Complain findOne(@PathVariable Integer id) {
                return complainService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Complain> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Complain> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return complainService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
}

