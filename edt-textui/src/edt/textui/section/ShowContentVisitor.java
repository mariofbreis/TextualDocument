package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import java.io.IOException;
import edt.Section;
import edt.Paragraph;
import edt.Document;
import edt.Visitor;

public class ShowContentVisitor extends Visitor {
	
	public ShowContentVisitor(Section s) {
		visitSection(s);    
	}
	
	public ShowContentVisitor(Document d) {
		visitDocument(d);    
	}
	
	public ShowContentVisitor(Paragraph p) {
		visitParagraph(p);    
	}
    
	public void visitSection(Section s) {
		String uId = s.getUniqueId();
		String title = s.getTitle();
		if(uId == null) {
		    uId = "";
		}
		IO.println(Message.sectionIndexEntry(uId,title));
		for(Paragraph p: s.getParagraphs()) {
		    p.accept(this);
		}
		for(Section aux: s.getSections()) {
		    aux.accept(this);
		}
	}
	
	public void visitDocument(Document d) {
		IO.println("{" + d.getTitle() + "}");
		for(Paragraph p: d.getParagraphs()) {
		    p.accept(this);
		}
		for(Section aux: d.getSections()) {
		    aux.accept(this);
		}
	}
    
	public void visitParagraph(Paragraph p) {
		IO.println(p.getContent());    
	}
}
