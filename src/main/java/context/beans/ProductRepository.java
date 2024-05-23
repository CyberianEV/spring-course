package context.beans;

import context.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("Milk", 1.05F));
        products.add(new Product("Bread", 1.45F));
        products.add(new Product("Cheese", 2.15F));
        products.add(new Product("Eggs", 0.95F));
        products.add(new Product("Chicken", 5.65F));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        Product wantedProduct = products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return wantedProduct;
    }
}
