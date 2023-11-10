import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemovingExistProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "часы", 20_000);
        Product product2 = new Product(22, "журнал", 100);
        Product product3 = new Product(300, "автомобиль", 4_500_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemovingNotExistProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "часы", 20_000);
        Product product2 = new Product(22, "журнал", 100);
        Product product3 = new Product(300, "автомобиль", 4_500_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4444444)
        );

    }

}