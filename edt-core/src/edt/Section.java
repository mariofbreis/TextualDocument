package edt;

import java.util.ArrayList;

public class Section extends Element {

    /** Titulo da Seccao.*/
    private String _title = "";
    
    /** ArrayList de Seccoes.*/
    private ArrayList<Section> _sections = new ArrayList<Section>();
    
    /** ArrayList de Paragrafos.*/
    private ArrayList<Paragraph> _paragraphs = new ArrayList<Paragraph>();
    
    /** Construtor Seccao vazio.*/
    public Section() {}
   
    /** Construtor Seccao.
     *
     * @param title o titulo da seccao.
     */
   
    public Section(String title) {
	_title = title;
	setUniqueId("");
    }
    
    /**
     * Retorna o numero de ordem que identifica a subseccao.
     * 
     * @return o numero de ordem que identifica a subseccao.
     */

    public int getId() {
	return super.getId();
    }
    
    /**
     * Altera o numero de ordem que identifica a subseccao.
     * 
     * @param id o numero de ordem que identifica a subseccao.
     */
     
    public void setId (int id) {
	super.setId(id);
    }
    
    /**
     * Retorna o identificador unico da seccao no contexto do documento.
     * 
     * @return o identificador unico da seccao no contexto do documento.
     */
     
    public String getUniqueId() {
	return super.getUniqueId();
    }
    
    /**
     * Altera o identificador unico da seccao no contexto do documento.
     * 
     * @param uniqueId o identificador unico da seccao no contexto do documento.
     */
    
    public void setUniqueId (String uniqueId) {
	super.setUniqueId(uniqueId);
    }
    
    /**
     * Retorna o titulo da seccao.
     * 
     * @return o titulo da seccao.
     */
    
    public String getTitle() {
	return _title;
    }

    /**
     * Altera o titulo da seccao.
     * 
     * @param title o titulo da seccao.
     */
    
    public void setTitle (String title) {
	_title = title;
    }

    /**
     * Retorna a ArrayList de seccoes.
     *
     * @return a ArrayList de seccoes.
     */
    
    public ArrayList<Section> getSections() {
	return _sections;
    }
    
    /**
     * Devolve a subseccao com o id dado.
     * 
     * @param id da subseccao.
     * 
     * @return a subseccao ou null se nao existir nenhuma subseccao com o id.
     */
    
    public Section getSection(int id) {
	return _sections.get(id);
    }
    
    /**
     * Devolve o uniqueId da seccao com o id dado.
     * 
     * @param id o id da seccao.
     *
     * @return uId o uniqueId da seccao com o id dado.
     */ 
    
    public String getSectionUniqueId(int id) {
	Section s = this.getSection(id);
	String uId = s.getUniqueId();
	return uId;
    }
    
    /**
     * Altera o uniqueId da seccao com o id dado.
     * 
     * @param id o id da seccao.
     * @param uniqueId o uniqueId a alterar.
     */
    
    public void setSectionUniqueId(int id, String uniqueId) {
	Section s = this.getSection(id);
	s.setUniqueId(uniqueId);
    }
    
    /**
     * Devolve o tamanho da ArrayList de seccoes, ou seja, apresenta
     * o numero de subseccoes existentes na ArrayList de seccoes.
     * 
     * @return o numero de subseccoes existentes na ArrayList de seccoes.
     */
     
    public int sectionSize() {
	return _sections.size();
    }
    
    /**
     * Adiciona a subseccao 'a ArrayList de seccoes.
     *
     * @param s a subseccao a adicionar 'a ArrayList de Seccoes.
     */ 
    
    public void addSection(Section s) {
	_sections.add(s);
    }

    /**
     * Adiciona a subseccao com id 'a ArrayList de seccoes.
     *
     * @param id o id onde adicionar a subseccao.
     * @param s a subseccao a adicionar 'a ArrayList de seccoes.
     */
    
    public void addSection(int id, Section s) {
	_sections.add(id, s);
    }
      
    /**
     * Remove uma seccao.
     * 
     * @param id o id da seccao a remover.
     */

    public void removeSection(int id) {
	_sections.remove(id);
    }
    
    /**
     * Indica se um outro uniqueId e' igual ao uniqueId de uma
     * subseccao com id.
     * 
     * @param id o id da subseccao.
     * @param otherUniqueId o outro uniqueId a comparar.
     *
     * @return true caso o outro uniqueId e o uniqueId da subseccao
     * sejam iguais e false, caso contrario.
     */
    
    public boolean equalsSectionUniqueId(int id, String otherUniqueId) {
	return this.getSectionUniqueId(id).equals(otherUniqueId);
    }

    /**
     * Retorna a ArrayList de paragrafos.
     *
     * @return a ArrayList de paragrafos.
     */
    
    public ArrayList<Paragraph> getParagraphs() {
	return _paragraphs;
    }
    
    /**
     * Devolve o paragrafo com o id dado.
     * 
     * @param id do paragrafo.
     * 
     * @return o paragrafo ou null se nao existir nenhum paragrafo com o id.
     */
     
    public Paragraph getParagraph(int id) {
	return _paragraphs.get(id);
    }
    
    /**
     * Altera o conteudo do paragrafo com o id dado.
     * 
     * @param id o id do paragrafo.
     * @param content o conteudo do paragrafo a alterar.
     */ 
    
