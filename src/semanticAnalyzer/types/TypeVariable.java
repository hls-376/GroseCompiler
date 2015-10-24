package semanticAnalyzer.types;

public class TypeVariable implements Type{

	private Type type;
	private String name;
	
	public TypeVariable(String name) {
		this.name = name;
		this.type = null;
	}
	
	public boolean equals(Object otherType) {
		assert otherType instanceof Type;
				
		System.out.println(((Type)otherType).infoString());
		System.out.println(this.type);
		if(this.type == null) {
			this.type = (Type)otherType;
			return true;
		} else {
			return otherType.equals(this.type);	
		}
			
	}
	
	public Type getType() {
		return this.type;
	}
	public void reset() {
		this.type = null;
	}
	
 	public int getSize() {
		return type.getSize();
	}
	
	public String infoString() {
		if(type instanceof ArrayType) {
			return "Type Variable " + name+ "Array of " + ((ArrayType)type).infoString();
		}
		else
			return "Type Variable " + name+ "Array of " + type.toString();
	}
}
