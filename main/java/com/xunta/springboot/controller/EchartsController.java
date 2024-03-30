package com.xunta.springboot.controller;

import cn.hutool.core.collection.CollUtil;
import com.xunta.springboot.common.Result;
import com.xunta.springboot.entity.*;
import com.xunta.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/echarts")
public class EchartsController {
    /**
     * 按季度获取数据
     *
     * @return 返回季度数据
     */
    @Autowired
    private ICardService cardService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICertificateService certificateService;
    @Autowired
    private IUmbrellaService umbrellaService;
    @Autowired
    private IUsbService usbService;
    @Autowired
    private IBikeService bikeService;


    @GetMapping("/numbers")
    public Result numbers() {
        List<Card> list1 = cardService.list();
        List<Certificate> list2 = certificateService.list();
        List<Umbrella> list3 = umbrellaService.list();

        List<Book> list4 = bookService.list();
        List<Usb> list5 = usbService.list();
        int q1 = 0; // 校园卡
        int q2 = 0; // 证件
        int q3 = 0; // 雨伞
        int q4 = 0;//书籍
        int q5 = 0;//U盘
        for (int i=0;i<list1.size();i++) {
            q1++;
        }
        for (int i=0;i<list2.size();i++) {
            q2++;
        }
        for (int i=0;i<list3.size();i++) {
            q3++;
        }
        for (int i=0;i<list4.size();i++) {
            q4++;
        }
        for (int i=0;i<list5.size();i++) {
            q5++;
        }
        return Result.success(CollUtil.newArrayList(q1, q2, q3, q4, q5));
    }

}
