package bpmis.pxc.system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.pxcbpmisframework.core.common.entity.IdEntity;

/**
 * 日志类
 * 
 * @ClassName: TBLogger
 * @author Mr_Pxc
 * @date 2013-7-12 下午02:43:09
 * @project_name：BPMIS_1
 * @version 1.0
 */
@Entity
@Table(name = "t_s_logger")
public class TBLogger extends IdEntity implements java.io.Serializable {
	private String userid;
	private String account; // 账号 或 Guest 根据userid去取得
	private String loglevel;
	private String logcontent;
	private String logmessage;
	private String broswertype;
	private String operatetime;
	private String operatetype;
	private String operateurl; // 操作url，可追踪
	private String adrip;

	@Transient
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "operateurl", length = 200)
	public String getOperateurl() {
		return operateurl;
	}

	public void setOperateurl(String operateurl) {
		this.operateurl = operateurl;
	}

	@Column(name = "logmessage", length = 1000)
	public String getLogmessage() {
		return logmessage;
	}

	public void setLogmessage(String logmessage) {
		this.logmessage = logmessage;
	}

	@Column(name = "loglevel", length = 50)
	public String getLoglevel() {
		return loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	@Column(name = "logcontent", length = 200)
	public String getLogcontent() {
		return logcontent;
	}

	public void setLogcontent(String logcontent) {
		this.logcontent = logcontent;
	}

	@Column(name = "broswertype", length = 200)
	public String getBroswertype() {
		return broswertype;
	}

	public void setBroswertype(String broswertype) {
		this.broswertype = broswertype;
	}

	@Column(name = "operatetime", length = 50)
	public String getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(String operatetime) {
		this.operatetime = operatetime;
	}

	@Column(name = "operatetype", length = 50)
	public String getOperatetype() {
		return operatetype;
	}

	public void setOperatetype(String operatetype) {
		this.operatetype = operatetype;
	}

	@Column(name = "adrip", length = 50)
	public String getAdrip() {
		return adrip;
	}

	public void setAdrip(String adrip) {
		this.adrip = adrip;
	}

	@Column(name = "userid", length = 50)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
