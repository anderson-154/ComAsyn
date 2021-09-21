package client.model;

public class Mss {
	
	private String type = "Message";
	private String id;
	private String body;

	public Mss() {
	
	}
	
	public Mss(String type, String body) {
		this.type = type;
		this.body = body;
	}
	
	public String getId() {
		return id;
	}

	public String getBody() {
		return body;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
