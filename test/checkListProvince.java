import static org.junit.Assert.*;

import model.Province;
import org.testng.annotations.Test;

public class checkListProvince {

    @Test
    public void checkNumOfProvince() {
        Province list = new Province();
        assertEquals(63, list.getListProvince().size());
    }
}
