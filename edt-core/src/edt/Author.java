package edt;

import java.io.Serializable;

public class Author implements Comparable<Author>, Serializable  { 
    
    /** Nome do autor.*/
    private String _name;
    
    /** Email do autor.*/
    private String _email;
    
    /** Construtor Autor.
    *
    * @param name o nome do autor
    * @param email o email do autor
    */
    
    public Author(String name, String email) {
	_name = name;
	_email = email;
    }
    
    /**
     * Retorna o nome do autor.
     * 
     * @return o nome do autor.
     */
     
    public String getName() {
	return _name;
    }
    
    /**
     * Retorna o email do autor.
     * 
     * @return o email do autor.
     */

    public String getEmail() {
	return _email;
    }
    
    /**
     * Altera o nome do autor.
     * 
     * @param name o nome do autor.
     */
	 
    public void setName (String name) {
	_name = name;
    }
    
    /**
     * Altera o email do autor.
     * 
     * @param email o email do autor.
     */
     
    public void setEmail (String email) {
	_email = email;
    }
    
    /**
     * Indica se um outro nome e' igual a este nome do autor.
     * 
     * @param otherName o outro nome a comparar.
     *
     * @return true caso o outro nome e o nome do autor
     * sejam iguais e false, caso contrario.
     */
    
    public boolean equalsName(String otherName) {
	return this.getName().equals(otherName);
    }
    
    @Override
    public int compareTo(Author arg0) {
	return this.getName().compareTo(arg0.getName());
    }
}