package com.xunta.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunta.springboot.entity.Usb;
import com.xunta.springboot.service.IUsbService;
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
@RequestMapping("/usb")
public class UsbController {

        //动态生成
        @Resource
          private IUsbService usbService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Usb usb) {
                return usbService.saveOrUpdate(usb);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return usbService.removeById(id);
                }
        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids){
        return usbService.removeByIds(ids);
    }
        //查询所有
        @GetMapping
          public List<Usb> findAll() {
                return usbService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Usb findOne(@PathVariable Integer id) {
                return usbService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Usb> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Usb> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return usbService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
}

