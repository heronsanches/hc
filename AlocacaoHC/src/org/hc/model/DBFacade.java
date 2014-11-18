package org.hc.model;

import java.util.Iterator;

public class DBFacade {

	private DBFacade(){}
	
	public static void getSetor(Setor setor){
		
		Iterator<Setor> i = DB.getDB().getSetores().iterator();
		
		while(i.hasNext()){
			
			//if(i.next().)
			
		}
		
	}
	
}
