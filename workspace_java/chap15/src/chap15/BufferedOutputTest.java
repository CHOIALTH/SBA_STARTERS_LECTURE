package chap15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputTest {

	public static void main(String[] args) throws IOException {
		// 원본스트림 + 보조스트림
		// 
		FileOutputStream fos = new FileOutputStream("buffer.txt"); //이상 원본스트림
		BufferedOutputStream bos = new BufferedOutputStream(fos, 3); //이상 보조스트림 - 메모리 복사 후 옮기려고
		for(int i = 48; i <= 57; i++) {
			bos.write(i); // write(int) ==> int 해당문자 저장
		}
		bos.close(); // 보조 스트림부터 먼저 닫는다. 보조스트림 닫으면 fos 따로 안닫아도 됨
		//fos.close(); // 이후 원본스트림 닫는다
	}

}
