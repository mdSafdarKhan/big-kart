import com.example.productservice.model.LombokDemo;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LombokDemoTest {

    @Test
    public void testLombokDemo() {
        LombokDemo lombokDemo = new LombokDemo();
        lombokDemo.setAddress("My Address");
        Assertions.assertThat(lombokDemo.getAddress()).isEqualTo("My Address");
    }

    @Test
    public void testLombokDemoToString() {
        LombokDemo lombokDemo = new LombokDemo();
        lombokDemo.setAddress("My Address");
        Assertions.assertThat(lombokDemo.toString()).isEqualTo("LombokDemo(age=0, name=null, address=My Address)");
    }

    @Test
    public void testLombokDemoBuilder() {
        LombokDemo lombokDemo = LombokDemo.builder()
                .address("My Address")
                .name("My Name")
                .build();
        lombokDemo.setAddress("My Address");
        Assertions.assertThat(lombokDemo.toString()).isEqualTo("LombokDemo(age=0, name=My Name, address=My Address)");
    }
}
