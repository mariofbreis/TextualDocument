/** @version $Id: ShowTextElement.java,v 1.7 2015/11/29 21:32:45 ist170969 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.textui.section.ShowContentVisitor;
import edt.Manager;
import edt.Element;
import edt.Section;
import edt.Paragraph;
import edt.Document;

/**
 * §2.1.5.
 */
public class ShowTextElement extends Command<Manager> {
	public ShowTextElement(Manager manager) {
	    super(MenuEntry.SHOW_TEXT_ELEMENT, manager);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    String uId = IO.readString(Message.requestElementId());
	    Document document = _receiver.getDocument();
	    
	    if(document.getElement(uId) == null) {
		IO.println(Message.noSuchTextElement(uId));
	    }
	    else {
		Element e = document.getElement(uId);
		if(e instanceof Paragraph) {
		    Paragraph p = (Paragraph)e;
		    new ShowContentVisitor(p);
		}
		else {
		    Section s = (Section)e;
		    new ShowContentVisitor(s);
		}
	    }
	}
}
