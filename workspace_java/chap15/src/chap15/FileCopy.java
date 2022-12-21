package chap15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	// 1. (입력파일 없는 오류) a.txt b.txt --> a.txt 파일 없다
	// 2. (출력파일 없으면 copy.txt 파일 자동생성)src/chap15/FileCopy.java copy.txt
	// 실행결과 새로운 파일생성 - refresh(F5)(또는 자동 refresh 설정) 하지 않으면 보이지 X
	// 3. (다른 파일 복사 기존 파일 저장 유지하고 출력) src/chap14/LambdaTest1.java.copy.txt
	public static void main(String[] args)throws IOException {
		FileInputStream fis = new FileInputStream(args[0]);
		FileOutputStream fos = new FileOutputStream(args[1], true);
		
		while (true) {
			int data = fis.read(); // 1byte만 활용
			if(data == -1) break;
			fos.write(data);
		}
		fis.close();
		fos.close();
	}

}
