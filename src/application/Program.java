package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement(
					"DELETE FROM seller "
					+ "WHERE "
					+ "Id = ?");
			
			ps.setInt(1, 8);
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println("DONE! ROWS AFFECTED: " + rowsAffected);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
	}
}
