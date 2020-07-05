/** @version $Id: SelectSection.java,v 1.5 2015/11/29 00:10:59 ist173751 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Document;

/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(Section section, Document document) {
		super(MenuEntry.SELECT_SECTION, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException  {
		int id = IO.readInteger(Message.requestSectionId());
		int size = _receiver.sectionSize();
		if(id >= size || id < 0) {
		    IO.println(Message.noSuchSection(id));
		}
		else {
		    Section s = _receiver.getSection(id);
		    IO.println(Message.newActiveSection(id));
		    edt.textui.section.MenuBuilder.menuFor(s, _document);
		}
	}
}
