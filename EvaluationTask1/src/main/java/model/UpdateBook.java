package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DatabaseConnection;
import dao.GeneralDao;

public class UpdateBook {
	
	public static void updateBook(String updateJanCd, String isbnCd, String bookNm, String bookKana, Integer price, String issueDate, String janCd) {
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
		params.add(updateJanCd);
		params.add(isbnCd);
		params.add(bookNm);
		params.add(bookKana);
		params.add(price);
		params.add(issueDate);
		params.add(janCd);
		
		try(Connection conn = DatabaseConnection.getConnection()){
			try {
				
				 GeneralDao.executeUpdate(conn, UPDATE_BOOK_INFO_SQL, params);
				 conn.commit();
			}catch(SQLException e) {
				if(!conn.isClosed()) {
					conn.rollback();
				}
				e.printStackTrace();
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	

}