    public void setParagraphContent(int id, String content) {
	Paragraph p = this.getParagraph(id);
	p.setContent(content);
    }
    
    /**
     * Altera o uniqueId do paragrafo com o id dado.
     * 
     * @param id o id do paragrafo.
     * @param uniqueId o uniqueId a alterar.
     */ 
    
    public void setParagraphUniqueId(int id, String uniqueId) {
	Paragraph p = this.getParagraph(id);
	p.setUniqueId(uniqueId);
    }
    
    /**
     * Devolve o uniqueId do paragrafo com o id dado.
     * 
     * @param id o id do paragrafo.
     *
     * @return uId o uniqueId do paragrafo com o id dado.
     */ 
    
    public String getParagraphUniqueId(int id) {
	Paragraph p = this.getParagraph(id);
	String uId = p.getUniqueId();
	return uId;
    }
    
    /**
     * Devolve o tamanho da ArrayList de paragrafos, ou seja, apresenta
     * o numero de paragrafos existentes na ArrayList de paragrafos.
     * 
     * @return o numero de paragrafos existentes na ArrayList de paragrafos.
     */
    
    public int paragraphSize() {
	return _paragraphs.size();
    }
    
    /**
     * Adiciona o paragrafo 'a ArrayList de paragrafos.
     *
     * @param p o paragrafo a adicionar 'a ArrayList de paragrafos.
     */ 
    
    public void addParagraph(Paragraph p) {
	_paragraphs.add(p);
    }
    
    /**
     * Adiciona o paragrafo com id 'a ArrayList de paragrafos.
     *
     * @param id o id onde adicionar o paragrafo.
     * @param p o paragrafo a adicionar 'a ArrayList de paragrafos.
     */
    
    public void addParagraph(int id, Paragraph p) {
	_paragraphs.add(id, p);
    }
    
    /**
     * Remove um paragrafo.
     * 
     * @param id o id do paragrafo a remover.
     */

    public void removeParagraph(int id) {
	_paragraphs.remove(id);
    }
    
    /**
     * Indica se um outro uniqueId e' igual ao uniqueId de um
     * paragrafo com id.
     * 
     * @param id o id do paragrafo.
     * @param otherUniqueId o outro uniqueId a comparar.
     *
     * @return true caso o outro uniqueId e o uniqueId do paragrafo
     * sejam iguais e false, caso contrario.
     */
    
    public boolean equalsParagraphUniqueId(int id, String otherUniqueId) {
	return this.getParagraphUniqueId(id).equals(otherUniqueId);
    }
    
    /**
     * E' apresentada a lista de titulos de todas as subseccoes da seccao actual,
     * precedido pelo seu identificador unico.
     * 
     * @return o ArrayList de string com o identificador unico e titulo.
     */
    
    public ArrayList<String> listSections() {
	ArrayList<String> sections = new ArrayList<String>();
	for(Section s : _sections){
	    sections.add(s.getUniqueId() + "/" + s.getTitle());
	}
	return sections;
    }
    
    /**
     * E' apresentada a lista de titulos de todas as subseccoes da seccao actual,
     * precedido pelo seu identificador unico (recursivamente)
     *
     * @return o ArrayList de string com o identificador unico e titulo.
     */
    
    public ArrayList<String> listSubSections() {
	ArrayList<String> result = new ArrayList<String>();
	for(Section s: this._sections){
	    result.add("[" + s.getUniqueId() + "]" + "{" + s.getTitle() + "}");
	    result.addAll(s.listSubSections());
	}    
	return result;
    }
    
    /**
     * E' apresentado o tamanho da lista de subseccoes.
     * 
     * @return o tamanho da lista de subseccoes.
     */
    
    public int sizeSections() {
	return listSections().size();
    }

    /**
     * Retorna os caracteres existentes no titulo da seccao.
     * 
     * @return os caracteres existentes no titulo da seccao.
     */
    
    public int countCharacters() {
	return _title.length();
    }
    
    /**
     * Retorna o numero de todos os caracteres existentes em todos os titulos
     * de seccoes e no conteudo dos paragrafos.
     * 
     * @return o numero de todos os caracteres existentes em todos os titulos
     * de seccoes e no conteudo dos paragrafos.
     */
    
    public int countAllCharacters() {
	int countS = 0;
	int countP = 0;
	
	for(Section s : _sections) {
	    countS += s.countAllCharacters() + s.countCharacters();
	}
	for(Paragraph p : _paragraphs) {
	  countP += p.countCharacters();
	}
	return countS+countP;
    }
     
    /**
     * Indica se um outro titulo e' igual a este titulo da seccao.
     * 
     * @param otherTitle o outro titulo a comparar.
     *
     * @return true caso o outro titulo e o titulo da seccao
     * sejam iguais e false, caso contrario.
     */
    
    public boolean equalsTitle(String otherTitle) {
	return this.getTitle().equals(otherTitle);
    }
    
    /**
     * Indica se um uniqueId e' igual a este uniqueId da seccao.
     * 
     * @param otherUniqueId o outro uniqueId a comparar.
     *
     * @return true caso o outro uniqueId e o uniqueId da seccao
     * sejam iguais e false, caso contrario.
     */
    
    public boolean equalsUniqueId(String otherUniqueId) {
	return this.getUniqueId().equals(otherUniqueId);
    }
    
    @Override
    public void accept(Visitor v) {
	v.visitSection(this);
    } 
}