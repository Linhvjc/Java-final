import static org.junit.Assert.*;

import model.Province;
import org.testng.annotations.Test;

public class checkListTinh {

    @Test
    public void checkNumOfTinh() {
        Province list = new Province();
        assertEquals(63, list.getListProvince().size());
    }
}
