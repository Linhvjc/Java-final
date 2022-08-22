import static org.junit.Assert.*;

import model.QLSVModel;
import model.ThiSinh;
import org.testng.annotations.Test;

public class emptyList {

    @Test
    public void testEmptyList() {
        QLSVModel list = new QLSVModel();
        assertTrue(list.getDsThiSinh().isEmpty());
        ThiSinh student = new ThiSinh();
        list.insert(student);
        assertFalse(list.getDsThiSinh().isEmpty());
        list.delete(student);
        assertTrue(list.getDsThiSinh().isEmpty());
    }
}
