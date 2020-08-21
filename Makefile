# Makefile for Assignment 1
# 15/08/2020
# Bonke Gcobo





JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src

BINDIR=bin

DOCDIR=doc
	
$(BINDIR)/%.class:$(SRCDIR)/%.java

	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<


CLASSES=SerialProcessor.class DataThreadProcessor.class ParallelProcessor.class
	
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	@rm -f  $(BINDIR)/*.class
	@rm -f $(SRCDIR)/*.class
	@rm -f $(SRCDIR)/*.html
	@rm -f $(DOCDIR)/*.csv
	@rm -f $(DOCDIR)/*.txt
	
	


removedoc:
	rm -r ./doc

doc: removedoc
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java
		
# running apps
run:
	java -cp bin SerialProcessor
	

