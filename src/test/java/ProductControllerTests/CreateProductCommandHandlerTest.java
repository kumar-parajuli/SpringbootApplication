package ProductControllerTests;

import com.java.javaspringboot.Exception.ProductNotValidException;
import com.java.javaspringboot.JavaspringbootApplication;
import com.java.javaspringboot.Repository.ProductRepository;
import com.java.javaspringboot.commandhandlers.CreateProductCommandHandlers;
import com.java.javaspringboot.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = JavaspringbootApplication.class)
public class CreateProductCommandHandlerTest {
    @InjectMocks
    private CreateProductCommandHandlers createProductCommandHandlers;

    @Mock
    private ProductRepository productRepository;
    @Test
    public  void createProductCommandHandler_validProduct_returnsSuccess(){
        //Given
        //Arrange
        Product product = new Product();
        product.setId(1);
        product.setPrice( 999.99);
        product.setName("Laptop");
        product.setDescription("High-performance");
        product.setQuantity(10);
        //When
        //Act
        ResponseEntity response = createProductCommandHandlers.execute(product);
        //then
        //Assert
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
    @Test
    public void createProductCommandHandler_invalidPrice_throwsInvalidPriceException(){


        Product product = new Product();
        product.setId(1);
        product.setPrice( -999.99);
        product.setName("Laptop");
        product.setDescription("High-performance");
        product.setQuantity(10);
       ProductNotValidException  exception = assertThrows(ProductNotValidException.class, () -> createProductCommandHandlers.execute(product));
assertEquals("Product Price cannot ne negative",exception.getSimpleResponse().getMessage());
    }
}
