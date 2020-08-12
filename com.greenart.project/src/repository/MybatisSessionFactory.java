package repository;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// query, sql, 질의어 : 데이터베이스 
public class MybatisSessionFactory { // config + jdbc = 연결
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
