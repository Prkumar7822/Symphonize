package medical;

public class Data {
	
	private String Pname;
	
	private String disease;
	private int amount;
	public Data(String Pname,String disease,int amount) {
		this.Pname=Pname;
		this.disease=disease;
		this.amount=amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "Data [Pname=" + Pname + ", disease=" + disease + ", getPname()=" + getPname() + ", getDisease()="
				+ getDisease() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
