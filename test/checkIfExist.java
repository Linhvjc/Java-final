import static org.junit.Assert.*;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;
import org.testng.annotations.Test;

import java.util.Date;

public class checkIfExist {
    @Test
    public void checkIfExist() {
        ThiSinh student1 = new ThiSinh(1,"Linh1", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        ThiSinh student2 = new ThiSinh(2,"Linh2", Tinh.getTinhById(3)
                ,new Date("3/17/2002"),false,1,2,3);
        ThiSinh student3 = new ThiSinh(3,"Linh3", Tinh.getTinhById(4)
                ,new Date("3/17/2002"),true,1,2,3);
        QLSVModel model = new QLSVModel();
        model.insert(student1);
        model.insert(student2);
        model.insert(student3);

        assertTrue(model.kiemtraTonTai(student2));
    }
}
