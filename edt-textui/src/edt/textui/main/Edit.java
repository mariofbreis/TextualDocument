/** @version $Id: Edit.java,v 1.4 2015/11/25 19:23:17 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Manager;
import edt.Document;

/**
 * §2.3.1.
 */
public class Edit extends Command<Manager> {
	public Edit(Manager manager) {
	    super(MenuEntry.OPEN_DOCUMENT_EDITOR, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    Document document = _receiver.getDocument();
	    edt.textui.section.MenuBuilder.menuFor(document, document);
	}
}
