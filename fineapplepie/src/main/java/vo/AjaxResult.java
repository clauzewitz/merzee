package vo;

public class AjaxResult {
	String status;
	Object result;
	
	public String getStatus() {
		return status;
	}
	public AjaxResult setStatus(String status) {
		this.status = status;
		return this;
	}
	public Object getResult() {
		return result;
	}
	public AjaxResult setResult(Object result) {
		this.result = result;
		return this;
	}
	
	
}
