package chap11;

import java.util.ArrayList;

class Employee {
	int id;
	String name;
	int pay;
	public Employee(int id, String name, int pay) {
		this.id = id;
		this.name = name;
		this.pay = pay;
	}
	@Override
	public String toString() {
		return id + "-" + name +  "-"  +pay;
	}
}

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(5);
		list.add("java");
		list.add(10);
		list.add(3.14);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Employee e1 = new Employee(100, "이사원", 1000000);
		Employee e2 = new Employee(200, "최대리", 1500000);
		Employee e3 = new Employee(300, "김부장", 2000000);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getClass().getName() + ":");
			System.out.println(list.get(i));
			// list.get 메서드 사용시 Object 그 자체가 된다..?
		}
		/* chap11.Employee@1e643faf
		 * chap11.Employee@6e8dacdf
		 * chap11.Employee@7a79be86
		 * .toString() 형태로 출력됨
		 * */
		System.out.println(list.size()); // 위보다 사이즈 커짐
		
		
		
		// id - name - pay 형식으로 출력(toString활용)
		
	}
}
