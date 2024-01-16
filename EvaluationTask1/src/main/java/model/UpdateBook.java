package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DbConnection;
import dao.GeneralDao;

public class UpdateBook {
	
	public static Boolean updateBook(String originJanCd, String isbnCd, String bookNm, String bookKana, Integer price, String issueDate, String janCd) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE "						);
		sb.append(	"BOOK "						);
		sb.append("SET "						);
		sb.append(	"JAN_CD = ?, "				);
		sb.append(	"ISBN_CD = ?, "				);
		sb.append(	"BOOK_NM = ?, "				);
		sb.append(	"BOOK_KANA = ?, "			);
		sb.append(	"PRICE = ?, "				);
		sb.append(	"ISSUE_DATE = ?, "			);
		sb.append(	"UPDATE_DATETIME = now() "	);
		sb.append("WHERE "						);
		sb.append(	"JAN_CD = ?"				);
		final String UPDATE_BOOK_INFO_SQL = sb.toString();
		
		ArrayList<Object> params = new ArrayList<>();
		params.add(janCd);
		params.add(isbnCd);
		params.add(bookNm);
		params.add(bookKana);
		params.add(price);
		params.add(issueDate);
		params.add(originJanCd);
		
		int updatedRows = 0;
		Boolean isCommit = false;
		
		try(Connection conn = DbConnection.getConnection()){
			try {
				
				 updatedRows = GeneralDao.executeUpdate(conn, UPDATE_BOOK_INFO_SQL, params);
				 
				 if(updatedRows == 0)throw new SQLException();
					 
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
