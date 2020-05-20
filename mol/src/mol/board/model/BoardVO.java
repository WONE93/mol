package mol.board.model;

public class BoardVO {
	
	String seq;
	String id;
	String title;
	String recommend;
	String reason;
	String regdt;
	String love;
	String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", id=" + id + ", title=" + title + ", recommend=" + recommend + ", reason="
				+ reason + ", regdt=" + regdt + ", love=" + love + ", name=" + name + "]";
	}



	
	

}
