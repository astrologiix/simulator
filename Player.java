public class Player {
	String name, gender;
	int prog;
	String fileName;

	// constructors
	public Player() {
		name = "Unknown";
		gender = "Unknown";
		prog = 0;
	}

	public Player(String name, String gender, int prog) {
		this.name = name;
		this.gender = gender;
		this.prog = prog;
	}

	// name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	// gender
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender(){
		return gender;
	}

	//prog
	public void setProgress(int prog){
		this.prog = prog;
	}
	public int getProgress(){
		return prog;
	}

	//file
	public void setFile(String fileName){
		this.fileName = fileName;
	}
	public String getFile(){
		return fileName;
	}
}
