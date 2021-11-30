package org.lanqiao.regist.web.bean;

public class regist {
	private int rid;
	private String tel;
	private String psd;
	private int sex;
	private String hobby;

	public regist() {
	}

	public regist(int rid, String tel, String psd, int sex, String hobby) {
		this.rid = rid;
		this.tel = tel;
		this.psd = psd;
		this.sex = sex;
		this.hobby = hobby;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	@Override
	public String toString() {
		return "regist{" +
				"rid=" + rid +
				", tel='" + tel + '\'' +
				", psd='" + psd + '\'' +
				", sex=" + sex +
				", hobby='" + hobby + '\'' +
				'}';
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;


	}
}
