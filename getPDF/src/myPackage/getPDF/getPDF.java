package myPackage.getPDF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getPDF {

	public static void main(String[] args) throws IOException {
		List<String> list = getPdf();
		for (String pdf : list) {
			System.out.println(pdf);
		}
	}

	private static List<String>getPdf() throws IOException {
		// 爬取本地文件的pdf
		BufferedReader buf = new BufferedReader(new FileReader(".\\files\\ceshi.txt"));
		// 爬取本地的网络连接中的pdf
		// URL url=new URL("file:///F:/MasterLab/JAVA_Workspace/getPDF/files/ceshi.html");//注意这里网页地址
		// BufferedReader buf=new BufferedReader(new InputStreamReader(url.openStream()));

		// 下面程序对于两个爬取操作时一致的
		String pdf_regex = "\\w+\\.pdf";
		List<String> list = new ArrayList<String>();
		Pattern pattern = Pattern.compile(pdf_regex);
		String line = null;
		while ((line = buf.readLine()) != null) {
			Matcher m = pattern.matcher(line);
			while (m.find()) {
				list.add(m.group());
			}
			
		}
		buf.close();
		return list;
	}
}
