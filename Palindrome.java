import java.util.Stack;
/**
 * Using a stack to determine whether a given string is a palindrome.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Palindrome
{
    // Attributes
    private Stack <Character> testString;
    private boolean isPalindrome;
    
    /**
     * Palindrome: default constructor, testString is the empty String, which is a palindrome.
     * @param none
     */
    public Palindrome()
    {
        testString = new Stack<Character>();
        isPalindrome = true;
    }

    /**
     * Palindrome: overloaded constructor with one parameter.
     * @param String testStr, the String to test whether or not it is a palindrome.
     */
    public Palindrome(String testStr)
    {
        testString = new Stack<Character>();
        for(int i = 0; i < testStr.length(); i++)
        {
           Character c = testStr.charAt(i);
           if (c==null) 
           {
               System.out.println("c null");
           }
           if (testString==null) {
               System.out.println("stack null");
           }
           testString.push(c); 
        }
        isPalindrome = false;
    }

    /**
     * checkPalindrome: check whether or not the attribute testString is a palindrome.
     * @param None
     * @return true if testString is a palindrome, false otherwise.
     */
    public boolean checkPalindrome()
    {
        StackReferenceBased s1 = new StackReferenceBased();
        String testStringBackwards = "";
        
        // Put characters of testString on stack s1, one at a time, left to right.
        int strLen = testString.size();
        for (int i = 0; i < strLen; i++) {
            s1.push(testString.pop());
        }
        
        // Take characters from stack s1, one at a time, and append to testStringBackwards
        while (!s1.isEmpty()) {
            Character c1 = (Character)s1.pop();
            testStringBackwards += c1; 
        }
        
        // Invariant: testStringBackwards has the characters of testString, in reverse order.
        
        // If testString and testStringBackwards are equal, then testString is a palindrome; otherwise it is not.
        
        return testString.equals(testStringBackwards);
    }

    /**
     * test: test checkPalindrome method on various Strings.
     */
    public static void test()
    {
            String testStr1 = "abba"; // palindrome
            String testStr2 = "abc";  // not a palindrome
            String testStr3 = "a";    // one character: palindrome
            String testStr4 = "";     // no characters: palindrome
        
            Palindrome p1 = new Palindrome(testStr1);
            Palindrome p2 = new Palindrome(testStr2);
            Palindrome p3 = new Palindrome(testStr3);
            Palindrome p4 = new Palindrome(testStr4);
            
            if (p1.checkPalindrome())
                System.out.println(testStr1 + " is a palindrome");
            else System.out.println(testStr1 + " is not a palindrome");
            System.out.println("That should have printed that " + testStr1 + " is a palindrome\n");
            
            if (p2.checkPalindrome())
                System.out.println(testStr2 + " is a palindrome");
            else System.out.println(testStr2 + " is not a palindrome");
            System.out.println("That should have printed that " + testStr2 + " is not a palindrome\n");
            
            if (p3.checkPalindrome())
                System.out.println(testStr3 + " is a palindrome");
            else System.out.println(testStr3 + " is not a palindrome");
            System.out.println("That should have printed that " + testStr3 + " is a palindrome\n");
            
            if (p4.checkPalindrome())
                System.out.println(testStr4 + " is a palindrome");
            else System.out.println(testStr4 + " is not a palindrome");
            System.out.println("That should have printed that " + testStr4 + " is a palindrome\n");
    }
}
