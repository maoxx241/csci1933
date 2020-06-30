public class lab3 {
    public static int recursiveReverse(int num) {
        int anwser = 0;
        int a = 0;
        while (num > 0) {
            a = num % 10;
            num = num / 10;
            anwser = anwser * 10 + a;

        }
        return anwser;
    }

    public static int fibonacciReverse(int n) {
        int n1 = 1;
        int n2 = 1;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciReverse(n - 1) + fibonacciReverse(n - 2);
        }

    }


    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        } else if (s.length() < 2) {
            return s;


        }
        char[] ch = s.toCharArray();
        int[] index = new int[ch.length];
        int length = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == 'a' || c == 'e' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'U'|| c == 'o'|| c == 'O') {
                index[length] = i;
                length++;
            }


        }
        for (int i = 0; i < length / 2; i+=1) {
            char temp = ch[index[i]];
            ch[index[i]] = ch[index[length - 1 - i]];
            ch[index[length - 1 - i]] = temp;
        }
        return String.valueOf(ch);
    }




}
