package src;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Query {
	private Bool bool;
	
	private Query(QueryBuilder queryBuilder){
		this.bool = queryBuilder.bool;
	} 

	public Bool getBool() {
		return bool;
	}

	public void setBool(Bool bool) {
		this.bool = bool;
	}
	
	public static class QueryBuilder{
		private Query query;
		private Bool bool;
		
		public Bool bool(){
			bool = new Bool();
			this.query = new Query(this);
			return bool;
		}

		public Query getQuery() {
			return query;
		}
		
		public String toJson() throws JsonProcessingException{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.setSerializationInclusion(Include.NON_NULL).writeValueAsString(this);
		}
		
		@Override
		public String toString() {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.setSerializationInclusion(Include.NON_NULL).writerWithDefaultPrettyPrinter().writeValueAsString(this);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return "";
			}
		}
	}
}
