package src;

import java.util.HashMap;
import java.util.Map;

public class Match {
	
	/** MAP with all key and values that will match with a sentence */
	private Map<String,Object> match;
	
	/** Nested Bool of the Match */
	private Bool bool;

	public Match(String key, Object value){
		match = new HashMap<String, Object>();
		match.put(key, value);
	}
	
	public Bool bool(){
		bool = new Bool();
		return bool;
	}
	
	public Map<String, Object> getMatch() {
		return match;
	}

	public Bool getBool() {
		return bool;
	}
}
