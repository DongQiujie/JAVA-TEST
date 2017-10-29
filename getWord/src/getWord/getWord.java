package getWord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;

public class getWord {

	public static void main(String[] args) throws IOException  {
		
		readWord();
	}

//	public static void readWord3() throws IOException {
//		FileReader isr=new FileReader(".\\files\\ceshi.txt");
//		char[] buf=new char[1024];
//		int len=isr.read(buf);
//		String str=new String(buf, 0, len);
//		int lem=str.getBytes("GBK").length;
//		for (int i = 0; i < lem; i++) {
//			System.out.println("截取"+(i+1)+"字节的结果是:::"+outStringByBite(str,i+1));
//		}
//		
//	}
//
//	public static String outStringByBite(String str, int len) throws IOException {
//		byte[] buf=str.getBytes("GBK");
//		int count=0;
//		for (int x=len-1;x>=0;x--) {
//			if(buf[x]<0)
//				count++;
//			else
//				break;
//		}
//		if(count%2==0)
//			return new String(buf, 0, len,"GBK");
//		else
//			return new String(buf,0,len-1,"GBK");
//	}

//	private static void readWord2() throws IOException {
//		FileReader fr=new FileReader(".\\files\\ceshi.txt");
//		LineNumberReader lnr=new LineNumberReader(fr);
//		String line=null;
//		lnr.setLineNumber(1024);
//		while((line=lnr.readLine())!=null) {
//			System.out.println(line);
//		}
//		lnr.close();
//	}

	private static void readWord() {
		InputStreamReader isr=null;
		try {
			isr=new InputStreamReader(new FileInputStream(".\\files\\ceshi.txt"),"GBK");
			char[] buf=new char[1024];
			int len=isr.read(buf);
			String str=new String(buf, 0, len);
			System.out.println(str);
			
		} catch (Exception e) {
			throw new RuntimeException("对不起，读取错误");
		} finally {
			if(isr!=null) 
			try {
				isr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
