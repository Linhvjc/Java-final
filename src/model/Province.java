package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Province implements Serializable {
    private int provinceID;
    private String provinceName;

    /**
     * Constructor
     */
    public Province() {
    }

    public Province(int provinceID, String provinceName) {
        this.provinceID = provinceID;
        this.provinceName = provinceName;
    }

    /**
     * Getter and Setter
     */
    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * Method
     */
    @Override
    public String toString() {
        return "Tinh [maTinh=" + provinceID + ", tenTinh=" + provinceName + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceID, provinceName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Province other = (Province) obj;
        return provinceID == other.provinceID && Objects.equals(provinceName, other.provinceName);
    }

    // Mang tinh thanh
    public static ArrayList<Province> getListProvince() {
        String[] arr_tinh = { "An Giang",
                "Bà Rịa – Vũng Tàu",
                "Bạc Liêu",
                "Bắc Giang",
                "Bắc Kạn",
                "Bắc Ninh",
                "Bến Tre",
                "Bình Dương",
                "Bình Định",
                "Bình Phước",
                "Bình Thuận",
                "Cà Mau",
                "Cao Bằng",
                "Cần Thơ",
                "Đà Nẵng",
                "Đắk Lắk",
                "Đắk Nông",
                "Điện Biên",
                "Đồng Nai",
                "Đồng Tháp",
                "Gia Lai",
                "Hà Giang",
                "Hà Nam",
                "Hà Nội",
                "Hà Tĩnh",
                "Hải Dương",
                "Hải Phòng",
                "Hậu Giang",
                "Hòa Bình",
                "Thành phố Hồ Chí Minh",
                "Hưng Yên",
                "Khánh Hòa",
                "Kiên Giang",
                "Kon Tum",
                "Lai Châu",
                "Lạng Sơn",
                "Lào Cai",
                "Lâm Đồng",
                "Long An",
                "Nam Định",
                "Nghệ An",
                "Ninh Bình",
                "Ninh Thuận",
                "Phú Thọ",
                "Phú Yên",
                "Quảng Bình",
                "Quảng Nam",
                "Quảng Ngãi",
                "Quảng Ninh",
                "Quảng Trị",
                "Sóc Trăng",
                "Sơn La",
                "Tây Ninh",
                "Thái Bình",
                "Thái Nguyên",
                "Thanh Hóa",
                "Thừa Thiên Huế",
                "Tiền Giang",
                "Trà Vinh",
                "Tuyên Quang",
                "Vĩnh Long",
                "Vĩnh Phúc",
                "Yên Bái",};

        ArrayList<Province> listProvince = new ArrayList<Province>();
        int i =0;
//        Tạo ra lần lượt đối tượng tỉnh
        for(String name : arr_tinh) {
            Province t = new Province(i, name);
            listProvince.add(t);
        }
        return listProvince;
    }

    public static Province getProvinceById(int homeTown) {
        return Province.getListProvince().get(homeTown);
    }

    public static Province getProvinceByName(String provinceName) {
        ArrayList<Province> listProvince = Province.getListProvince();
        for (Province province : listProvince) {
            if(province.provinceName.equals(provinceName)) {
                return province;
            }
        }
        return null;
    }
}
