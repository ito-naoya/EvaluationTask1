package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DbConnection;
import dao.GeneralDao;

public class DeleteBook {
	
	public static Boolean deleteBook(String janCd) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE "					);
		sb.append("FROM "					);
		sb.append(	"BOOK "					);
		sb.append("WHERE "					);
		sb.append(	"JAN_CD = ?"			);
		final String DELETE_BOOK_LIST_SQL = sb.toString();
		
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(janCd);
		
		Boolean isCommit = false;
		
		try(Connection conn = DbConnection.getConnection()){
			try{
				
				int updatedRows = GeneralDao.executeUpdate(conn, DELETE_BOOK_LIST_SQL, params);
				
				if(updatedRows == 0) throw new SQLException();
				
				conn.commit();
				isCommit = true;
				
			}catch(SQLException e) {
				if(!conn.isClosed()) {
					conn.rollback();
				}
				e.printStackTrace();
				return false;
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return isCommit;
	}

}
