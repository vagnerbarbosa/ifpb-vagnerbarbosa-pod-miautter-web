package servlet.app;

import java.util.Arrays;
import java.util.List;

public class Repository {
	private static int lastIndex = -1;
	private final static String[] messages = new String[10000];
	
	public void store(String message){
		messages[++lastIndex] = message;
	}
	
	public List<String> list(int offset){
		String[] result = Arrays.copyOfRange(messages, offset, offset + 10);
		return Arrays.asList(result);
	}
	
	public int getLatestIndex(){
		if (lastIndex <= 9){
			return 0;
		}
		else {
			return lastIndex - 9;
		}
	}
	
}