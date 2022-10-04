package kr.or.ddit.basic.session;

public class Testmember {
	private String testId;
	private String name;
	
	
	
	public Testmember(String testId, String name) {
		super();
		this.testId = testId;
		this.name = name;
	}
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Testmember [testId=" + testId + ", name=" + name + "]";
	}
	
	
	
	
}
