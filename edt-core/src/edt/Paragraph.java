package edt;

public class Paragraph extends Element { 

    /** Conteudo do Paragrafo.*/
    private String _content;

    /** Construtor Paragrafo.
     *
     * @param content o conteudo da do paragrafo.
     */
    
    public Paragraph(String content) {
	_content = content;
	super.setUniqueId("");
    }

    /**
     * Retorna o numero de ordem que identifica o paragrafo.
     * 
     * @return o numero de ordem que identifica o paragrafo.
     */
    
    public int getId() {
	return super.getId();
    }
    
    /**
     * Altera o numero de ordem que identifica o paragrafo.
     * 
     * @param id o numero de ordem que identifica o paragrafo.
     */
     
    public void setId (int id) {
	super.setId(id);
    }
    
    /**
     * Retorna o identificador unico do paragrafo no contexto do documento.
     * 
     * @return o identificador unico do paragrafo no contexto do documento.
     */
     
    public String getUniqueId() {
	return super.getUniqueId();
    }
    
    /**
     * Altera o identificador unico do paragrafo no contexto do documento.
     * 
     * @param uniqueId o identificador unico do paragrafo no contexto do documento.
     */

    public void setUniqueId (String uniqueId) {
	super.setUniqueId(uniqueId);
    }
    
    /**
     * Retorna o conteudo do paragrafo.
     * 
     * @return o conteudo do paragrafo.
     */
    
    public String getContent() {
	return _content;
    }

    /**
     * Altera o conteudo do paragrafo.
     * 
     * @param content o conteudo do paragrafo.
     */
    
    public void setContent (String content) {
	_content = content;
    }

    /**
     * Retorna os caracteres existentes no conteudo do paragrafo.
     * 
     * @return caracteres existentes no conteudo do paragrafo.
     */
    
    public int countCharacters() {
	return _content.length();
    }
    
    /**
     * Indica se um uniqueId e' igual a este uniqueId do paragrafo.
     * 
     * @param otherUniqueId o outro uniqueId a comparar.
     *
     * @return true caso o outro uniqueId e o uniqueId do paragrafo
     * sejam iguais e false, caso contrario.
     */
    
    public boolean equalsUniqueId(String otherUniqueId) {
	return this.getUniqueId().equals(otherUniqueId);
    }
    
    @Override
    public void accept(Visitor v){
	v.visitParagraph(this);
    }
}
