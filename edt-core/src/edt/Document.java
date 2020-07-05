package edt;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class Document extends Section {
    
    /** TreeSet de Autores.*/
    private TreeSet<Author> _authors = new TreeSet<Author>();
    	
    /** HashMap de Elementos.*/
    private HashMap<String, Element> _elements = new HashMap<String, Element>();    
    
    /** Construtor Documento vazio.*/
    public Document() {}

   /**
     * Retorna o titulo do documento.
     * 
     * @return o titulo do documento.
     */
    
    public String getTitle() {
	return super.getTitle();
    }

    /**
     * Altera o titulo do documento.
     * 
     * @param title o titulo do documento.
     */
    
    public void setTitle (String title) {
	super.setTitle(title);
    }
   
   /**
     * Retorna o uniqueId do documento.
     * 
     * @return o uniqueId do documento.
     */
    
    public String getUniqueId() {
	return super.getUniqueId();
    }

    /**
     * Altera o uniqueId do documento.
     * 
     * @param uniqueId o uniqueId do documento.
     */
    
    public void setUniqueId (String uniqueId) {
	super.setUniqueId(uniqueId);
    }
   
    /**
     * Retorna o TreeSet de autores.
     *
     * @return o TreeSet de autores.
     */
    
    public TreeSet<Author> getAuthors(){
	return _authors;
    }
   
   /**
     * Regista um autor e guarda-o num TreeSet.
     * 
     * @param name o nome do autor.
     * @param email o email do autor.
     */
   
    public void registerAuthor(String name, String email) {
	Author author = new Author(name, email);
	this._authors.add(author);
    }
    
    /**
     * Lista os autores com o seu nome e email.
     * 
     * @return uma lista com os autores.
     */
    
    public ArrayList<String> listAuthors() {
	ArrayList<String> result = new ArrayList<String>();
	    for(Author author: _authors){
		result.add(author.getName() + "/" +author.getEmail());
	    }
	return result;
    }
    
    /**
     * Devolve o elemento com o uniqueId dado.
     * 
     * @param uId do elemento.
     * 
     * @return o elemento ou null se nao existir nenhum elemento com o uniqueId.
     */
    
    public Element getElement(String uId){
	return _elements.get(uId);
    }
    
    /**
     * Altera o uniqueId do elemento com o novo uniqueId dado.
     * 
     * @param uId o uniqueId do elemento.
     * @param newUId o novo uniqueId a alterar no elemento.
     */
    
    public void setElement(String uId, String newUId){
	Element e = this.getElement(uId);
	e.setUniqueId(newUId);
    }
    
    /**
     * Regista um elemento.
     * 
     * @param element o elemento recebido.
     */
    
    public void registerElement(Element element) {
	String uId = element.getUniqueId();
	_elements.put(uId, element);
    }
    
    /**
     * Remove um elemento.
     * 
     * @param uId o uniqueId do elemento a remover.
     */
    
    public void removeElement(String uId){
	_elements.remove(uId);
    }
    
    /**
     * Adiciona a seccao 'a ArrayList de Seccoes.
     *
     * @param s a seccao adicionada 'a ArrayList de Seccoes.
     */ 
    
    public void createSection(Section s) {
	super.addSection(s);
    }
    
    /**
     * Adiciona o paragrafo 'a ArrayList de paragrafos.
     *
     * @param p o paragrafo adicionado 'a ArrayList de paragrafos.
     */ 
    
    public void createParagraph(Paragraph p) {
	super.addParagraph(p);
    }
    
    /**
     * Retorna a dimensao do documento, ou seja, o numero de caracteres presentes
     * no documento (todos os paragrafos e titulos de todas as seccoes do documento).
     * 
     * @return os paragrafos e titulos de todas as seccoes do documento.
     */
     
    public int calculateDimension() {
	int title= super.getTitle().length();
	return countAllCharacters()+title;
    }
    
    /**
     * Retorna o numero de identificadores unicos (das seccoes e paragrafos do documento).
     *
     * @return o numero de identificadores unicos.
     */
    
    public int calculateNumberIdentifiers() {
	int countNumberIdentifiers = 0;
	
	for(Map.Entry<String,Element> e: _elements.entrySet()){
	    if(e.getValue() instanceof Section ){
		Section s = (Section)e.getValue();
		if(s.getUniqueId() != null && !s.equalsUniqueId(""))
		    countNumberIdentifiers++;
	    }
	    if(e.getValue() instanceof Paragraph ){
		Paragraph p = (Paragraph)e.getValue();
		if(p.getUniqueId() != null && !p.equalsUniqueId(""))
		    countNumberIdentifiers++;
	    }
	}
	return countNumberIdentifiers;
    }
    
    /**
     * Retorna o numero de seccoes de topo do documento.
     *
     * @return o numero de seccoes de topo do documento.
     */
    
    public int calculateNumberTopSection() {
	return super.sectionSize();
    }
    
    /**
     * E' apresentada a lista de titulos de todas as seccoes de topo do documento,
     * precedido pelo seu identificador unico.
     * 
     * @return o ArrayList de string com o identificador unico e titulo.
     */
    
    public ArrayList<String> listTopSections() {
	 return super.listSections();
    }
    
    /**
     * E' apresentado o tamanho da lista de seccoes de topo.
     * 
     * @return o tamanho da lista de seccoes de topo.
     */
    
    public int sizeTopSections() {
	return listTopSections().size();
    }
    
    @Override
    public void accept(Visitor v){
	v.visitDocument(this);
    }
}