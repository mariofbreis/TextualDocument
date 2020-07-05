/** @version $Id: ListSections.java,v 1.6 2015/11/29 06:07:50 ist170969 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.util.ArrayList;
import java.io.IOException;
import edt.Section;
import edt.Document;

/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section section, Document document) {
		super(MenuEntry.LIST_SECTIONS, section, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		if(_receiver.sizeSections() != 0) {
		    for(String s : _receiver.listSubSections())
			IO.println(s);
		}
	}
}
