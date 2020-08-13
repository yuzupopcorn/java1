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
			System.out.println("mybatis ����");
			System.out.println("1.��� | 2.�߰� | 3.���� | 4.����");
			System.out.print("���� >> ");
			int choice = s.nextInt();
			s.nextLine();

			switch (choice) {
			case 1:
				int cnt = dao.memberCount();
				List<Register> list = dao.memberList();
				System.out.println("���Ե� ȸ���� " + cnt + "�� �Դϴ�.");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				System.out.println();
				break;

			case 2:
				System.out.print("���̵� �Է��ϼ��� > ");
				r.setUserid(s.next());

				System.out.print("��й�ȣ�� �Է��ϼ��� > ");
				r.setPasswd(s.next());

				System.out.print("�̸��� �Է��ϼ��� > ");
				r.setName(s.next());

				System.out.print("�ּҸ� �Է��ϼ��� > ");
				r.setAddr(s.next());

				System.out.print("�̸����� �Է��ϼ��� > ");
				r.setEmail(s.next());

				System.out.print("���̸� �Է��ϼ��� > ");
				r.setAge(s.nextInt());
				s.nextLine();

				dao.memberInsert(r);

				System.out.println("ȸ���� ��ϵǾ����ϴ�.");
				System.out.println();
				break;

			case 3:
				System.out.print("������ ȸ�� ��ȣ�� �Է��ϼ��� >");
				
				
				dao.memberUpdate(r);

				break;

			case 4:
				System.out.print("������ ȸ�� ��ȣ�� �Է��ϼ��� >");
				int num = s.nextInt();
				dao.memberDelete(num);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;

			case 5:
				return;
			}
		}
	}

}
