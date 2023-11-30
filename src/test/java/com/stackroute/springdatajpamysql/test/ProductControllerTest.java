package com.stackroute.springdatajpamysql.test;

import com.stackroute.springdatajpamysql.controller.ProductController;
import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        when(productService.getAllProducts()).thenReturn(someListOfProducts());

        ResponseEntity<?> response = productController.getAllProducts();

        verify(productService, times(1)).getAllProducts();
        assertThat(response.getBody(), samePropertyValuesAs(someListOfProducts()));
    }

    @Test
    public void testGetProductById() {
        int productId = 1;
        Product expectedProduct = new Product(productId, "Sample Product", 9.99);
        when(productService.getProductById(productId)).thenReturn(expectedProduct);

        ResponseEntity<?> response = productController.getProductById(productId);

        verify(productService, times(1)).getProductById(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Use Hamcrest's samePropertyValuesAs to compare objects
        assertThat(response.getBody(), samePropertyValuesAs(expectedProduct));
    }

    @Test
    public void testSaveProduct() {
        Product product = someProduct();
        when(productService.saveProduct(product)).thenReturn(product);

        ResponseEntity<?> response = productController.saveProduct(product);

        verify(productService, times(1)).saveProduct(product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct() {
               Product updatedProduct = someProduct();
        when(productService.updateProduct(updatedProduct)).thenReturn(updatedProduct);

        ResponseEntity<?> response = productController.updateProduct(updatedProduct);

        verify(productService, times(1)).updateProduct(updatedProduct);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
    }

   /* @Test
    public void testDeleteProduct() {
        int productId = 1;
        when(productService.deleteProduct(productId)).thenReturn("Product Deleted");

        ResponseEntity<?> response = productController.deleteProduct(productId);

        verify(productService, times(1)).deleteProduct(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product Deleted", response.getBody());
    }*/

    @Test
    public void testGetAllProductsHavingPriceLessThan() {
        // Mocking data
        double price = 100.0;
        Product product1 = new Product(1, "product", price);
        Product product2 = new Product(2, "Product2", 110.0);
        List<Product> productList = Arrays.asList(product1, product2);

        // Mocking the service method
        when(productService.getAllProductsHavingPriceLessThan(price)).thenReturn(productList);

        // Calling the controller method
        ResponseEntity<?> responseEntity = productController.getAllProductsHavingPriceLessThan(price);

        // Verifying the response status
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verifying the response body
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof List);
        List<Product> result = (List<Product>) responseEntity.getBody();
        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getProductName());
        assertEquals(90.0, result.get(0).getProductPrice());
        assertEquals("Product2", result.get(1).getProductName());
        assertEquals(110.0, result.get(1).getProductPrice());

        // Verifying that the service method was called
        verify(productService, times(1)).getAllProductsHavingPriceLessThan(price);
    }

    private Product someProduct() {
        return new Product(1, "Sample Product", 9.99);
    }

    private List<Product> someListOfProducts() {
        List<Product> products = new ArrayList<>();
        products.add(someProduct());
        // Add more sample products as needed
        return products;
    }
}

