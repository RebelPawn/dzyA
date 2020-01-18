package com.num.controller;

import com.num.bean.Nummodel;
import com.num.bean.PV;
import com.num.bean.SE;
import com.num.bean.SQ;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class NumController {
    public void upNum() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);


        int a =sqlSession.selectOne("selNum");
        System.out.println(a);
        SE se=new SE();
        NumDao nd=new NumDao();
        int[] nums1;

        for(;a!=0;){
            //获取所有的数字
            List<Nummodel> nums=sqlSession.selectList("selectSE");
            for(Nummodel nummodel:nums){
                //System.out.println(nummodel);
                nums1=nd.getNum1(nummodel.getData());
                se.setId(nummodel.getId());
                se.setSe1(nums1[0]);
                se.setSe2(nums1[1]);
                se.setSe3(nums1[2]);
                se.setSe4(nums1[3]);
                se.setSe5(nums1[4]);
                se.setSe6(nums1[5]);
                sqlSession.update("updateSE",se);
                //System.out.println(se);
            }
            a =sqlSession.selectOne("selNum");
            System.out.println(a);

        }


        sqlSession.close();

    }

    public void upSQ() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        int a =sqlSession.selectOne("selSqNum");
        System.out.println(a);
        SQ sq=new SQ();
        NumDao nd=new NumDao();
        int[] nums1;

        for(;a!=0;){
            //获取所有的数字
            List<Nummodel> nums=sqlSession.selectList("selectSQ");
            for(Nummodel nummodel:nums){
                nums1=nd.getNum1(nummodel.getData());
                sq.setId(nummodel.getId());
                sq.setSq1(nums1[0]);
                sq.setSq2(nums1[1]);
                sq.setSq3(nums1[2]);
                sq.setSq4(nums1[3]);
                sq.setSq5(nums1[4]);
                sq.setSq6(nums1[5]);
                sqlSession.update("updateSQ",sq);
                System.out.println(sq);
            }
            a =sqlSession.selectOne("selSqNum");
            System.out.println(a);
        }
        sqlSession.close();

    }

    public void upPV() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        int a =sqlSession.selectOne("selPvNum");
        System.out.println(a);
        PV pv=new PV();
        NumDao nd=new NumDao();
        int[] nums1;

        for(;a!=0;){
            //获取所有的数字
            List<Nummodel> nums=sqlSession.selectList("selectPv");
            for(Nummodel nummodel:nums){
                nums1=nd.getNum1(nummodel.getData());
                pv.setId(nummodel.getId());
                pv.setPv1(nums1[0]);
                pv.setPv2(nums1[1]);
                pv.setPv3(nums1[2]);
                pv.setPv4(nums1[3]);

                sqlSession.update("updatePv",pv);
                System.out.println(pv);
            }
            a =sqlSession.selectOne("selPvNum");
            System.out.println(a);
        }
        sqlSession.close();

    }

    public static void main(String[] args) throws IOException {
        NumController nc=new NumController();
        NumDao nd=new NumDao();
/*        for (int index=0;index<2;index++){
            nd.getNum1(4.0);
        }*/
        nc.upPV();


    }


}
