package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileViewer {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			//FileInputStream fis = new FileInputStream("c:/Users/user/Desktop/TEST2.txt"); // 절대경로
			 fis = new FileInputStream("src/chap15/FileViewer.java"); 
			// ""안에 읽어올 파일경로 및 파일명 ex) "c:/test/a.java"
			while (true) {
				int data = fis.read(); // 4byte 중 1byte만 활용
				if(data == -1) {System.out.println("파일존재O");break;}System.out.println((char)data);; // 파일에서 입력받은 내용을 모니터에 출력
			}	
		} /*
			 * catch (FileNotFoundException e) { System.out.println("해당 파일은 존재하지 X"); }
			 */
		catch (IOException e) {
			System.out.println("파일 입력 중 오류 발생 O");
			e.printStackTrace();
		}
		finally {
			fis.close();
		}
	}

}
