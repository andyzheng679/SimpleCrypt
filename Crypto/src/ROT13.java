import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private Character cs;
    private Character cf;


    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        char[] chars = text.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if (chars[i] >= 'a' && chars[i] <= 'm' || chars[i] >= 'A' && chars[i] <= 'M'){
                int holder = (int) chars[i] + 13;
                chars[i] = (char) holder;
            } else if (chars[i] >= 'n' && chars[i] <= 'z' || chars[i] >= 'N' && chars[i] <= 'Z') {
                int holder = (int) chars[i] - 13;
                chars[i] = (char) holder;
            }
        }

        return new String(chars);
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                index = i;
                break;
            }
        }

        String rotate = s.substring(index) + s.substring(0, index);

        return rotate;
    }

    public void reader(){

        try{
            Scanner fileIn = new Scanner(new File("/Users/andy/Desktop/Projects/SimpleCrypt/sonnet18.txt"));

            while (fileIn.hasNext()){
                String lineIn = fileIn.nextLine();
                encrypt(lineIn);
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
    }

}
