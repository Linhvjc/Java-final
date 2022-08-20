import model.ThiSinh;
import model.Tinh;

import static org.junit.Assert.*;
import org.testng.annotations.Test;

import java.util.Date;

public class createStudent {

    @Test
    public void testIdStudent() {
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals(1,student.getMaThiSinh());
    }

    @Test
    public void testNameStudent() {
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals("Linh",student.getTenThiSinh());
    }

    @Test
    public void testNameTinh() {
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals(Tinh.getTinhById(2),student.getQueQuan());
    }

    @Test
    public void testDob() {
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals(new Date("3/17/2002"),student.getNgaySinh());
    }
}
