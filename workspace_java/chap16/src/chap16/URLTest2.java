package chap16;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest2 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/JavaScript/function4.html");
			//System.out.println(url.getFile());
			String filePath = url.getFile();
			String fileName = filePath.split("/")[filePath.split("/").length-1];
			// filePath를 split 하면 배열.. 그 배열의 [-1]이 마지막 원소
			FileWriter fw = new FileWriter(fileName);
			// 같은 경로에 파일 생김.
			// 이상 function4.html 저장 = 출력을 위한 코드
			InputStream is = url.openStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
				fw.write(line);
			}
			br.close();
			fw.close();
			// 항상 close 해야하는 이유.. buffer 저장만 한 상태로 종료되므로.. 제대로 저장을 위해 close 해줘야함.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
