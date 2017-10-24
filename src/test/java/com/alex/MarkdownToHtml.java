package com.alex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.pegdown.PegDownProcessor;

/**
 * markdown转html测试
 * 
 * @author AlexZHOU 2017.10.11
 *
 */
public class MarkdownToHtml {

	@Test
	public void test() {

		System.out.println(get());
	}

	public String get() {
		String html = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("/Users/apple/PersonalAccount/PersonalAccount.md");

			char[] cbuf = new char[1024];

			while (fileReader.read(cbuf) != -1) {
				html = new String(cbuf);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
		html = pdp.markdownToHtml(html);

		return html;

	}

}
