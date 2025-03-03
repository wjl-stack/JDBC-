package com.itheima.mapper;


import com.itheima.pojo.Brand;


import java.util.List;


public interface BrandMapper {
//    查询所有
    List<Brand> selectAll();
    //查看详情
    Brand selectById(int id);
    //条件查询
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByConditionSigle(Brand brand);
    void add(Brand brand);
    int update(Brand brand);
    void deleteById(int id);
    void deleteByIds(int[] ids);//批量删除
}
