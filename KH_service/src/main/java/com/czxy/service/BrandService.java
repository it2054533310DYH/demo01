package com.czxy.service;

import com.czxy.domain.Brand;

import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/7 00:24
 * @Description:
 */
public interface BrandService {


    public List<Brand> findList();

    void delete(String id);

    void add(Brand brand);
}