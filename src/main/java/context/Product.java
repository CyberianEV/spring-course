package context;

import lombok.Data;

@Data
public class Product {
    private static int productCounter = 1;

    private int id;
    private String title;
    private float cost;

    public Product(String title, float cost) {
        id = productCounter++;
        this.title = title;
        this.cost = cost;
    }
}
