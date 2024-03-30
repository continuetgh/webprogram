package com.xunta.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunta.springboot.entity.Umbrella;
import com.xunta.springboot.service.IUmbrellaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author school
 * @since 2023-04-08
 */
@RestController
@RequestMapping("/umbrella")
public class UmbrellaController {

        //动态生成
        @Resource
          private IUmbrellaService umbrellaService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Umbrella umbrella) {
                return umbrellaService.saveOrUpdate(umbrella);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return umbrellaService.removeById(id);
                }
        //批量删除
        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids){return umbrellaService.removeByIds(ids);}
        //查询所有
        @GetMapping
          public List<Umbrella> findAll() {
                return umbrellaService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Umbrella findOne(@PathVariable Integer id) {
                return umbrellaService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Umbrella> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Umbrella> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return umbrellaService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
}

