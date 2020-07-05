/** @version $Id: Save.java,v 1.7 2015/11/29 06:07:50 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Manager;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Manager> {
	public Save(Manager manager) {
		super(MenuEntry.SAVE, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    String s = _receiver.getFileName();
	    
	    if (s == "") {
		s = IO.readString(Message.newSaveAs());
		_receiver.setFileName(s);
	    }
	    _receiver.saveDocument(s);
	}
}
