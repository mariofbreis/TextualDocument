/** @version $Id: NameParagraph.java,v 1.6 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.Paragraph;

/**
 * §2.2.9.
 */
public class NameParagraph extends SectionCommand {
	public NameParagraph(Section section, Document document) {
		super(MenuEntry.NAME_PARAGRAPH, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int id = IO.readInteger(Message.requestParagraphId());
		String uId = IO.readString(Message.requestUniqueId());
		int size = _receiver.paragraphSize();
		
		if(id >= size) {
		    IO.println(Message.noSuchParagraph(id));
		}
		else {
		    if(_document.getElement(uId) != null) {    //id existe e poe la com uId
			_document.setElement(uId,"");
			_document.removeElement(uId);
		    }
		    if(!_receiver.equalsParagraphUniqueId(id,"")) {
			String uniqueId = _receiver.getParagraphUniqueId(id);
			_document.removeElement(uniqueId);
			IO.println(Message.paragraphNameChanged());
		    }
		    _receiver.setParagraphUniqueId(id,uId);
		    Paragraph p = _receiver.getParagraph(id);
		    _document.registerElement(p);
		}
	}
}
