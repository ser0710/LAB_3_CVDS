package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
	private ArrayList<Integer> IDList = new ArrayList<Integer>();
	
    public RegisterResult registerVoter(Person p) {
		
		if(!validarId(p)){
			if(!p.isAlive()){
                return RegisterResult.DEAD;
            }
            else if(IDList.contains(p.getId())){
                return RegisterResult.DUPLICATED;
            }
            else if(p.getAge()<18 && p.getAge()>0){
                return RegisterResult.UNDERAGE;
            }
            else{
                return RegisterResult.INVALID_AGE;
            }
		}
		else{
			IDList.add(p.getId());
			return RegisterResult.VALID;
		}
    }
	
	private boolean validarId(Person p){
		boolean bandera = false;
		if(p.getAge() >= 18 && p.getAge()<= 150){
			if(p.isAlive() && !IDList.contains(p.getId())){
				bandera = true;
			}
		}
		return bandera;
	}
}