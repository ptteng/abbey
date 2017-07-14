package com.ljl.study.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ljl.study.entity.Stu;

/** 
* @author alin 
* @version 2017��6��7��
* ��˵�� 
*/
public class StuDAOTest {
	public static SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * ����id��ѯѧԱ
	 * @throws Exception
	 */
	@Test
	public void testQueryById()  throws Exception{
		Stu stu = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {

			/* Un-recommended Method */
			
			/*
			 * stu = (Stu)session.selectOne(
			 * "com.nicchagil.mybatisonly.mapper.UserMapper.queryUser",username);
			 */

			/* Recommended Method */
			StuDAO stuDAO = session.getMapper(StuDAO.class);
			stu = stuDAO.queryById(1);

			System.out.println("id - " + stu.getId() + " , name - " + stu.getName());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	/**
	 * ��ѯ����ѧԱ��Ϣ
	 */
	@Test
	public void testQueryAll() {
		List<Stu> all = new ArrayList<Stu>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StuDAO stuDAO = session.getMapper(StuDAO.class);
			all = stuDAO.queryAll();
			for (int i = 0; i < all.size(); i++) {//��������
			    System.out.println(all.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	/**
	 * ����õķ�������ǰ����ǲ�һ���ģ�Ҳ���Ƽ�
	 */
	@Ignore
	public void test() {
		//��ȡ��Դ�ļ�
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

			// �õ�sessionFactory��ʹ�����������ȡxml�ļ�
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			// ��session�������ܹ�ִ�������ļ���sql�ģ�sqlSession
			SqlSession session = factory.openSession();
			// ��ѯһ������session.selectOne("ע����������ռ�sqlӳ�� + servlet ��id���ڼ���");
			Stu stu= session.selectOne("com.ljl.study.entity.Stu.getStu", 1);
			System.out.println(stu);
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
