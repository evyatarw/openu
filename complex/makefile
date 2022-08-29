mmn22:	mycomp.o complex.o f.o complex.h
	gcc -g -ansi -Wall -pedantic mycomp.o complex.o f.o complex.h -o mmn22 -lm
mycomp.o:	mycomp.c complex.h
	gcc -c -ansi -Wall -pedantic mycomp.c complex.h -lm
complex.o:	complex.c complex.h
	gcc -c -ansi -Wall -pedantic complex.c complex.h -lm
f.o:	f.c complex.h
	gcc -c -ansi -Wall -pedantic f.c complex.h -lm
