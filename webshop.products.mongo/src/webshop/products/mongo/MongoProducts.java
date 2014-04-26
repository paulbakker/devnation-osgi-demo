package webshop.products.mongo;

import java.util.ArrayList;
import java.util.List;

import org.amdatu.mongo.MongoDBService;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.dm.annotation.api.Start;
import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;

import webshop.products.api.Product;
import webshop.products.api.ProductService;

import com.mongodb.DBCollection;

@Component
public class MongoProducts implements ProductService{

	@ServiceDependency
	private volatile MongoDBService mongoDbService;
	private volatile DBCollection collection;
	private volatile JacksonDBCollection<Product, String> products;
	
	@Start
	public void start() {
		collection = mongoDbService.getDB().getCollection("products");
		products = JacksonDBCollection.wrap(collection, Product.class, String.class);
	}
	
	@Override
	public List<Product> listProducts(String category) {

		DBCursor<Product> dbCursor = products.find().is("category", category);
		List<Product> result = new ArrayList<>();
		
		dbCursor.forEach(result::add);
		
		return result;
	}

}
