package persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Register;

public class RegisterDao { // db session + mapper = 사용하게끔 메소드 생성

	private static SqlSessionFactory sqlSessionFactory;

	public RegisterDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	// 연결 객체가 생성

	// 연결 객체 사용 - opensession();

	public List<Register> memberList() {
		SqlSession sql = sqlSessionFactory.openSession();
		List<Register> list = null;
		try {
			list = sql.selectList("mybatis.registerMapper.selectAll");

		} finally {
			sql.close();
		}

		return list;
	}

	public void memberInsert(Register register) {
		SqlSession sql = sqlSessionFactory.openSession();

		try {
			sql.insert("mybatis.registerMapper.memberInsert", register);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}

	}

	public void memberDelete(int id) {
		SqlSession sql = sqlSessionFactory.openSession();
		try {
			sql.delete("mybatis.registerMapper.deleteMember", id);
		} finally {
			sql.commit();
			sql.close();
		}

	}

	public void memberUpdate(Register register) {
		SqlSession sql = sqlSessionFactory.openSession();
		sql.update("mybatis.registerMapper.updateMember", register);

		try {
			sql.selectOne("mybatis.registerMapper.selectCount");

		} finally {
			sql.commit(); // 디비에 내용 변동이 생기면 commit
			sql.close();
		}

	}

	public int memberCount() {
		SqlSession sql = sqlSessionFactory.openSession();

		int num = 0;
		try {
			num = sql.selectOne("mybatis.registerMapper.selectCount");

		} finally {
			sql.commit(); // 디비에 내용 변동이 생기면 commit
			sql.close();
		}
		return num;
	}
}
