/** @version $Id: AddAuthor.java,v 1.10 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Manager;
import edt.Document;
import edt.Author;

/**
 * §2.1.3.
 */
public class AddAuthor extends Command<Manager> {
	public AddAuthor(Manager manager) {
	    super(MenuEntry.ADD_AUTHOR, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    Document document = _receiver.getDocument();
	    String n = IO.readString(Message.requestAuthorName());
	    String e = IO.readString(Message.requestEmail());
	    boolean existsAuthor = false;
	    
	    for(Author a: document.getAuthors()) {
		 if(a.equalsName(n)){
		    existsAuthor = true;
		    break;
		 }
	    }

	    if(existsAuthor) {
		IO.println(Message.duplicateAuthor(n));
	    }
	    else {
		document.registerAuthor(n,e);
	    }
	}
}