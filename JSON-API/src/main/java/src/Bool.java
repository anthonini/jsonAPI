package src;

import java.util.ArrayList;
import java.util.List;

public class Bool {
	
	/** Must clause */
	private List<Match> must;
	
	/** Should clause */
	private List<Match> should;
	
	/** Actual Match clause */
	private Match actualMatch;
	
	public Bool mustMatch(String key, Object value){
		if(must == null)
			must = new ArrayList<Match>();
		actualMatch = new Match(key, value); 
		must.add(actualMatch);
		return this;
	}
	
	public Bool shouldMatch(String key, Object value){
		if(should == null)
			should = new ArrayList<Match>();
		Match actualMatch = new Match(key, value);
		should.add(actualMatch);
		return this;
	}
	
	public Bool bool(){
		if(actualMatch == null)
			throw new RuntimeException("Cannot create nested bool");
		else
			return actualMatch.bool();
	}
	
	public List<Match> getMust() {
		return must;
	}

	public List<Match> getShould() {
		return should;
	}
}
