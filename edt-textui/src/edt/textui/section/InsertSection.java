/** @version $Id: InsertSection.java,v 1.8 2015/11/29 06:07:50 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;

/**
 * §2.2.5.
 */
public class InsertSection extends SectionCommand {
	public InsertSection(Section section, Document document) {
		super(MenuEntry.INSERT_SECTION, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    int id = IO.readInteger(Message.requestSectionId());
	    String title = IO.readString(Message.requestSectionTitle());
	    int size = _receiver.sectionSize();
	    Section newSection = new Section(title);
	   	    
	    if(id >= size) {
		_receiver.addSection(newSection); //insere a nova subseccao no final da seccao actual
	    }
	    else {
	    	_receiver.addSection(id,newSection); //insere a nova subseccao antes de outra de referencia
	    }
	}
}
