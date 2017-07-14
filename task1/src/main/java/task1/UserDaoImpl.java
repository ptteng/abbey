package task1;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	

	public int insert() {
		int i = 0;
		String sql = " insert into stu values('3','4','5','6','1983-11-23','8','9','10','11','12','13','1983-11-23','1983-11-23'); ";

		try {
			conn = Conn.getConnection();		
			stmt = conn.createStatement();
			i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conn.release(rs, stmt, conn);
		}
		return i;

	}

	// ��ѯ������������
	public ArrayList<User> findAll() {

		ArrayList<User> list = new ArrayList<User>();
		try {
			// ������ݵ�����
			conn = Conn.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "SELECT * FROM stu";
			rs = stmt.executeQuery(sql);
			// ��������
			while (rs.next()) {
				User User = new User();

				User.setStu_id(rs.getInt("stu_id"));
				User.setQq(rs.getString("qq"));
				User.setName(rs.getString("name"));
				User.setType(rs.getString("type"));
				User.setSchool_day("school_day");
				User.setGra_university(rs.getString("gra_university"));
				User.setOnline_id(rs.getString("online_id"));
				User.setDay_report(rs.getString("day_report"));
				User.setWish(rs.getString("wish"));
				User.setRec_senior(rs.getString("rec_senior"));
				User.setCheck_senior(rs.getString("check_senior"));
				User.setCreate_at(rs.getString("create_at"));
				User.setUpdate_at(rs.getString("update_at"));
				list.add(User);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conn.release(rs, stmt, conn);
		}
		return null;
	}
}
