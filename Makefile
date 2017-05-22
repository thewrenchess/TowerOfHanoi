JC = javac

JFLAG = -g

JCM = java

CLASSPATH = -cp src

.SUFFIXES: .java .class

SOURCE =	src/Game.java \
			src/TowerOfHanoi.java \
			src/Towers.java

CLASS =	src/Game.class \
		src/TowerOfHanoi.class \
		src/Towers.class

MAIN = TowerOfHanoi

.java.class:
	@$(JC) $(JFLAG) $(SOURCE)
	@echo "-----------------\nmake successful!\n-----------------"

default: .java.class

run:
	@$(JCM) $(CLASSPATH) $(MAIN)

clean:
	@$(RM) $(CLASS)
	@echo "-----------------\nclean successful!\n-----------------"

re: clean default
