/** @version $Id: EditParagraph.java,v 1.7 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.Paragraph;

/**
 * §2.2.10.
 */
public class EditParagraph extends SectionCommand {
	public EditParagraph(Section section, Document document) {
		super(MenuEntry.EDIT_PARAGRAPH, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    int id = IO.readInteger(Message.requestParagraphId());
	    String content = IO.readString(Message.requestParagraphContent());
	    int size = _receiver.paragraphSize();
	    
	    if(id >= size) {
		IO.println(Message.noSuchParagraph(id)); //Apresenta a mensagem noSuchParagraph
	    }
	    else {
		_receiver.setParagraphContent(id,content); //Altera o conteudo do Paragrafo
	    }
	}
}
