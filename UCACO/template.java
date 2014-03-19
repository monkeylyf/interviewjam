/*
ID: laituan1
LANG: JAVA
TASK: test
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class test {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  public static void main (String [] args) throws IOException {

    in = new BufferedReader(new FileReader("test.in"));
    out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	tok = new StringTokenizer("");

	solve();
	in.close();
	out.close();
    System.exit(0);
  }

  public static void solve() throws IOException {
		
	
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
