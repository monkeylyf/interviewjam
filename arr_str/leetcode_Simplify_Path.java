/*Simplify_Path

Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

class leetcode_Simplify_Path {
    public static void main(String[] args) {
    }
    public static String simplifyPath(String path) {
        if (path.length() == 0) {
            return path;
        }
        char[] sPath = new char[path.length()];
        sPath[0] = '/';
        int top = 1;
        Stack<Integer> prev = new Stack<Integer>();
        prev.push(1);
        // The first char must be '/', because this is an absolute path.
        int i = 1;
        while (i < path.length()) {
            if (getAt(path, i) == '.' && getAt(path, i + 1) == '.') {
                prev.pop();
                if (prev.empty()) {
                    prev.push(1); //'/../' should be just '/'
                }
                top = prev.peek();
                i += 3;
            } else if (getAt(path, i) == '.' && (i + 1 == path.length() || getAt(path, i + 1) == '/')) {
                top = prev.peek();
                i += 2;
            } else if (getAt(path, i) == '/') {
                // Remove redundant slashes.
                if (sPath[top - 1] != '/') {
                    sPath[top++] = '/'; 
                    prev.push(top);
                    ++i;
                } else {
                    ++i;
                }
            } else {
                sPath[top++] = getAt(path, i);
                ++i;
            }
        }
        //remove trailing '/'
        if (top > 1 && sPath[top - 1] == '/') {
            --top;
        }
        char[] ret = new char[top];
        System.arraycopy(sPath, 0, ret, 0, top);
        return new String(ret);
    }
    public static char getAt(String path, int i) {
        if (i >= 0 && i < path.length()) {
            return path.charAt(i);
        } else {
            return '\\'; //any char other than '.' or '/' will do
        }
    }
}
