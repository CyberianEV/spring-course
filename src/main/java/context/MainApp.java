package context;

import context.beans.Cart;
import context.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext("context.beans");
                new AnnotationConfigApplicationContext(JavaConfig.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Cart firstCart = context.getBean(Cart.class);
        firstCart.addItem(1);
        firstCart.addItem(2);
        firstCart.addItem(3);
        firstCart.showContent();

        Cart secondCart = context.getBean(Cart.class);
        secondCart.showContent();
        secondCart.addItem(4);
        secondCart.addItem(5);

        secondCart.showContent();
        firstCart.showContent();

        secondCart.removeItem(5);
        secondCart.showContent();
        firstCart.showContent();

        Cart thirdCart = context.getBean(Cart.class);
        thirdCart.addItem(5);

        firstCart.showContent();
        secondCart.showContent();
        thirdCart.showContent();
    }
}
