package Server;

import java.io.IOException;

import GUI.Dialog;

public class Host {
	public static String url;

	public Host() {
		try {
			HttpRequest url = new HttpRequest(
					"https://script.google.com/macros/s/AKfycbwUblnxwQpG7VejPhF8Z9vpVwqsriPw_zNZpiLXjg780V7HiIF1/exec",
					"GET");
			url.start();
			synchronized (url) {
				url.wait();
			}
			Host.url = url.toString();
		} catch (IOException e) {
			Dialog dialog = new Dialog();
			dialog.show("���~", "�L�k���o���A����m");
		} catch (InterruptedException e) {
			Dialog dialog = new Dialog();
			dialog.show("���~", "���o���A����m���������");
		}
	}
}
