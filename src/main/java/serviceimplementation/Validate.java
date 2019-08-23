package serviceimplementation;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validate {
	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String PASSWORD_PATTERN ="^(?=.*[a-zA-Z])((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})";

	public Validate() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	public Boolean passwordValidation(final String password) {
		  matcher = pattern.matcher(password);
		  return matcher.matches();
	    	    
	}
   	public static String generatePassword()
   	{
   		int n=9;
   		String x;
		final Random RANDOM = new Random();
	    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    String digits="0123456789";
	    String splchar="@!#$%&*?";
		StringBuilder returnValue = new StringBuilder(n);
	    for (int i = 0; i < 4; i++) {
	        returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	    }
	    returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
	    returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
	    returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
	    returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
	    x=returnValue.toString();
		return x;
   	}
   
}
