import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;
import org.testng.annotations.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class deleteStudentFromList {
    @Test
    public void testDeleteStudentFromList() {
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        QLSVModel model = new QLSVModel();
        model.insert(student);
        assertEquals(model.getDsThiSinh().size(), 1);
        model.delete(student);
        assertEquals(model.getDsThiSinh().size(), 0);
    }
}
