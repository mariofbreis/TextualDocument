/** @version $Id: ShowIndex.java,v 1.8 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Manager;
import edt.Document;

/**
 * §2.1.4.
 */
public class ShowIndex extends Command<Manager> {
	public ShowIndex(Manager manager) {
		super(MenuEntry.SHOW_INDEX, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document document = _receiver.getDocument();
		
		if(document.sizeTopSections() == 0) {
		    IO.println("{}");
		}
		else {
		    IO.println("{" + document.getTitle() + "}");
		    for(String s: document.listTopSections()) {
			String[] aux = s.split("/");
			IO.println(Message.sectionIndexEntry(aux[0],aux[1]));
		    }
		}
	}
}
