/** @version $Id: ShowMetadata.java,v 1.7 2015/11/29 06:07:50 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Manager;
import edt.Document;

/**
 * §2.1.2.
 */
public class ShowMetadata extends Command<Manager> {
	public ShowMetadata(Manager manager) {
		super(MenuEntry.SHOW_METADATA, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	      Document document = _receiver.getDocument();
    	      
    	      IO.println(Message.documentTitle(document.getTitle()));
    	      for(String s: document.listAuthors()) {
		  String[] aux = s.split("/");
		  IO.println(Message.author(aux[0],aux[1]));
    	      }
	      IO.println(Message.documentSections(document.calculateNumberTopSection()));
	      IO.println(Message.documentBytes(document.calculateDimension()));
	      IO.println(Message.documentIdentifiers(document.calculateNumberIdentifiers()));
	}
}
