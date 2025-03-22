package Tut8.Problem1;
import java.util.*;
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
class WordLengthException extends Exception {
    public WordLengthException(String message) {
        super(message);
    }
}
class LetterOccurrence{
    private String word;
    private HashMap<String, Integer> letterCount;
    public LetterOccurrence(String word)  throws InvalidInputException, WordLengthException {
        validate(word);
        this.word = word;
        this.letterCount = new HashMap<>();
        countLetter();
    }
    public void validate(String word) throws InvalidInputException, WordLengthException {
        if(word==null||word.length()==0 || word.isEmpty()){
            throw new InvalidInputException("InvalidInputException: Word should not be empty, it should contain only letters!");
        }
        if(!word.matches("[a-zA-Z]+")){
            throw new InvalidInputException("InvalidInputException: Word should not be empty, it should contain only letters!");
        }
        if(word.length() <= 0 || word.length() > 45 ){
            throw new InvalidInputException("WordLengthException: Word length should be between 1 and 45 characters.");
        }
    }
    public void countLetter() throws InvalidInputException, WordLengthException {
        for (char c : word.toCharArray()) {
            String key = String.valueOf(c);
            if (letterCount.containsKey(key)) {
                letterCount.put(key, letterCount.get(key) + 1);
            } else {
                letterCount.put(key, 1);
            }
        }
    }
    public HashMap<String, Integer> getLetterOccurrence(){
        return letterCount;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("LetterOccurrence[{word=" + word + "} contains ");
        letterCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER))
                .forEach(entry -> result.append(entry.getKey()).append(": ").append(entry.getValue()).append(", "));
        if (!letterCount.isEmpty()) {
            result.setLength(result.length() - 2); // Remove last comma and space
        }
        result.append("]");
        return result.toString();

    }
}

public class maintest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter a word: ");
            String word = sc.nextLine();
            LetterOccurrence lo = new LetterOccurrence(word);
            HashMap<String, Integer> occurence = lo.getLetterOccurrence();
            System.out.println(lo.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
