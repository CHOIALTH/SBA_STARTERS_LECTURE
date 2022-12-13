package board;

class OneBoard {
	private int seq;
	private String title;
	private String contents;
	private String writer;
	private int viewCount;
	/*
	 * public void setSeq(int seq) { this.seq = seq; //구현방법 외부에 오픈되지 X } public int
	 * getSeq() { return seq * 10; }
	 */
	//setter(저장 및 수정 용도) / getter(조회(읽기) 용도)
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	//변수는 private으로 getter/setter은 public으로!
}
