package es.bestbikes.types;

/**
 *
 * @author jorge
 */
public enum TypeJaxb {
    
    BEST_BIKES("es.bestbikes.jaxb");

    private TypeJaxb(String value) {
        this.value = value;
    }
    
    private String value;
    
    
    public String getValue() {
        return value;
    }
    
}
