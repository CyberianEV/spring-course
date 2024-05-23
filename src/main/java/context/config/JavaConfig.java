package context.config;

import context.beans.Cart;
import context.beans.ProductRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Cart cart(ProductRepository productRepository) {

//        ---for constructor injection---
//        return new Cart(productRepository());

//        ---for setter injection---
        Cart cart = new Cart();
        cart.setProductRepository(productRepository);
        return cart;
    }
}
