package edt;

import java.io.Serializable;

public abstract class Element implements Serializable {
    
    /** Numero de ordem.*/
    private int _id = 0;
    
    /** Identificador unico.*/
    private String _uniqueId;

    /** Construtor Element.*/
    public Element() {}

    /**
     * Retorna o numero de ordem.
     * 
     * @return o numero de ordem.
     */
    
    public int getId() {
	return _id;
    }

    /**
     * Altera o numero de ordem.
     * 
     * @param id o numero de ordem.
     */
    
    public void setId (int id) {
	_id = id;
    }

    /**
     * Retorna o identificador unico.
     * 
     * @return o identificador unico.
     */
    
    public String getUniqueId() {
	return _uniqueId;
    }

    /**
     * Altera o identificador unico.
     * 
     * @param uniqueId o identificador unico.
     */
    
    public void setUniqueId (String uniqueId) {
	_uniqueId = uniqueId;
    }
    
    /** Metodo abstracto para contar os caracteres existentes nas classes derivadas.*/
    public abstract int countCharacters();
    
    /** Metodo abstracto para comparar os uniqueIds nas classes derivadas.*/
    public abstract boolean equalsUniqueId(String otherUniqueId);
    
    public abstract void accept(Visitor v);
}
