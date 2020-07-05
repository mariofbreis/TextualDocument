/** @version $Id: InsertParagraph.java,v 1.8 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.Paragraph;

/**
 * §2.2.8.
 */
public class InsertParagraph extends SectionCommand {
	public InsertParagraph(Section section, Document document) {
		super(MenuEntry.INSERT_PARAGRAPH, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    int id = IO.readInteger(Message.requestParagraphId());
	    String content = IO.readString(Message.requestParagraphContent());
	    int size = _receiver.paragraphSize();
	    Paragraph newParagraph = new Paragraph(content);
	    
	    if(id >= size) {
		_receiver.addParagraph(newParagraph); //insere o novo paragrafo no final da sequencia de paragrafos da seccao
	    }
	    else {
		_receiver.addParagraph(id,newParagraph); //insere o novo paragrafo antes de outro de referencia
	    }
	}
}
