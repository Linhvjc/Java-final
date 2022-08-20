package model;

import java.util.ArrayList;

public class QLSVModel {
    private ArrayList<ThiSinh> dsThiSinh;
    private String luaChon;
    private String tenFile;

    /**
     * Constructor
     */
    public QLSVModel() {
        this.dsThiSinh = new ArrayList<ThiSinh>();
        this.luaChon = "";
        this.tenFile ="";
    }

    public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
        this.dsThiSinh = dsThiSinh;
    }

    /**
     * Getter and Setter
     */
    public ArrayList<ThiSinh> getDsThiSinh() {
        return dsThiSinh;
    }

    public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
        this.dsThiSinh = dsThiSinh;
    }

    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    /**
     * Method
     */

    // Them thi sinh
    public void insert(ThiSinh thiSinh) {
        this.dsThiSinh.add(thiSinh);
    }

    // Xoa thi sinh
    public void delete(ThiSinh ts) {
        int index =-1;
        for(int i =0; i<this.dsThiSinh.size(); i++) {
            if(ts.getMaThiSinh() == this.dsThiSinh.get(i).getMaThiSinh()) {
                index = i;
            }
        }
        this.dsThiSinh.remove(index);
    }

    // Cap nhat thong tin thi sinh
    public void update(ThiSinh thiSinh) {
        this.dsThiSinh.remove(thiSinh);
        this.dsThiSinh.add(thiSinh);
    }

    // Kiem tra Thí sinh đã tồn tại chưa
    public boolean kiemtraTonTai(ThiSinh ts) {
        for (ThiSinh thiSinh : dsThiSinh) {
            if(thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
                return true;
            }
        }
        return false;
    }

//    public boolean kiemtraIdTonTai(ThiSinh ts) {
//        for (ThiSinh thiSinh : dsThiSinh) {
//            if(thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
//                return true;
//            }
//        }
//        return false;
//    }
}
