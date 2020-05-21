package mol.comments.model;

public class CommentsVO {
	
	String cseq;
	String bseq;
	String id;
	String comments;
	String regdt;
	
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getBseq() {
		return bseq;
	}
	public void setBseq(String bseq) {
		this.bseq = bseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	@Override
	public String toString() {
		return "CommentsVO [cseq=" + cseq + ", bseq=" + bseq + ", id=" + id + ", comments=" + comments + ", regdt="
				+ regdt + "]";
	}
	
	

}
