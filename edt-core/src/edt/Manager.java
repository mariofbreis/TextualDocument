package edt;

import java.lang.ClassNotFoundException;
import java.io.IOException;
import java.io.EOFException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manager {
	
	/** Nome do ficheiro actual.*/
	private String filename = "";
	
	/** Documento.*/
	private Document _activeDocument = new Document();

	/**
	 * Altera o documento que esta associado ao ficheiro.
	 * 
	 * @param doc o novo documento associado ao ficheiro.
	 */
	
	public void setDocument(Document doc){
	    _activeDocument = doc;
	}
	
	/**
	 * Retorna o documento que esta associado ao ficheiro.
	 * 
	 * @return o documento associado ao ficheiro.
	 */
	
	public Document getDocument(){
	    return _activeDocument;
	}
	
	/**
	 * Altera o nome do ficheiro actual onde o documento e' guardado.
	 * 
	 * @param s o nome do ficheiro actual.
	 */
	
	public void setFileName(String s) {
	    filename = s;
	}
	
	/**
	 * Retorna o nome do ficheiro actual onde o documento e' guardado.
	 * 
	 * @return o nome do ficheiro actual.
	 */
	 
	public String getFileName() {
	    return filename;
	}
	
	/**
	 * Retorna se ha' um documento.
	 *  
	 * @return true se o documento nao for vazio e false caso contrario.
	 */
	
	public boolean isReady() {
	    return (_activeDocument != null);
	}

	/** Construtor Manager vazio.*/
	public Manager() {}

/**
 * ---------- Funcoes Main ----------
 * Gere a salvaguarda do estado da aplicação e opera sobre o documento actual
 */

	/** Cria um novo documento anonimo nao associado a nenhum ficheiro.*/
	public void newDocument() {
	    filename = "";
	    _activeDocument = new Document();
	}
	
	/**
	* Carrega um documento anteriormente salvaguardado ficando o
	* documento carregado associado ao ficheiro nomeado.
	*
	* @param s o nome do ficheiro com os dados serializados.
	*
	* @throws IOException,FileNotFoundException,ClassNotFoundException
	* caso aconteca algum erro durante a leitura.
	*/

	public void openDocument(String s) throws FileNotFoundException, ClassNotFoundException, IOException {
	    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream (s)));
	    this.setFileName(s);
	    Document doc = (Document)in.readObject();
	    this.setDocument(doc);
	    in.close();
	}

	/**
	 * Guarda o estado actual do documento no ficheiro associado
	 *
	 * @param s o nome do ficheiro a conter os dados a serializar.
	 *
	 * @throws IOException,FileNotFoundException caso aconteca algum erro
	 * durante a gravacao do documento.
	 */
	
	public void saveDocument(String s) throws IOException, FileNotFoundException {
	    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(s)));
	    out.writeObject(_activeDocument);
	    out.close();
	}
	
/**
 * ---------- Import ----------
 * Le um ficheiro de entrada e armazena as estruturas nele contidas.
 * 
 * @param datafile e o nome do ficheiro de entrada.
 * @throws IOException caso aconteca algum erro
 * durante a leitura e armazenamento do ficheiro.
 */

	public void parseInputFile(String datafile) throws IOException {

	    BufferedReader in = new BufferedReader(new FileReader(datafile));
	    _activeDocument = new Document();
	
	    try {
		// Titulo
		String title = in.readLine();
		_activeDocument.setTitle(title);
		// Autores
		String authorsSet = in.readLine();
		String[] authors = authorsSet.split("[\\|\n]");
		for(String s : authors){
		    String[] aux = s.split("/");
		    _activeDocument.registerAuthor(aux[0],aux[1]);
		}
	    
		String s = in.readLine();
		String delim = "[\\|\n]";
		String[] input=s.split(delim);
	    
		// Pararafo
		while(!(input[0].equals("SECTION")) && s!=null){
		    Paragraph p = new Paragraph(input[1]);
		    _activeDocument.registerElement(p);
		    _activeDocument.createParagraph(p);
		    s = in.readLine();
		    if(s==null)
			break;
		    input = s.split(delim);
		}
		
		while(s!=null){
		    // Seccao
		    if(input[0].equals("SECTION")){
			Section section = new Section(input[2]);
			section.setUniqueId(input[1]);
			_activeDocument.registerElement(section);
			_activeDocument.createSection(section);
			s = in.readLine();
			if(s==null)
			    break;
			input = s.split(delim);
			
			// Pararafo
			while(input[0].equals("PARAGRAPH") && s!=null){
			    Paragraph p = new Paragraph(input[1]);
			    section.addParagraph(p);
			    s = in.readLine();
			    if(s==null)
				break;
			    input = s.split(delim);
			}
		    }
		}
	    }
	catch (IOException ioe) {}
	}
}