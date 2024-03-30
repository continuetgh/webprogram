package com.xunta.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.xunta.springboot.service.IInformService;
import com.xunta.springboot.entity.Inform;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author school
 * @since 2024-03-20
 */
@RestController
@RequestMapping("/inform")
public class InformController {

        //动态生成
        @Resource
          private IInformService informService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Inform inform) {
                return informService.saveOrUpdate(inform);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return informService.removeById(id);
                }
        //批量删除
        @PostMapping("/del/batch")
         public boolean deleteBatch(@RequestBody List<Integer> ids){
            return informService.removeByIds(ids);
        }
        //查询所有
        @GetMapping
          public List<Inform> findAll() {
                return informService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Inform findOne(@PathVariable Integer id) {
                return informService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Inform> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Inform> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return informService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
}

