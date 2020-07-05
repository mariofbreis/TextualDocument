package edt;

public abstract class Visitor {
    
    public abstract void visitSection(Section s);
    public abstract void visitDocument(Document d);
    public abstract void visitParagraph(Paragraph p);
}
