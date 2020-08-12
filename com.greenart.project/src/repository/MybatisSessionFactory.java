package repository;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// query, sql, ���Ǿ� : �����ͺ��̽� 
public class MybatisSessionFactory { // config + jdbc = ����
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "mybatis/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			
			if(sqlSessionFactory == null ) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory sqlSessionFactory() {
		return sqlSessionFactory;
	}
}
