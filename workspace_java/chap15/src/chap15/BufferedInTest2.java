package chap15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInTest2 {

	public static void main(String[] args) throws Exception {
			long start = 0, end = 0;
			// 1. 파일로부터 직접입력시 소요 시간
			// 슬래시(/)는 1개 역슬래시(\)는 2개씩
			FileReader fis = new FileReader("C:\\Users\\user\\Desktop\\day7.pdf"); 
			start = System.currentTimeMillis();
			while (true) {
				int data = fis.read();
				if(data == -1) break;
			}
			end = System.currentTimeMillis();
			System.out.println("버퍼 비사용시 소요시간 = " + (end -start) + "ms");
			// 2. 버퍼 저장 & 입력시 소요 시간
			fis = new FileReader("C:\\Users\\user\\Desktop\\day7.pdf");
			BufferedReader br = new BufferedReader(fis, 10);
			start = System.currentTimeMillis();
			while (true) {
				int data = br.read();
				if(data == -1) {break;}				
			}	
			end = System.currentTimeMillis();
			System.out.println("버퍼 사용시 소요시간 = " + (end -start) + "ms");
			br.close();
		} 

	}

