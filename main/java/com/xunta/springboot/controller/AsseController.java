package com.xunta.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.xunta.springboot.service.IAsseService;
import com.xunta.springboot.entity.Asse;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author school
 * @since 2023-04-13
 */
@RestController
@RequestMapping("/asse")
public class AsseController {

        //动态生成
        @Resource
          private IAsseService asseService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Asse asse) {
                return asseService.saveOrUpdate(asse);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return asseService.removeById(id);
                }
        //批量删除
        @PostMapping("/del/batch")
         public boolean deleteBatch(@RequestBody List<Integer> ids){
            return asseService.removeByIds(ids);
        }
        //查询所有
        @GetMapping
          public List<Asse> findAll() {
                return asseService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Asse findOne(@PathVariable Integer id) {
                return asseService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Asse> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Asse> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return asseService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
}

