package finalproject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Project {
    
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileReader("src/main/java/finalproject/team.txt"));
		int cntOfStu = 19;
		int cntOfTeam = 4; //프로젝트조의 갯수
		int cntOfGroup = cntOfStu % cntOfTeam == 0 ?  cntOfStu / cntOfTeam: cntOfStu / cntOfTeam +1;//성적별 4명씩 묶은 그룹
		System.out.println("===본인의 그룹입니다(성적별 그룹당 1명씩 뽑아서 1개조를 구성합니다).===");
		Map<String, List<String>> groupMap = new HashMap<String, List<String>>();
		
		for(int i = 1; i <= cntOfGroup; i++) {
			List<String> group = new ArrayList<String>();
			for(int j = 1; j <= cntOfTeam && sc.hasNextLine(); j++) {
				group.add(sc.nextLine());
			}
			groupMap.put(i+"그룹", group);
		}
		
		for(String k : groupMap.keySet()) {
			System.out.println(k + ":" + groupMap.get(k));
		}
		
		System.out.println("===섞이는 중입니다.===");
		int cnt = 0;
		for(String k : groupMap.keySet()) {
			List<String> shufflelist = groupMap.get(k);
			Collections.shuffle(shufflelist);
			Thread.sleep(1000);
			System.out.println(shufflelist);
			
		}
		
		for(int i = 0; i < cntOfTeam; i++) {
			System.out.println("===" + (i+1) + " 조입니다.===");
		for(String k : groupMap.keySet()) {
				System.out.println( (i+1) + "조 : " + groupMap.get(k).get(i) );
			}
			System.out.println("========================================");
		}
		
		/*System.out.println("===본인의 조입니다.===");
		Map<String, List<String>> teamMap = new HashMap<String, List<String>>();
			List<String> team = new ArrayList<String>();
			//for(int i = 0; i < cntOfTeam; i++) {
				team.add(shufflelist.get(0));
			//}
			teamMap.put(k.substring(0, 1)+"조", team);
		}
		
		*/

		
		//for(String k : teamMap.keySet()) {
		//	System.out.println(k + ":" + teamMap.get(k));
		//}
		
		

	}

}
