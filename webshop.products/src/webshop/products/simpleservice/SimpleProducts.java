package webshop.products.simpleservice;

import java.util.Arrays;
import java.util.List;

import org.apache.felix.dm.annotation.api.Component;

import webshop.products.api.Product;
import webshop.products.api.ProductService;

@Component
public class SimpleProducts implements ProductService {

	@Override
	public List<Product> listProducts(String category) {

		return Arrays.asList(new Product("Example 2", 10, "Games"));
	}

}
