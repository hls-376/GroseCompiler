package semanticAnalyzer.types;

public class ArrayType implements Type{

	private Type subType;

	public ArrayType(Type subtype) {
		this.subType = subtype;
	}
	public ArrayType() {
		this.subType = null;
	}
	
	@Override
	public boolean equals(Object otherType) {
		assert otherType instanceof Type;
		assert otherType != null;
		assert subType != null;
		
		if(otherType instanceof PrimitiveType)
			return false;
		else if(otherType instanceof ArrayType)
			return subType.equals(((ArrayType)otherType).subType);
		else 	//Type Variable
			return otherType.equals(this);	
	}
	
	////////////////////////////////////////////////////
	
	public void eliminateTrivialTuple() {
		if(subType instanceof ArrayType) {
			((ArrayType)subType).eliminateTrivialTuple();
			return;
		}
		if(subType instanceof TupleType) {
			if(((TupleType)subType).isTrivial()) {
				this.subType = ((TupleType)subType).getTirvialEquvalenceType();
			}
			return;
		}
	}
	////////////////////////////////////////////////////
	public boolean isSubTypeReference() {
		return (this.subType instanceof ArrayType) 
				|| (this.subType  instanceof TupleType) 
				|| (this.subType == PrimitiveType.STRING);
	}
	
	
	public Type getSubType() {
		return subType;
	}
	public boolean isReferenceType() {
		return true;
	}
	public int getSize() {
		return 4;		
	}
	public int getSubTypeSize() {
		return subType.getSize();
	}
	public String infoString() {
		return "Array of " + subType.infoString();
	}
}
