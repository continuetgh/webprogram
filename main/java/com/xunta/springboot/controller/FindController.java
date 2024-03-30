package com.xunta.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunta.springboot.entity.Find;
import com.xunta.springboot.service.IFindService;
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
@RequestMapping("/find")
public class FindController {

        //动态生成
        @Resource
          private IFindService findService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Find find) {
                return findService.saveOrUpdate(find);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return findService.removeById(id);
                }
    //批量删除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){return findService.removeByIds(ids);}
        //查询所有
        @GetMapping
          public List<Find> findAll() {
                return findService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Find findOne(@PathVariable Integer id) {
                return findService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Find> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Find> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return findService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
}

