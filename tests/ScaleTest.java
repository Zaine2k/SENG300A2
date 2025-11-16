import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScaleTest {

    private Scale scale;

    @BeforeEach
    void setup() {
        scale = new Scale();
    }

    @Test
    void setWeightForTest_updatesMeasuredWeight() {
        scale.setWeightForTest(5.0);
        assertEquals(5.0, scale.measureWeight());
    }

    @Test
    void setWeightForTest_allowsZeroAndNegativeValues() {
        scale.setWeightForTest(0.0);
        assertEquals(0.0, scale.measureWeight());

        scale.setWeightForTest(-2.5);
        assertEquals(-2.5, scale.measureWeight());
    }
}
