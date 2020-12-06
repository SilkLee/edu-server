import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://139.196.44.66:3306/edu?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("insert into video(title, summary, cover_img, price, create_time, point) values(?, ?, ?, ?, ?, ?)");
        for (int i = 0; i < 100; i++) {
            pstmt.setString(1, "springboot2");
            pstmt.setString(2, "高级课程");
            pstmt.setString(3, "http://");
            pstmt.setInt(4, 28);
            pstmt.setDate(5, new java.sql.Date(2020-11-18));
            pstmt.setDouble(6, 8.9);
        }
        pstmt.executeBatch();
    }
}
