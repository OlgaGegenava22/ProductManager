import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product1 = new Book(1, "Дубровский", 200, "А.С.Пушкин");
    Product product2 = new Book(333, "Идиот", 250, "Ф.М. Достоевский");
    Product product3 = new Smartphone(15, "Iphone 12", 50_000, "Apple");
    Product product4 = new Smartphone(444, "Xiaomi Redmi 10", 27_000, "Xiaomi");

    @Test
    public void shouldSaveProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductsById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(product3.getId());

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
