# Textual Document
 Project for the Object-Oriented Programming course

The aim of the project was to create an application that allows us to view and change a textual document. The application keeps the name of the document where the document is to be saved on disk. The application only edits one document at a time, although it can change documents.

# Structure of a Document

- A document has an internal structure, corresponding to the organization of its content, being possible to change this content.
- Documents have a title, one or more authors, and a set of paragraphs and sections. The size of a document is the number of characters present in the document, with all paragraphs and titles of all sections of the document being counted.
- Each author has a name and a contact (email).
- The sections have a title, a sequence of paragraphs and a sequence of subsections (both potentially empty). Paragraphs and subsections are identified implicitly in each section by their order number (both starting at 0). Each paragraph (contextually related sequences of phrases) or section can have a unique identifier in the context of the document (string).
- It is possible to add / remove sections and paragraphs to / from documents and sections. It is possible to change the content of a paragraph.

# Main menu

The menu actions, listed in edt.textui.main.MenuEntry, allows to manage the saving of the application status, as well as operate on the current document: Create, Open, Save, List metadata, Add author, List sections, Show element of text and Edit. The edt.textui.main.Message class defines the methods for generating dialog messages.

# Edit Menu

This menu allows to perform operations on a document. The complete list is as follows: Change title, List sections, Show content, Go to section, Insert section, Name section, Remove section, Insert paragraph, Name paragraph, Change paragraph, Remove paragraph.

# Setup

- Compile Project:
export JAVADIR=/usr/share/java
export PROJDIR=/home/oops/Desktop/project
export CLASSPATH=$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-core/edt-core.jar:$PROJDIR/edt-textui/edt-textui.jar
make

- Run Project:
java edt.textui.TextEditor
