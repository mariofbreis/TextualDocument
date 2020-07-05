/** @version $Id: New.java,v 1.5 2015/11/15 06:14:07 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Manager;

/**
 * Open a new document.
 */
public class New extends Command<Manager> {
	public New(Manager manager) {
		super(MenuEntry.NEW, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.newDocument();
	}
}