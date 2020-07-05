/** @version $Id: NameSection.java,v 1.6 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;

/**
 * §2.2.6.
 */
public class NameSection extends SectionCommand {
	public NameSection(Section section, Document document) {
		super(MenuEntry.NAME_SECTION, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int id = IO.readInteger(Message.requestSectionId());
		String uId = IO.readString(Message.requestUniqueId());
		int size = _receiver.sectionSize();
		
		if(id >= size) {
		    IO.println(Message.noSuchSection(id));
		}
		else {
		    if(_document.getElement(uId) != null) {    //id existe e poe la com uId
			_document.setElement(uId,"");
			_document.removeElement(uId);
		    }
		    if(!_receiver.equalsSectionUniqueId(id,"")) {
			String uniqueId = _receiver.getSectionUniqueId(id);
			_document.removeElement(uniqueId);
			IO.println(Message.sectionNameChanged());
		    }
		    _receiver.setSectionUniqueId(id,uId);
		    Section s = _receiver.getSection(id);
		    _document.registerElement(s);
		}
	}
}
