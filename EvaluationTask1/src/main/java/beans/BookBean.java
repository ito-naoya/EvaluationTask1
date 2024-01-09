package beans;

import java.util.Date;

public class BookBean {
	
	private String janCd;
	private String isbnCd;
	private String bookNm;
	private String bookKana;
	private Integer price;
	private Date issueDate;
	private Date createDatetime;
	private Date updateDatetime;
	
	public BookBean() {
		
	}

	public String getJanCd() {
		return janCd;
	}

	public void setJanCd(String janCd) {
		this.janCd = janCd;
	}

	public String getIsbnCd() {
		return isbnCd;
	}

	public void setIsbnCd(String isbnCd) {
		this.isbnCd = isbnCd;
	}

	public String getBookNm() {
		return bookNm;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	public String getBookKana() {
		return bookKana;
	}

	public void setBookKana(String bookKana) {
		this.bookKana = bookKana;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	

}
