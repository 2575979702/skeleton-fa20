import java.util.Locale;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /** A palindrome is defined as a word that is the same whether it is read forwards or backwards */
    public boolean isPalindrome(String word){
        // 'A' and 'a' shouldn't be considered equal.
        StringBuffer str = new StringBuffer();
        for(int i=0;i<word.length();i++){
            str.append(word.charAt(i));
        }
        return str.reverse().toString().equals(word);
    }

    /**  */
}
