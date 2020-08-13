package ex;

import java.util.List;
import java.util.Scanner;

import model.Register;
import persistence.RegisterDao;
import repository.MybatisSessionFactory;

public class MainEx {

	public static void main(String[] args) {

		RegisterDao dao = new RegisterDao(MybatisSessionFactory.sqlSessionFactory());

		Scanner s = new Scanner(System.in);
		Register r = new Register();

		while (true) {
			System.out.println("mybatis 예제");
			System.out.println("1.목록 | 2.추가 | 3.수정 | 4.삭제");
			System.out.print("선택 >> ");
			int choice = s.nextInt();
			s.nextLine();

			switch (choice) {
			case 1:
				int cnt = dao.memberCount();
				List<Register> list = dao.memberList();
				System.out.println("가입된 회원은 " + cnt + "명 입니다.");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				System.out.println();
				break;

			case 2:
				System.out.print("아이디를 입력하세요 > ");
				r.setUserid(s.next());

				System.out.print("비밀번호를 입력하세요 > ");
				r.setPasswd(s.next());

				System.out.print("이름을 입력하세요 > ");
				r.setName(s.next());

				System.out.print("주소를 입력하세요 > ");
				r.setAddr(s.next());

				System.out.print("이메일을 입력하세요 > ");
				r.setEmail(s.next());

				System.out.print("나이를 입력하세요 > ");
				r.setAge(s.nextInt());
				s.nextLine();

				dao.memberInsert(r);

				System.out.println("회원이 등록되었습니다.");
				System.out.println();
				break;

			case 3:
				System.out.print("수정할 회원 번호를 입력하세요 >");
				
				
				dao.memberUpdate(r);

				break;

			case 4:
				System.out.print("삭제할 회원 번호를 입력하세요 >");
				int num = s.nextInt();
				dao.memberDelete(num);
				System.out.println("삭제가 완료되었습니다.");
				break;

			case 5:
				return;
			}
		}
	}

}
