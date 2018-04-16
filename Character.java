
public class Character {
	String name, desc;
	int comp;

	//constructors
	public Character(){
		name = "Unknown";
		desc = "Unknown";
		comp = 0;
	}
	public Character(String name, String desc){
		this.name = name;
		this.desc = desc;
		comp = 0;
	}
	
	//name
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	//description
	public void setDesc(String desc){
		this.desc = desc;
	}
	public String getDesc(){
		return desc;
	}
	
	//compatibility
	public void setComp(int comp){
		this.comp = comp;
	}
	public int getComp(){
		return comp;
	}
}
