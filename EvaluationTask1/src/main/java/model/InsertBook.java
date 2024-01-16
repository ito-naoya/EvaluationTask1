package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DbConnection;
import dao.GeneralDao;

public class InsertBook {
	
	public static Boolean insertBook(String janCd, String isbnCd, String bookNm, String bookKana, Integer price, String issueDate) {
		
	
	StringBuilder sb = new StringBuilder();
	sb.append("INSERT INTO ");
	sb.append("BOOK ");
	sb.append(	"(");
	sb.append(		"JAN_CD, ");
	sb.append(		"ISBN_CD, ");
	sb.append(		"BOOK_NM, ");
	sb.append(		"BOOK_KANA, ");
	sb.append(		"PRICE, ");
	sb.append(		"ISSUE_DATE, ");
	sb.append(		"CREATE_DATETIME");
	sb.append(	")");
	sb.append("VALUES");
	sb.append(	"(");
	sb.append(		"?, ");
	sb.append(		"?, ");
	sb.append(		"?, ");
	sb.append(		"?, ");
	sb.append(		"?, ");
	sb.append(		"?, ");
	sb.append(		"now()");
	sb.append(	")");

	final String INSERT_BOOK_SQL = sb.toString();
	
	ArrayList<Object> params = new ArrayList<Object>();
	params.add(janCd);
	params.add(isbnCd);
	params.add(bookNm);
	params.add(bookKana);
	params.add(price);
	params.add(issueDate);
	
	Boolean isCommit = false;
	
	try(Connection conn = DbConnection.getConnection()){
		try {
			
			int updatedRows = GeneralDao.executeUpdate(conn, INSERT_BOOK_SQL, params);
			
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
