package com.czxy.controller;

import com.czxy.domain.Brand;
import com.czxy.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/7 00:27
 * @Description:
 */
@RestController
@RequestMapping("brand")
public class BrandServlet {

    @Resource
    private BrandService brandService;


    @GetMapping("findAll")
    public ResponseEntity<List<Brand>> findAll(){


        List<Brand> list = null;
        try {
            list = brandService.findList();

            System.out.println("集合:"+list);
            return new ResponseEntity<>(list, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    /**
     * 删除对象
     */
    @RequestMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){

        System.out.println("需要删除对象的id:"+id);
        try {
            brandService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }

    /**
     * 添加对象
     */
    @PostMapping("add")
    public ResponseEntity<Void> addBrand(Brand brand){

        System.out.println("需要添加的对象:"+brand);
        try {
            brandService.add(brand);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }



}