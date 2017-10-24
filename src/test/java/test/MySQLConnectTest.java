package test;

import java.io.IOException;
import java.io.Reader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alex.dao.BaseInfoDao;
import com.alex.pojo.BaseInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.junit.Test;

public class MySQLConnectTest {

	private static ApplicationContext context = null;

	public static void main(String[] args) {
		// test1();

		// test2();

		test3();
	}

	@Test
	public void Test() {
		System.out.println("aaaa");
	}

	private static void test3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		BaseInfoDao dao = ctx.getBean(BaseInfoDao.class);
		BaseInfo info = dao.selectById(2);
		System.out.println(info);

	}

	/**
	 * 使用常规的mybatis进行测试
	 */
	@SuppressWarnings("unused")
	private static void test2() {

		final String resource = "mybatis-config.xml";

		new Thread(new Runnable() {

			public void run() {

				try {

					Reader reader = Resources.getResourceAsReader(resource);

					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

					System.out.println("Done");

					SqlSession session = sqlSessionFactory.openSession();

					BaseInfoDao dao = session.getMapper(BaseInfoDao.class);

					context = new ClassPathXmlApplicationContext("spring-config.xml");

					BaseInfo baBlogInfo = context.getBean(BaseInfo.class);

					System.out.println(dao.addBlog(baBlogInfo));

					BaseInfo info = dao.selectById(1);

					session.commit();
					if (info != null) {
						System.out.println(info.getPath());
					}
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}).start();

	}

	/**
	 * 最常规的数据库连接
	 */
	@Test
	public void test1() {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;

		try {
			// 加载Oracle驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("开始尝试连接数据库");
			// 127.0.0.1是本机地址，arcgis是Oracle的数据库名
			String url = "jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&characterEncoding=UTF-8";
			String user = "root";
			String password = "root";
			con = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("连接成功！");
			// 预编译语句，“？”代表参数
			String sql = "select * from base_info where id=?";
			// 实例化预编译语句
			pre = (PreparedStatement) con.prepareStatement(sql);
			// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
			pre.setInt(1, 1);
			// 执行查询，注意括号中不需要再加参数
			rs = pre.executeQuery();
			// 当结果集不为空时
			while (rs.next()) {
				System.out.println("USER_NAME:" + rs.getString("path"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("数据库连接已关闭！");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
