import static org.junit.Assert.*;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;
import org.testng.annotations.Test;
import view.QLSVView;

import java.util.Date;

public class updateStudentFromList {

    @Test
    public void testUpdateStudent() {
        QLSVModel list = new QLSVModel();
        ThiSinh student = new ThiSinh(1,"Linh", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        list.insert(student);
        // Lưu lại thí sinh trước khi update
        ThiSinh temp = list.getDsThiSinh().get(0);

        ThiSinh studentUpdated = new ThiSinh(1,"Linh2", Tinh.getTinhById(2)
                ,new Date("3/17/2002"),true,1,2,3);

        // Lấy index của thí sinh cần xóa
        int index =-1;
        for(int i =0; i<list.getDsThiSinh().size(); i++) {
            if(student.getMaThiSinh() == list.getDsThiSinh().get(i).getMaThiSinh()) {
                index = i;
            }
        }

        list.update(studentUpdated,index);
        // Lưu lại thí sinh sau khi update
        ThiSinh tempUpdate = list.getDsThiSinh().get(0);

        assertNotEquals(temp, tempUpdate);
    }
}
