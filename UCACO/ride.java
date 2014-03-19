/*
ID: laituan1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  public static void main (String [] args) throws IOException {

    in = new BufferedReader(new FileReader("ride.in"));
    out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
	tok = new StringTokenizer("");

	solve();
	in.close();
	out.close();
    System.exit(0);
  }

  public static void solve() throws IOException {
	String comet = readString();
	String group = readString();

	long cometMulti = 1;
	long groupMulti = 1;

	for (int i = 0; i < comet.length(); ++i) {
	  cometMulti *= (comet.charAt(i) - 'A' + 1);  
	}

	for (int i = 0; i < group.length(); ++i) {
	  groupMulti *= (group.charAt(i) - 'A' + 1);
	}

	if (groupMulti % 47 == cometMulti % 47) {
	  out.println("GO");
	} else {
	  out.println("STAY");
	}
	
  }

  public static String readString() throws IOException {
	while (!tok.hasMoreTokens()) {
	  tok = new StringTokenizer(in.readLine());
	}
	return tok.nextToken();
  }
}
