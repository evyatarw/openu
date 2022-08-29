/* The program calculate arithmetic actions at complecs numbers.*/
/* we criate a new data type for complex number. it contains the real number and the coefficient of i. */
/* the program get from the user command and execute the arithmetic action and print the result. then the program get another command from the user until the user enter "stop".*/ 



# include "complex.h"

complex OUT;
complex NON = {NO_VAL,NO_VAL};
complex A, B, C, D, E, F, X, Y = {0,0};

int main()
{
	float a,b = 0.0;
	char buff[MAXX] = "0";
	int i,j;
	int loop = CONTINUE;

	printf("\nWelcome to the complex number calculator.");
	printf("\nThe calculator contain 6 complex numbers you can fill and use:");
	printf("\n  A, B, C, D, E, F.");
	printf("\nPlease enter command of the arithmetic action at the right sintax:");
	printf("\n  print_comp A \n  read_comp A, x, y \n  add_comp A, B \n  sub_comp A, B ");
	printf("\n  mult_comp_real A, x \n  mult_comp_img A, x \n  mult_comp_comp A, B \n  abs_comp A\n");
	printf("  (A, B - present complex variable.  x, y - present real numbers)");
	printf("\n  to stop the prog press stop.\n"); 

	while(loop==CONTINUE)
	{
		printf("Enter your command\n");
		fgets(buff,MAXX,stdin);
		printf("%s",buff);     /* Input line printing */
		for(i=0; (i<MAXX); i++)  /* Input analysis */
		{
			if(isspace(buff[i]))
				continue;
			if(strncmp(buff+i,"read_comp ",10)==0)               /* identified command */
			{
				i+=10;						                  /* Promote after command */
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;
				if(get_comma(buff+i,j)==FAIL)                         /* check comma */
					break;    
				i+=j;
				if(get_num(buff+i,j)==FAIL) 
					break; 
				a=get_num(buff+i,j);                                   /* get param */
				i+=j;
				if(get_comma(buff+i,j)==FAIL)                         /* check comma */
					break;    
				i+=j;
				if(get_num(buff+i,j)==FAIL) 
					break; 
				b=get_num(buff+i,j);                                   /* get param */
				i+=j;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				read_comp(X,a,b);                                   /* execute command */
			}
			if(strncmp(buff+i,"print_comp ",11)==0)              /* identified command */
			{
				i+=11;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				print_comp(X);                                      /* execute command */
			}
			if(strncmp(buff+i,"add_comp ",9)==0)                /* identified command */
			{ 
				i+=9;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;
				if(get_comma(buff+i,j)==FAIL)                         /* check comma */
					break;    
				i+=j;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(Y,get_comp(buff+i,j));
				i+=j;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				print_comp(add_comp(X,Y));                           /* execute command */
			}
			if(strncmp(buff+i,"sub_comp ",9)==0)                /* identified command */
			{  
				i+=9;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;
				if(get_comma(buff+i,j)==FAIL)                         /* check comma */
					break;    
				i+=j;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(Y,get_comp(buff+i,j));
				i+=j;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				print_comp(sub_comp(X,Y));                           /* execute command */
			}
			if(strncmp(buff+i,"mult_comp_real ",15)==0)          /* identified command */
			{ 
				i+=15;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;
				if(get_comma(buff+i,j)==FAIL)                         /* check comma */
					break;    
				i+=j;
				if(get_num(buff+i,j)==FAIL) 
					break; 
				a=get_num(buff+i,j);                                   /* get param */
				i+=j;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				print_comp(mult_comp_real(X,a));                     /* execute command */
			}
			if(strncmp(buff+i,"mult_comp_img ",14)==0)           /* identified command */
			{ 
				i+=14;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;
				if(get_comma(buff+i,j)==FAIL)                         /* check comma */
					break;    
				i+=j;
				if(get_num(buff+i,j)==FAIL) 
					break; 
				a=get_num(buff+i,j);                                   /* get param */
				i+=j;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				print_comp(mult_comp_img(X,a));                      /* execute command */
			}
			if(strncmp(buff+i,"mult_comp_comp ",15)==0)          /* identified command */
			{
				i+=15;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;
				if(get_comma(buff+i,j)==FAIL)                         /* check comma */
					break;    
				i+=j;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(Y,get_comp(buff+i,j));
				i+=j;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				print_comp(mult_comp_comp(X,Y));                     /* execute command */
			}
			if(strncmp(buff+i,"abs_comp ",8)==0)                 /* identified command */
			{  
				i+=8;
				if(is_non(get_comp(buff+i,j)))                         /* get param */
					break;
				copy_comp(X,get_comp(buff+i,j));
				i+=j;  
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				printf("\n%f\n",abs_comp(X));                        /* execute command */
			}
			if(strncmp(buff+i,"stop",4)==0)                      /* identified command */
			{
				i+=4;
				if(end_command(buff+i,j)==FAIL)                 /* check end of command */
					break;
				loop = STOP;                                   /* end of the program */
				break;
			}
			if(buff[i]==EOF)
			{
				printf("\nThe command \"stop\" missing. next time do not forget to ");
				printf("end with \"stop\"\n");
				loop = STOP;                                   /* end of the program */
				break;
			}
			printf("\nUndefined command name\n");
			break;
		}
	}
	printf("\nEnd of the program\n");
	return 0;
}
