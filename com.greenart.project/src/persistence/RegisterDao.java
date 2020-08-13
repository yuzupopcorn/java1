package persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Register;

public class RegisterDao { // db session + mapper = ����ϰԲ� �޼ҵ� ����

	private static SqlSessionFactory sqlSessionFactory;

	public RegisterDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	// ���� ��ü�� ����

	// ���� ��ü ��� - opensession();

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
			sql.commit(); // ��� ���� ������ ����� commit
			sql.close();
		}

	}

	public int memberCount() {
		SqlSession sql = sqlSessionFactory.openSession();

		int num = 0;
		try {
			num = sql.selectOne("mybatis.registerMapper.selectCount");

		} finally {
			sql.commit(); // ��� ���� ������ ����� commit
			sql.close();
		}
		return num;
	}
}
