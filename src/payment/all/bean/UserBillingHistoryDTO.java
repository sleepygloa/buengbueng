package payment.all.bean;
import java.sql.Timestamp;

public class UserBillingHistoryDTO {
	
	private int idx;
	private Timestamp payment_date;
	private String payment_type;
	private String paying_name;
	private int paying_price;
	private String confirmation;
	private String error_msg;
	private String buyer_chatid;
	private String pg_name;
	private String imp_uid;
	private String merchant_uid;
	private String pg_tid;
	
	
	public String getPg_tid() {
		return pg_tid;
	}
	public void setPg_tid(String pg_tid) {
		this.pg_tid = pg_tid;
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Timestamp getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Timestamp payment_date) {
		this.payment_date = payment_date;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getPaying_name() {
		return paying_name;
	}
	public void setPaying_name(String paying_name) {
		this.paying_name = paying_name;
	}
	public int getPaying_price() {
		return paying_price;
	}
	public void setPaying_price(int paying_price) {
		this.paying_price = paying_price;
	}
	public String getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	public String getBuyer_chatid() {
		return buyer_chatid;
	}
	public void setBuyer_chatid(String buyer_chatid) {
		this.buyer_chatid = buyer_chatid;
	}
	public String getPg_name() {
		return pg_name;
	}
	public void setPg_name(String pg_name) {
		this.pg_name = pg_name;
	}
	
	
}
