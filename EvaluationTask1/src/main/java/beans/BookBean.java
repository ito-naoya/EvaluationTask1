package beans;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import interfaces.GroupA;

public class BookBean {
	
	@Length(groups= {GroupA.class}, min=13, max=13, message="13桁で入力してください。")
	@Pattern(groups= {GroupA.class}, regexp="^[0-9]+$", message="半角数字で入力してください。")
	private String janCd;
	
	@Length(groups= {GroupA.class}, min=13, max=13, message="13桁で入力してください。")
	@Pattern(groups= {GroupA.class}, regexp="^[0-9]+$", message="半角数字で入力してください。")
	private String isbnCd;
	
	@Length(groups= {GroupA.class}, min=1, max=100, message="1文字以上100文字以内で入力してください。")
	@Pattern(groups= {GroupA.class}, regexp="^[^-~｡-ﾟ]*$", message="使用できる文字は、全角ひらがな、漢字、「ー」のみです。")
	private String bookNm;
	
	@Length(groups= {GroupA.class}, min=1, max=100, message="1文字以上100文字以内で入力してください。")
	@Pattern(groups= {GroupA.class}, regexp="^[ァ-ンヴー\\s　]*$", message="使用できる文字は、全角カタカナのみです。")
	private String bookKana;
	
	@Range(groups= {GroupA.class}, min=1, max=10000, message="1円以上10000円以下で入力してください。")
	private Integer price;
	
	@Past(groups= {GroupA.class}, message="無効な日付が入力されています。")
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
