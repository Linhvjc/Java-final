import static org.junit.Assert.*;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;
import org.testng.annotations.Test;

import java.util.Date;

public class addStudentToList {

    @Test
    public void testAddStudentToList() {
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        QLSVModel model = new QLSVModel();
        model.insert(student);
        assertNotNull(model.getDsThiSinh());
    }

    @Test
    public void testCompareStudent() {
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        QLSVModel model = new QLSVModel();
        model.insert(student);
        assertSame(student,model.getDsThiSinh().get(0));
    }
}
