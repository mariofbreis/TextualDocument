/** @version $Id: ShowContent.java,v 1.6 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;

/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section section, Document document) {
		super(MenuEntry.SHOW_CONTENT, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    String documentTitle = _document.getTitle();
	    if(_receiver.equalsTitle(documentTitle)) {
		new ShowContentVisitor(_document);
	    }
	    else {
		new ShowContentVisitor(_receiver);
	    }
	}
}
