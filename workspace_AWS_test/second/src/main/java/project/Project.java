package project;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Project {

	public static void main(String[] args) throws Exception{
		int stulength = 19;//학생수
		int group = 4;//편성조갯수
		
		String[] stu = new String[stulength];
		
		FileReader fr = new FileReader("src/main/java/project/projectnames.txt");
		Scanner fscanner = new Scanner(fr);
		int i1 = 0;
		while(fscanner.hasNextLine()) {
			stu[i1++] = fscanner.nextLine();
		}
		System.out.println("셔플전");
		for(int i2 = 0; i2 < stu.length; i2++) {
			System.out.println(stu[i2]);
		}
		
		List<String> stulist = Arrays.asList(stu);
		Collections.shuffle(stulist);
		stulist.toArray(stu);
		System.out.println("셔플후");
		for(int i2 = 0; i2 < stu.length; i2++) {
			System.out.println(stu[i2]);
		}
		
		FileWriter fw = new FileWriter("team.txt");
		int count = 0;
		for(String t : stu) {
				if(count%5 == 0 && count != 45) {
					Thread.sleep(2000);
					System.out.println("====" + ((count/5)+1) + " 조의 조원은 다음과 같습니다====");
					fw.write("====" + ((count/5)+1) + " 조의 조원은 다음과 같습니다====\n");
				}
				System.out.println(t);
				fw.write(t+"\n");
				++count;
				
		}
		fw.close();
	}

}
