package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BookBean;
import dao.DatabaseConnection;
import dao.GeneralDao;

public class SelectBook {
	
	public static BookBean selectBook(String janCd){
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");	
		sb.append(	"JAN_CD, ");	
		sb.append(	"ISBN_CD, ");	
		sb.append(	"BOOK_NM, ");	
		sb.append(	"BOOK_KANA, ");	
		sb.append(	"PRICE, ");	
		sb.append(	"ISSUE_DATE, ");	
		sb.append(	"CREATE_DATETIME, ");	
		sb.append(	"UPDATE_DATETIME ");	
		sb.append("FROM ");	
		sb.append(	"BOOK ");	
		sb.append("WHERE ");	
		sb.append(	"JAN_CD = ?");	
		final String SELECT_BOOK_LIST_SQL = sb.toString();
		
		BookBean bb = null;
		ArrayList<Object> params = new ArrayList<>();
		params.add(janCd);
		
		try(Connection conn = DatabaseConnection.getConnection();){
			try(ResultSet rs = GeneralDao.executeQuery(conn,SELECT_BOOK_LIST_SQL, params)){
				
				
				while (rs.next()) {
					bb = new BookBean();
					bb.setJanCd(rs.getString("JAN_CD"));
					bb.setIsbnCd(rs.getString("ISBN_CD"));
					bb.setBookNm(rs.getString("BOOK_NM"));
					bb.setBookKana(rs.getString("BOOK_KANA"));
					bb.setPrice(rs.getInt("PRICE"));
					bb.setIssueDate(rs.getDate("ISSUE_DATE"));
					bb.setCreateDatetime(rs.getDate("CREATE_DATETIME"));
					bb.setUpdateDatetime(rs.getDate("UPDATE_DATETIME"));
				}
				
			}catch(SQLException e) {
				if(!conn.isClosed()) {
					conn.rollback();
				}
				e.printStackTrace();
				return null;
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return bb;
	}

}
