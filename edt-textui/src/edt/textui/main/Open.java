/** @version $Id: Open.java,v 1.4 2015/11/29 06:07:50 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import java.io.FileNotFoundException;
import edt.Manager;

/**
 * Open existing document.
 */
public class Open extends Command<Manager> {
	public Open(Manager manager) {
		super(MenuEntry.OPEN, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    String s = IO.readString(Message.openFile());
	    
	    try {
		_receiver.openDocument(s);
	    }
	    catch(FileNotFoundException e) {
		IO.println(Message.fileNotFound());
	    }
	    catch(ClassNotFoundException e) {}
	}
}