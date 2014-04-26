package webshop.products.rest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;

import webshop.products.api.Product;
import webshop.products.api.ProductService;

@Path("products")
@Component(provides=Object.class)
public class ProductResource {
	
	@ServiceDependency(required=false)
	private volatile ProductService productService;
	
	@Path("categories")
	@GET
	public List<String> categories() {
		return Arrays.asList("Books", "Games");
	}
	
	@Path("{category}")
	@GET
	public List<Product> products(@PathParam("category") String categories) {
		return productService.listProducts(categories);
	}
}
