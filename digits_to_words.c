/**************************************************************************************
 *  The program convert numbers at digits to numbers at words.                        *
 *  for axample 45 converts to "forty five".                                          *
 *                                                                                    *
 *  the user can decide: if the user don't enter arguments at the command line the    *
 *  program get numbers from the keyboard and print the numbers (at words) on the     *
 *  screen. the user can enter 1 argument at the command line and then the program    *
 *  get numbers from the the file entered and print the numbers (at words) on the     *
 *  screen. the user can enter 2 arguments at the command line and then the program   *
 *  get numbers from the file (the first argument) entered and print the numbers (at  *
 *  words) in the file (the second argument) entered.                                 *
 *                                                                                    *
 *  the program check the input character character goes through and recognize if it  *
 *  white-space or number (one-digit number or two-digit number) and print the number.*
 *                                                                                    *
 *  The program guess the input includes white-space and digit characters only.       *
 **************************************************************************************/

#include "mmn23.h"


int main(int argc, char *argv[])
{
	if (argc>3)
	{
		fprintf(stderr,"\n You can't write more then 2 files in command line\n");
		exit(0); 
	}
	if (argc==1)
		print_num(NO_FILE,NO_FILE);
	if (argc==2)
		print_num(argv[1],NO_FILE);
	if (argc==3)
		print_num(argv[1],argv[2]);
		
	return 0;
}

void print_num(char *infile, char *outfile)
{
	FILE *INF = fopen(infile,"r");    /* input file */
	FILE *OUTF = fopen(outfile,"w");  /* output file */
	int i;
	char input[MAX_LENGTH] = {' '};

	if(OUTF == NULL)  /* check if the files is open */
	{
		fprintf(stderr,"\n Can't open file \"%s\".\n",outfile);
		exit(0);
	}
	if(INF == NULL)
	{
		fprintf(stderr,"\n Can't open file \"%s\".\n",infile);
		exit(0);
	}

	if(strcmp(infile, NO_FILE) == 0) /* we didn't got input file */
		INF = stdin;
	if(strcmp(outfile, NO_FILE) == 0)/* we didn't got output file */
		OUTF = stdout;

	do
	{
		initialize_array(input,MAX_LENGTH); /* initialize array */
		if(INF==stdin)
			fprintf(OUTF,"\n");
		fgets(input,MAX_LENGTH,INF);

		for (i=0; (i<MAX_LENGTH)&&(input[i]!=EOF); i++)
		{
			if(isspace(input[i]))
			continue;
			if((input[i+1]!=EOF)&&(isdigit(input[i+1]))) /* the number larger then 9 */
			{
				switch (input[i])
				{	case '0':	continue;
					case '2':	fprintf(OUTF," twenty"); 
						break;
					case '3':	fprintf(OUTF," thirty");
						break;
					case '4':	fprintf(OUTF," forty");
						break;
					case '5':	fprintf(OUTF," fifty");
						break;
					case '6':	fprintf(OUTF," sixty");
						break;
					case '7':	fprintf(OUTF," seventy");
						break;
					case '8':	fprintf(OUTF," eighty");
						break;
					case '9':	fprintf(OUTF," ninety");
						break;
					case '1':	switch (input[i+1])
						{	case '0':	fprintf(OUTF," ten \n");
								i++;
								break;
							case '1':	fprintf(OUTF," eleven \n");
								i++;
								break;
							case '2':	fprintf(OUTF," twelve \n");
								i++;
								break;
							case '3':	fprintf(OUTF," thirteen \n");
								i++;
								break;
							case '4':	fprintf(OUTF," forteen \n");
								i++;
								break;
							case '5':	fprintf(OUTF," fifteen \n");
								i++;
								break;
							case '6':	fprintf(OUTF," sixteen \n");
								i++;
								break;
							case '7':	fprintf(OUTF," seventeen \n");
								i++;
								break;
							case '8':	fprintf(OUTF," eighteen \n");
								i++;
								break;
							case '9':	fprintf(OUTF," nineteen \n");
								i++;
								break;
							default:	continue;
						}
						break;
					default:	continue;
				}
				if(input[i+1]=='0') /* do not print "zero" wen there is tens digit */
				{
					fprintf(OUTF,"\n");
					i++;
				}
				continue;
			} /* end of if the number is larger then 9 */
			switch (input[i])
			{	case '0':	fprintf(OUTF," zero \n");
					break;
				case '1':	fprintf(OUTF," one \n");
					break;
				case '2':	fprintf(OUTF," two \n");
					break;
				case '3':	fprintf(OUTF," three \n");
					break;
				case '4':	fprintf(OUTF," for \n");
					break;
				case '5':	fprintf(OUTF," five \n");
					break;
				case '6':	fprintf(OUTF," six \n");
					break;
				case '7':	fprintf(OUTF," seven \n");
					break;
				case '8':	fprintf(OUTF," eight \n");
					break;
				case '9':	fprintf(OUTF," nine \n");
					break;
				default:	continue;
			}
		} /* end of for */
	} /* end of do */
	while(!(feof(INF)));  
}

void initialize_array(char *arr, int size)
{
	int i;
	for(i=0; i<size; i++)
		arr[i]=' ';
}
