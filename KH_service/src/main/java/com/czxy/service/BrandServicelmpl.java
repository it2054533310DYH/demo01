package com.czxy.service;

import com.czxy.dao.BrandMapper;
import com.czxy.domain.Brand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/7 00:24
 * @Description:
 */
@Component
@Transactional
public class BrandServicelmpl implements BrandService{

    @Resource
    private BrandMapper brandMapper;


    @Override
    public List<Brand> findList() {

        List<Brand> brands = brandMapper.selectAll();
        return brands;

    }

    @Override
    public void delete(String id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {

        //给对象设置添加时间属性值
        brand.setAddtime(new Date());
        //调用方法,添加当前对象
        brandMapper.insert(brand);

    }

}