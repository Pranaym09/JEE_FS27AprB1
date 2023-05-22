package com.doselect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleSeven {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		// You can Implement your main() to check your Program.
		Header h = new Header("amit@doselect.com", "_ami@dosect,.in");
		Email e = new Email(h, "Hi there Hows you", "Regards");
		EmailOperations eo = new EmailOperations();
		System.out.println(eo.emailVerify(e));
		System.out.println(eo.bodyEncryption(e));
		System.out.println(eo.greetingMessage(e));
	}
}
	class Email {
		// Implement Email Class according to the specifiaction.
		Header header;
		String body;
		String greetings;

		public Email(Header header, String body, String greetings) {
			this.header = header;
			this.body = body;
			this.greetings = greetings;
		}

		@Override
		public String toString() {
			return "Email [header=" + header + ", body=" + body + ", greetings=" + greetings + "]";
		}
	}

	class Header {
		// Implemet the Header Class according to the specifiaction.
		String from;
		String to;

		public Header(String from, String to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Header [from=" + from + ", to=" + to + "]";
		}
	}

	class EmailOperations {
		// Implemet the Three methods specified in the specified.
		public int emailVerify(Email e) {
			Pattern p = Pattern.compile("^[A-Za-z]+[_]*@[A-Za-z]+.[A-Za-z]+$");
			Matcher mFrom = p.matcher(e.header.from);
			Matcher mTo = p.matcher(e.header.to);
			if (mFrom.find() && mTo.find()) {
				return 2;
			} else if (mFrom.find() || mTo.find()) {
				return 1;
			} else {
				return 0;
			}
		}

		public String bodyEncryption(Email e) {
			String msg = e.body;
			String encMsg = "";
			char ch;
			for (int i = 0; i < msg.length(); i++) {
				ch = msg.charAt(i);
				if (ch == 'x') {
					ch = 'a';
				} else if (ch == 'y') {
					ch = 'b';
				} else if (ch == 'z') {
					ch = 'c';
				} else if (ch == 'X') {
					ch = 'A';
				} else if (ch == 'Y') {
					ch = 'B';
				} else if (ch == 'Z') {
					ch = 'C';
				} else if (ch != ' ') {
					ch = (char) (ch + 3);
				}
				encMsg += ch;
			}
			return encMsg;
		}

		public String greetingMessage(Email e) {
			String regex = "@";
			String[] name = e.header.from.split(regex);
			return e.greetings + " " + name[0];
		}
	}
