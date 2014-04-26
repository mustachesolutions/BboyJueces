/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import db.ConsultasEvento;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 *
 * @author Enrique
 */
public class AutocompleteController {
    private int totalElementos;
	private String data = "";
	private List<String> listaInformacion;
        
	public AutocompleteController(ArrayList<String> listaInformacionEntrada) {
            this.listaInformacion= listaInformacionEntrada;  
            totalElementos = listaInformacionEntrada.size();
	}
	
	public List<String> getData(String query) {
		String elemento = "";
		query = query.toLowerCase();
		List<String> matched = new ArrayList<String>();
		for(int i=0; i<totalElementos; i++) {
			elemento = listaInformacion.get(i).toLowerCase();
			if(elemento.startsWith(query)) {
				matched.add(listaInformacion.get(i));
			}
		}
		return matched;
	}
                    
        
}
