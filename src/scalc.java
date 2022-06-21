import java.io.IOException;
import java.util.Scanner;

public class scalc {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String op = in.nextLine();
        System.out.println(scan(op));
    }
    public static String scan(String input) throws IOException {
        String d;
        String[] strings = input.split("\" ");
        String a, b ,c;
        if ((strings[1].charAt(0)=='+')||(strings[1].charAt(0)=='-')){
            String[] strings2 = strings[1].split(" \"");
            a = strings[0];
            b = strings2[0];
            c = strings2[1];
            d = calc(a, b, c).toString();
        }else if ((strings[1].charAt(0)=='*')||(strings[1].charAt(0)=='/')){
            String[] strings2 = strings[1].split(" ");
            a = strings[0];
            b = strings2[0];
            c = strings2[1];
            d = calc(a, b, c).toString();
        }else {
            throw new IOException();
        }
        return d;

    }


    public static StringBuffer calc(String i1, String i2, String i3) throws IOException {
        StringBuffer d = new StringBuffer();
        String ds;
        int di;
        int ii3;
        if ((i1.charAt(0)=='\"')){
        i1 = i1.replaceAll("\"","");
        i3 = i3.replaceAll("\"","");
            switch (i2) {
                case "*" -> {
                    ii3 = Integer.parseInt(i3);
                    if ((ii3<=10)&&(ii3>=1)) {
                        d.append(i1.repeat(ii3));
                    }else {throw new IOException();}
                }
                case "/" -> {
                    ii3 = Integer.parseInt(i3);
                    if ((ii3<=10)&&(ii3>=1)) {
                    di = i1.length() / ii3;
                    d = new StringBuffer(i1.substring(0, di));
                    }else {throw new IOException();}
                }
                case "+" -> d = new StringBuffer(i1 + i3);
                case "-" -> d = new StringBuffer(i1.replaceAll(i3, ""));
                default -> throw new IOException();
            }
            return d;
        } else {throw new IOException();}
        }

}




