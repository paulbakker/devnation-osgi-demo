package webshop.products.api.test;

import java.util.List;
import java.util.Properties;

import org.amdatu.bndtools.test.BaseOSGiServiceTest;

import webshop.products.api.*;

public class ProductServiceTest extends BaseOSGiServiceTest<ProductService>{

	public ProductServiceTest() {
		super(ProductService.class);
	}
	
	@Override
	public void setUp() throws Exception {
		
		Properties props = new Properties();
		props.put("dbName", "osgiwebshop");
		
		configureFactory( "org.amdatu.mongo", props);
		
		super.setUp();
	}
	
	public void test() {
		List<Product> listProducts = instance.listProducts("Books");
		assertEquals(3, listProducts.size());
	}
}