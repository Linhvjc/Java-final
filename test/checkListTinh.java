import static org.junit.Assert.*;

import model.Tinh;
import org.testng.annotations.Test;

public class checkListTinh {

    @Test
    public void checkNumOfTinh() {
        Tinh list = new Tinh();
        assertEquals(63, list.getDSTinh().size());
    }
}
