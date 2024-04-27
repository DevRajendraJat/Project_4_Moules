package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.ProgressBean;

public class ProgressModel {

	public int nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAWAN", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM PROGRESS");
		int pk = 0;

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}

		return pk + 1;

	}

	// uday
	public long add(ProgressBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sawan", "root", "root");
		PreparedStatement ps = conn.prepareStatement("INSERT INTO PROGRESS VALUES(?,?,?,?,?,?,?)");
		int pk = nextPK();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setId(1);
		ps.setInt(1, pk);
		ps.setString(2, bean.getDeveloperName());
		ps.setString(3, bean.getWork());
		ps.setString(4, bean.getTarget());
		ps.setString(5, bean.getLastWeek());
		ps.setString(6, bean.getCurrentWeek());
		ps.setDate(7, new java.sql.Date(bean.getToday().getTime()));

		int i = ps.executeUpdate();
		System.out.println("add" + i);

		return pk;

	}

	public void update(ProgressBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAWAN", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"UPDATE PROGRESS SET   DEVELOPERNAME =?,WORK=?,TARGET=?,LASTWEEK=?,CURRENTWeek=?,TODAY=? WHERE ID =?");

		ps.setString(1, bean.getDeveloperName());
		ps.setString(2, bean.getWork());
		ps.setString(3, bean.getTarget());
		ps.setString(4, bean.getLastWeek());
		ps.setString(5, bean.getCurrentWeek());
		ps.setDate(6, new java.sql.Date(bean.getToday().getTime()));
		ps.setInt(7, bean.getId());
		int i = ps.executeUpdate();
		
		
		System.out.println("data update =" + i);

	}

	public List serach(ProgressBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAWAN", "root", "root");

		StringBuffer sb = new StringBuffer("SELECT * FROM PROGRESS WHERE 1=1");

		if (bean != null) {
			
			if (bean.getDeveloperName() != null && bean.getDeveloperName().length() > 0) {
				sb.append(" AND DeveloperName like '" + bean.getDeveloperName() + "%' ");
			}

		}
		PreparedStatement ps = conn.prepareStatement(sb.toString());

		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			bean = new ProgressBean();
			bean.setId(rs.getInt(1));
			bean.setDeveloperName(rs.getString(2));
			bean.setWork(rs.getString(3));
			bean.setTarget(rs.getString(4));
			bean.setLastWeek(rs.getString(5));
			bean.setCurrentWeek(rs.getString(6));
			bean.setToday(rs.getDate(7));

			list.add(bean);

		}

		return list;

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAWAN", "root", "root");

		PreparedStatement ps = conn.prepareStatement("DELETE FROM PROGRESs WHERE id  = ?");

		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("data delete =" + i);
	}

	public ProgressBean findbypk(long pk) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAWAN", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROGRESS WHERE ID =?");
		ps.setLong(1, pk);
		ProgressBean bean = null;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bean = new ProgressBean();
			bean.setId(rs.getInt(1));
			bean.setDeveloperName(rs.getString(2));
			bean.setWork(rs.getString(3));
			bean.setTarget(rs.getString(4));
			bean.setLastWeek(rs.getString(5));
			bean.setCurrentWeek(rs.getString(6));
			bean.setToday(rs.getDate(7));

		}
		return bean;

	}

}
