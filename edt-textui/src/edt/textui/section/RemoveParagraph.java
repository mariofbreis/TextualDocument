/** @version $Id: RemoveParagraph.java,v 1.7 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;
import edt.Paragraph;

/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section section, Document document) {
		super(MenuEntry.REMOVE_PARAGRAPH, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
      		int id = IO.readInteger(Message.requestParagraphId());
		int size = _receiver.paragraphSize();
		
		if(id >= size || id < 0) {
		    IO.println(Message.noSuchParagraph(id));
		}
		else {
		    if(!_receiver.equalsParagraphUniqueId(id,"")) {
			String uId = _receiver.getParagraphUniqueId(id);
			_document.removeElement(uId);
		    }
		    _receiver.removeParagraph(id);
		}
	}
}
