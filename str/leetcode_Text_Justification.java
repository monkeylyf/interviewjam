/*Text_Justification

Given an array of words and a length L, format the text such that each line has
exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as
you can in each line. Pad extra spaces ' ' when necessary so that each line has
exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the
number of spaces on a line do not divide evenly between words, the empty slots
on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is
inserted between words.
For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.
Return the formatted lines as:
[
   "This    is    an",
    "example  of text",
    "justification.  "
]
*/


import java.util.ArrayList;


class leetcode_Text_Justification {

  public static void main(String[] args) {
	String[] words = new String[] {"Here", "is", "an", "example", "of", "text", "justification."};
	System.out.println(fullJustify(new String[] {"What","must","be","shall","be."}, 12));
  }

  public static ArrayList<String> fullJustify(String[] words, int L) {
	ArrayList<String> res = new ArrayList<String>();
	ArrayList<String> tokens = new ArrayList<String>();
	StringBuilder acc = new StringBuilder(words[0]);
	tokens.add(words[0]);
	for (int i = 1; i < words.length; ++i) {
	  if (acc.length() + 1 + words[i].length() <= L) {
		// As many as words with one space between each two word in a line.
		acc.append(" ");
		acc.append(words[i]);
		tokens.add(words[i]);
	  } else {
		res.add(evenlyDistributed(tokens, L));
		acc = new StringBuilder(words[i]);
		tokens = new ArrayList<String>();
		tokens.add(words[i]);
	  }
	}
	// For the last line of text, it should be left justified and no extra space is
	// inserted between words.
	res.add(acc.toString() + new String(new char[L - acc.length()]).replace('\0', ' '));

	return res;
  }

  public static String evenlyDistributed(ArrayList<String> tokens, int L) {
	for (String word : tokens) {
	  L -= word.length(); // How many whitespaces.
	}
	if (tokens.size() == 1) {
	  // A line other than the last line might contain only one word,
	  // in this case, that line should be left-justified.
	  return tokens.get(0) + new String(new char[L]).replace('\0', ' ');
	} else {
	  int numOfSpace = tokens.size() - 1;
	  int div = L / numOfSpace;
	  int mod = L % numOfSpace;
	  StringBuilder sb = new StringBuilder();
	  for (int i = 0; i < numOfSpace; ++i) {
		int space = (i < mod) ? div + 1 : div; // How many trailing spaces current word should have.
		sb.append(tokens.get(i));
		sb.append(new String(new char[space]).replace('\0', ' '));
	  }
	  sb.append(tokens.get(numOfSpace));// Last word have no trailing spaces.

	  return sb.toString();
	}
  }
}

/* Python Version
def fullJustify(self, words, L):
    if not words:
        return []
    if not L:
        return words

    # Tokenize the input words.
    ret = []
    container = []
    line_tokens = [words[0]]
    size_acc = len(words[0])
    for i in xrange(1, len(words)):
        val = words[i]
        if size_acc + len(val) + 1 <= L:
            size_acc += len(val) + 1
            line_tokens.append(val)
        else:
            # Change to a new line.
            container.append(line_tokens)
            # Init.
            line_tokens = [val]
            size_acc = len(val)
    # Check-in what is left-over
    if line_tokens:
        container.append(line_tokens)
    
    # Justification.
    for i in xrange(len(container) - 1):
        tokens = container[i]
        to_fill = reduce(lambda acc, it : acc - len(it), tokens, L)
        if len(tokens) == 1:
            ret.append(tokens[0] + to_fill * ' ')
        else:                     
            (div, mod) = divmod(to_fill, len(tokens) - 1)
            acc = tokens[0]    
            for i in xrange(1, len(tokens)):
                acc += ' ' * (div + 1) if i <= mod else ' ' * div
                acc += tokens[i]
            ret.append(acc)
    # Last line is special case.
    tokens = container[-1] 
    length = reduce(lambda x, y : x + len(y), tokens, 0)
    acc = tokens[0]
    for i in xrange(1, len(tokens)):
        acc += ' ' + tokens[i]  
    acc += ' ' * (L - len(acc))
    ret.append(acc)

    return ret
*/
