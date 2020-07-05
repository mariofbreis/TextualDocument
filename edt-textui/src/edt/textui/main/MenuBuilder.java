/** @version $Id: MenuBuilder.java,v 1.5 2015/11/29 06:07:50 ist170969 Exp $ */
package edt.textui.main;

import ist.po.ui.Command;
import ist.po.ui.Menu;
import edt.Manager;

public abstract class MenuBuilder {
  public static void menuFor(Manager manager) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new New(manager), //
            new Open(manager), //
            new Save(manager), //
            new ShowMetadata(manager), //
            new AddAuthor(manager), //
            new ShowIndex(manager), //
            new ShowTextElement(manager), //
            new Edit(manager), //
    });
    menu.open();
  }
}
