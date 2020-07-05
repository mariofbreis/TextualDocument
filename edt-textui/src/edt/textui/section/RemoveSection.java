/** @version $Id: RemoveSection.java,v 1.7 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;

/**
 * §2.2.7.
 */
public class RemoveSection extends SectionCommand {
	public RemoveSection(Section section, Document document) {
		super(MenuEntry.REMOVE_SECTION, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int id = IO.readInteger(Message.requestSectionId());
		int size = _receiver.sectionSize();
		
		if(id >= size || id <0) {
		    IO.println(Message.noSuchSection(id)); //Apresenta a mensagem noSuchSection
		}
		else {
		    String uId = _receiver.getSectionUniqueId(id);
		    _document.removeElement(uId);
		    _receiver.removeSection(id); //Remove a seccao indicada
		}
	}
}
