package Database;

public class Userdata {

	private String id;
	private String pass;
	private String name;
	private String brith;
	private Burger Signature;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrith() {
		return brith;
	}
	public void setBrith(String brith) {
		this.brith = brith;
	}
	public Burger getSignature() {
		return Signature;
	}
	public void setSignature(Burger signature) {
		Signature = signature;
	}
}
