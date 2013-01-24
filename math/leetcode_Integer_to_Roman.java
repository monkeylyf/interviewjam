/*Integer_to_Roman

Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

class leetcode_Integer_to_Roman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
    public static String intToRoman(int num) {
        StringBuilder roman= new StringBuilder();
        int thousand = num / 1000;
        int hundred = (num % 1000) / 100;
        int ten = (num % 100) / 10;
        int one = num % 10;
        roman.append(build(thousand, 3));
        roman.append(build(hundred, 2));
        roman.append(build(ten, 1));
        roman.append(build(one, 0));
        return roman.toString();
    }
    public static String build(int num, int level) {
        //0: ones, 1: tens, 2: hundreds, 3: thousands
        String s1 = null, s2 = null, s3 = null;
        String[] xlate = {"I", "V", "X", "L", "C", "D", "M"};
        switch (level) {
            case 0:
                s1 = xlate[0];
                s2 = xlate[1];
                s3 = xlate[2];
                break;
            case 1:
                s1 = xlate[2];
                s2 = xlate[3];
                s3 = xlate[4];
                break;
            case 2:
                s1 = xlate[4];
                s2 = xlate[5];
                s3 = xlate[6];
                break;
            case 3:
                s1 = xlate[6];
                s2 = null;
                s3 = null;
                break;
        }
        StringBuilder str = new StringBuilder();
        if (num >= 0 && num <=3) {
            for (int i = 0; i < num; i++) {
                str.append(s1);
            }
        } else if (num == 4) {
            str.append(s1 + s2);
        } else if (num >= 5 && num < 9) {
            str.append(s2);
            for (int i = 0; i < num-5; i++) {
                str.append(s1);
            }
        } else if (num == 9) {
            str.append(s1 + s3);
        }
        return str.toString();
    }
}
