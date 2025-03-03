package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
       sqlSession.close();
    }

    //查看详情
    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id = 1;
        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5.释放资源
        sqlSession.close();
    }

    //条件查询
    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "有限公司";
        String brandName= "小米";


        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";


        //封装对象
            Brand brand = new Brand();
            brand.setCompanyName(companyName);
            brand.setBrandName(brandName);
            brand.setStatus(status);

        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }

    //单条件动态查询
    @Test
    public void testSelectByConditionSigle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "有限公司";
        String brandName= "小米";


        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";


        //封装对象
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);

        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectByConditionSigle(brand);
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }

    //添加
    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "彩云昊昊有限公司";
        String brandName= "zyh";
        String description = "我不打！";
        int ordered = 90;


        //封装对象
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);

        //提交事务

        //5.释放资源
        sqlSession.close();
    }

    //获取id
    @Test
    public void testAdd2() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "彩云昊昊有限公司";
        String brandName= "zyh";
        String description = "我不打！";
        int ordered = 100;


        //封装对象
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //提交事务

        //5.释放资源
        sqlSession.close();
    }

    //修改
    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "彩云昊昊有限公司";
        String brandName= "zyh";
        String description = "我不打！我不去！";
        int ordered = 99;
        int id =6 ;


        //封装对象
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setId(id);

        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        int count =brandMapper.update(brand);
        System.out.println(count);

        //提交事务

        //5.释放资源
        sqlSession.close();
    }


    //根据id删除
    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id =6 ;


        //封装对象


        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteById(id);

        //提交事务

        //5.释放资源
        sqlSession.close();
    }
    //根据id批量删除
    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] ids = new int[]{10,11,12} ;


        //封装对象


        //1.获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteByIds(ids);

        //提交事务

        //5.释放资源
        sqlSession.close();
    }
}
