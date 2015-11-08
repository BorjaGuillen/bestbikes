/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.types;

/**
 *
 * @author jorge
 */
public enum TypeAtributos {
    
    GANGAS(null, "F:Gangas"),
    
    OFERTA_ESPECIAL(null, "F:OfertaEspecial"),
    
    CUBIERTA_26 ("BEREIFUNG", "F:26"),
    
    CUBIERTA_27_5 ("BEREIFUNG", "F:27.5"),

    CUBIERTA_28 ("BEREIFUNG", "F:28"),
    
    CUBIERTA_29 ("BEREIFUNG", "F:29"),

    FRENOS_DE_DISCO("BREMSEN" , "F:frenosdedisco"),

    PEDALES_CARRETERA("PEDALE","F:pedalparalacarrera"),
		
    PLATOS_EJES_VIELAS_CARRETERA("TRETLAGER", "F:bicicletadecarrera"),
    
    RUEDAS_26 ("LAUFRÄDER", "F:26"),
    
    RUEDAS_27_5 ("LAUFRÄDER", "F:27.5"),

    RUEDAS_28 ("LAUFRÄDER", "F:28"),
    
    RUEDAS_29 ("LAUFRÄDER", "F:29");

    
    
    private String codcategoria;
    
    private String atributo;

    private TypeAtributos(String codcategoria, String atributo) {
        this.codcategoria = codcategoria;
        this.atributo = atributo;
    }

    public String getCodcategoria() {
        return codcategoria;
    }

    public String getAtributo() {
        return atributo;
    }
    
    
    
    
    
    
}
