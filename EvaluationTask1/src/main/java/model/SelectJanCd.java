package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DbConnection;
import dao.GeneralDao;

public class SelectJanCd {
	
public static int selectJanCd(String janCd) {
	
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(	"COUNT(JAN_CD = ? OR NULL) as COUNT_JAN_CD ");
		sb.append("FROM ");
		sb.append(	"BOOK");
		final String SELECT_JANCD_SQL = sb.toString();
		
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(janCd);
		
		int count = 0;
		
		try(Connection conn = DbConnection.getConnection()){
			try (ResultSet rs = GeneralDao.executeQuery(conn, SELECT_JANCD_SQL, params)){

				while(rs.next()) {
					
					count = rs.getInt("COUNT_JAN_CD");
				}
				
				if(count > 0) throw new SQLException();
				
			}catch(SQLException e) {
				if(!conn.isClosed()) {
					conn.rollback();
				}
				e.printStackTrace();
				return 1;
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return 1;
		}
		
		
		return count;
	}


}
