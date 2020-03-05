public class Main {
    public static void main(String[] args) {
        System.out.println("RetVal: "+solution("codility"));
        System.out.println("RetVal: "+solution("aaaab"));
        System.out.println("RetVal: "+solution("hot"));
        System.out.println("RetVal: "+solution("acb"));
        System.out.println("RetVal: "+solution("dougdoug"));
        System.out.println("RetVal: "+solution("zzzzz"));
        System.out.println("RetVal: "+solution("ac"));

        System.out.println("ADCA" +" RetVal: "+removeDups("ADCA"));
        System.out.println("BABA"+" RetVal: "+removeDups("BABA"));
        System.out.println("DCDC"+" RetVal: "+removeDups("DCDC"));
        System.out.println("ADBCB"+ " RetVal: "+removeDups("ADBCB"));
        System.out.println("ABBAACDDC"+" RetVal: "+removeDups("ABBAACDDC"));
        System.out.println("DCBA" +" RetVal: "+removeDups("DCBA"));

        System.out.println("RetVal: "+solution(54, 12356));
        System.out.println("RetVal: "+solution(54, 12354));
        System.out.println("RetVal: "+solution(545, 545545));
        System.out.println("RetVal: "+solution(66, 665545));


    }

    public static String solution(String S) {

        if ( S.length() == 0 || S.length() == 1) {
            return S;
        }

        String result = "";
        for(int index =0; index < S.length()-1 ; index++) {
            if((S.charAt(index) <= S.charAt(index + 1))  ) {
                result += S.charAt(index);
            }
            else {
                int indexJ = index +1;
                for ( int x = indexJ ; x <  S.length(); x++ ){
                    result += S.charAt(x);
                }
                break;
            }

        }
        if (result == ""){
            result =  S.replace(S.charAt(0)+"","");
        }
        return result;
    }

    static String removeDups(String s){

        return  s.replaceAll("AB", "")
            .replaceAll("CD", "")
         .replaceAll("BA","")
         .replaceAll("DC", "");
    }

    static int solution(int A, int B){

        String a = String.valueOf(A);
        String b = String.valueOf(B);

        int retIndex = -1;
        for(int index = 0; index < b.length(); index++) {
            retIndex = b.indexOf(a,index) ;
            if( retIndex != -1) {
                 return retIndex;
            }
        }
        return retIndex;
    }


    static String removeDups1(String S) {
        StringBuilder sb = new StringBuilder(S);
        Boolean tryagain = true;

        for (int i = 1; i < sb.length(); i++) {

            if (sb.charAt(i) == 'A' && sb.charAt(i - 1) == 'B') {
                sb.delete(i - 1, i + 1);
                if (sb.length() < i) break;
            }
            if (sb.charAt(i) == 'C' && sb.charAt(i - 1) == 'D') {
                sb.delete(i - 1, i + 1);
                if (sb.length() < i) break;
            }
            if (i + 1 <= sb.length()) {
                if (sb.charAt(i) == 'A' && sb.charAt(i + 1) == 'B') {
                    sb.delete(i, i + 2);
                    if (sb.length() < i) break;
                }
            }
            if (i + 1 <= sb.length()) {
                if (sb.charAt(i) == 'C' && sb.charAt(i + 1) == 'D') {
                    sb.delete(i, i + 2);
                    if (sb.length() < i) break;
                }
            }

            if (i > sb.length() && tryagain) {
                i = -1;
                tryagain = false;
            }
        }

        return sb.toString();
    }

    static String stringFilter(char str[]) {
        String retString = "";
        int n = str.length;

        int i = -1;  // previous character
        int j = 0;   // current character

        while (j < n) {
            /* check if current and next character forms AB */
            if (j < n - 1 && str[j] == 'A' && str[j + 1] == 'B')
                j += 2;
            /* check if current and next character forms CD */
            if (j < n - 1 && str[j] == 'C' && str[j + 1] == 'D')
                j += 2;

                /* if current character is b */
            else if (str[j] == 'b')
                j++;

        /* if current char is 'c && last char in output
           is 'a' so delete both */
            else if (i >= 0 && str[j] == 'c' && str[i] == 'a') {
                i--;
                j++;
            }

            /* else copy curr char to output string */
            else
                str[++i] = str[j++];

        }
        retString = new String(str).substring(0, i + 1);
        return retString;
    }
}