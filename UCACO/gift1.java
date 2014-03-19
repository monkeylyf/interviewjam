/*
ID: laituan1
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class gift1 {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  public static void main (String [] args) throws IOException {

    in = new BufferedReader(new FileReader("gift1.in"));
    out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
	tok = new StringTokenizer("");

	solve();
	in.close();
	out.close();
    System.exit(0);
  }

  public static void solve() throws IOException {
	int num = readInt();
	String[] names = new String[num];
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	for (int i = 0; i < num; ++i) {
	  String name = readString();
	  names[i] = name;
	  map.put(name, 0);
	}

	for (int i = 0; i < num; ++i) {
	  String name = readString();
	  int money = readInt();
	  int numPeopleToGive = readInt();
	  if (numPeopleToGive != 0) {
		int evenlyMoney = money / numPeopleToGive;
		// Net gain/loss
		map.put(name, map.get(name) + money % numPeopleToGive - money);

		for (int j = numPeopleToGive; j > 0; --j) {
		  String recipient = readString();
		  map.put(recipient, map.get(recipient) + evenlyMoney);
		}
	  } else {
		map.put(name, map.get(name) + money);	
	  }
	}

	for (String name : names) {
	  out.println(name + " " + map.get(name));  
	}
	
  }

  public static String readString() throws IOException {
	while (!tok.hasMoreTokens()) {
	  tok = new StringTokenizer(in.readLine());
	}
	return tok.nextToken();
  }

  public static int readInt() throws IOException {
	return Integer.parseInt(readString());
  }

  public static long readLong() throws IOException {
	return Long.parseLong(readString());
  }

  public static double readDouble() throws IOException {
	return Double.parseDouble(readString());
  }
}
