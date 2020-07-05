/** @version $Id: TextEditor.java,v 1.4 2015/11/24 20:23:29 ist170969 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;
import java.io.IOException;
import edt.Manager;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		Manager manager = new Manager();
		
		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
		    try{manager.parseInputFile(datafile);} catch (Exception e) {e.printStackTrace();}
		}
		edt.textui.main.MenuBuilder.menuFor(manager);
		IO.closeDown();
	}
}
