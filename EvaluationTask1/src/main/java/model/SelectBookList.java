package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BookBean;
import dao.DatabaseConnection;
import dao.GeneralDao;

public class SelectBookList {
	
	public static ArrayList<BookBean> selectBookList(){
		
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
		sb.append(	"BOOK");	
		final String SELECT_BOOK_LIST_SQL = sb.toString();
		
		ArrayList<BookBean> bookBeanList = new ArrayList<BookBean>();
		
		try(Connection conn = DatabaseConnection.getConnection();){
			try(ResultSet rs = GeneralDao.executeQuery(conn,SELECT_BOOK_LIST_SQL, new ArrayList<>())){
				
				while (rs.next()) {
					BookBean bb = new BookBean();
					bb.setJanCd(rs.getString("JAN_CD"));
					bb.setIsbnCd(rs.getString("ISBN_CD"));
					bb.setBookNm(rs.getString("BOOK_NM"));
					bb.setBookKana(rs.getString("BOOK_KANA"));
					bb.setPrice(rs.getInt("PRICE"));
					bb.setIssueDate(rs.getDate("ISSUE_DATE"));
					bb.setCreateDatetime(rs.getDate("CREATE_DATETIME"));
					bb.setUpdateDatetime(rs.getDate("UPDATE_DATETIME"));
					bookBeanList.add(bb);
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
		return bookBeanList;
	}

}
