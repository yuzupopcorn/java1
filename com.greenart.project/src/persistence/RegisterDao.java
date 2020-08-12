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
			list = sql.selectList("registerMapper.selectAll");

		} finally {
			sql.close();
		}

		return list;
	}

	public void memberInsert() {
		SqlSession sql = sqlSessionFactory.openSession();
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

	public void memberDelete(int id) {
		SqlSession sql = sqlSessionFactory.openSession();
		sql.delete("registerMapper.deleteMember",id);
	}

	public void memberUpdate(Register register) { 
		SqlSession sql = sqlSessionFactory.openSession();
		sql.update("registerMapper.updateMember",register);
		
		try {
			sql.selectOne("registerMapper, select Count");
			
		}finally {
			sql.commit(); // ��� ���� ������ ����� commit
			sql.close();
		}

	}

	public int memberCount() {
		SqlSession sql = sqlSessionFactory.openSession();
		
		int num =0;
		try {
			sql.selectOne("registerMapper, select Count");
			
		}finally {
			sql.commit(); // ��� ���� ������ ����� commit
			sql.close();
		}
		return 0;
	}
}
