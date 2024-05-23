package context.beans;

import context.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private List<Product> items = new ArrayList<>();

//    ----Field injection----
//    @Autowired
    private ProductRepository productRepository;

//    ----Constructor injection----
//    public Cart(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

//    ----Setter injection----
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addItem(int id) {
        items.add(productRepository.getProduct(id));
    }

    public void removeItem(int id) {
        items.remove(productRepository.getProduct(id));
    }

    public void showContent() {
        System.out.println("\n==Cart contents==");
        items.forEach(System.out::println);
        System.out.println("=================");
    }

}
