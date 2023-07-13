package registers;

import error.MsgErros;

public class Register{

	private int min;
	private int max;
	private TypeRegister type;
	private int nextPosition;

	public Register(int min, int max, TypeRegister type){
		this.min = min;
		this.max = max;
		this.type = type;
		this.nextPosition = min;
	}

	public int alocRegister(){
		int position = nextPosition;
		if(position > max){
			MsgErros.estouroRegister(this.type);			
		}else{
			nextPosition++;
		}
		return position;
	}

	public void freeRegister(){
		nextPosition--;
	}
}