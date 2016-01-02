package src.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class AuthorityVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 22884361230891914L;
	ArrayList<Integer> authority;
	String position;
	
	public AuthorityVO(String position){
		this.position = position;
	}

	public String getPosition(){
		return position;
	}
	
	public void setAuthority(ArrayList<Integer> authority){
		this.authority = authority;
	}
	
	public ArrayList<Integer> getAuthority(){
		return authority;
	}
}
