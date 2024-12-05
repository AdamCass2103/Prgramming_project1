package Question_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Scanner;

public class HTMLTagValidator {

    //refernce for the HTML Tag Matching Logic GeeksforGeeks. (n.d.). Check for balanced parentheses in an expression. Retrieved from GeeksforGeeks

    public static boolean isProperlyNested(String filePath) {
        Stack<String> stack = new Stack<>();
        String selfClosingTag = "<br>";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String tag = scanner.next();

                if (tag.equals(selfClosingTag)) {
                    continue; // Ignore self-closing tag <br>
                } else if (tag.startsWith("</")) {
                    // Handle closing tag
                    if (stack.isEmpty()) {
                        return false; // No opening tag to match
                    }
                    String openingTag = stack.pop();
                    if (!tag.equals("</" + openingTag.substring(1))) {
                        return false; // Mismatched tags
                    }
                } else {
                    // Handle opening tag
                    stack.push(tag);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return false;
        }

        return stack.isEmpty(); // True if all tags are matched
    }

    public static void main(String[] args) {
        String filePath = "Question_3/tags"; // Specify your file path here
        if (isProperlyNested(filePath)) {
            System.out.println("The tags are properly nested.");
        } else {
            System.out.println("The tags are not properly nested.");
        }
    }
}