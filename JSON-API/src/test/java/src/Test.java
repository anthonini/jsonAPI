package src;

import com.fasterxml.jackson.core.JsonProcessingException;

import src.Query.QueryBuilder;

public class Test {
	public static void main(String[] args) throws JsonProcessingException {
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.bool()
			.mustMatch("item", "Milk")
			.shouldMatch("product_location", "New Mexico")
			.mustMatch("item_type", "Dairy")
			.bool()
				.shouldMatch("warehouse_number",37);
		
		System.out.println(queryBuilder);
	}
}
