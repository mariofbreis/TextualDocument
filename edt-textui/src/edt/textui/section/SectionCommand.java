/** @version $Id: SectionCommand.java,v 1.3 2015/11/25 19:23:17 ist170969 Exp $ */
package edt.textui.section;

import ist.po.ui.Command;
import edt.Section;
import edt.Document;

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {

	Document _document;
  
	public SectionCommand(String title, Section section, Document document) {
		super(title, section);
		_document = document;
	}
}
