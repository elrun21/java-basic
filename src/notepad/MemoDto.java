package notepad;

public class MemoDto {

    private String seq;     //고유번호
    private String name;	//이름
    private String regdate;	//날짜
    private String priority;//중요도(A, B, C)
    private String content;	//메모내용


    //각 변수명 Getter / Setter
    public String getSeq() {return seq;}
    public void setSeq(String seq) {this.seq = seq;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getRegdate() {return regdate;}
    public void setRegdate(String regdate) {this.regdate = regdate;}
    public String getPriority() {return priority;}
    public void setPriority(String priority) {this.priority = priority;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}

    @Override
    public String toString() {
        return "Memo [seq=" + seq
                + ", name=" + name
                + ", regdate=" + regdate
                + ", priority=" + priority
                + ", content="+ content + "]";
    }

}
