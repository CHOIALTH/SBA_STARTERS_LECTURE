package chap15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInTest {

	public static void main(String[] args) throws Exception {

			FileReader fis = new FileReader("src/chap15/FileViewer.java"); 
			BufferedReader br = new BufferedReader(fis, 10);
			// ""안에 읽어올 파일경로 및 파일명 ex) "c:/test/a.java"
			while (true) {
				/*
				 * int data = br.read(); // 4byte 중 2byte만 활용 if(data == -1) {break;}
				 * System.out.println((char)data);; // 파일에서 입력받은 내용을 모니터에 출력
				 */			
				String line = br.readLine();
				if(line == null) break;
				System.out.println(line);
				
			}	
			br.close();
		} 

	}

