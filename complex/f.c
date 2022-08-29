# include "complex.h"

extern complex A, B, C, D, E, F;

complex* get_comp(char* S, int j)
{
	NON[0]=NO_VAL;
	NON[1]=NO_VAL;
	
	for(j=0; (j<strlen(S)) ;j++)
	{
		if(isspace(S[j]))
			continue;
		switch (S[j])
		{	case 'A':
				j++;
				return A;
			case 'B':
				j++;
				return B;
			case 'C':
				j++;
				return C;
			case 'D':
				j++;
				return D;
			case 'E':
				j++;
				return E;
			case 'F':
				j++;
				return F;
			case ',':
				printf("\nIllegal comma\n");
				return NON;
			default :
				printf("\nUndefined complex name\n");
				return NON;
		}
	}
	printf("\nMissing parameter\n");  /* if there is just white characters */
	return NON;
}

int is_non(complex C)
{
	if((C[0]==NO_VAL) && (C[1]==NO_VAL))
		return 1;
	else return 0;
}

float get_num(char* S, int j) /* ×œ×§×“× j */
{
	char num[MAXX] = {'0'};
	int i=0;
	for(j=0; (j<strlen(S));j++)
	{
		if(isspace(S[j]))
			continue;
		if(isdigit(S[j]))
		{
			i=j;
			while(isdigit(S[j]))
				j++;
			if(S[j]=='.')
			{
				j++;
				while(isdigit(S[j]))
					j++;
			}
			strncpy(num,&S[i],j-i);
			return (float)atof(num);
		}
		if((S[j]=='-')&&(isdigit(S[j+1])))
		{
			i=j;
			while(isdigit(S[j]))
				j++;
			if(S[j]=='.')
			{
				j++;
				while(isdigit(S[j]))
					j++;
			}
			strncpy(num,&S[i],j-i);
			return (float)atof(num);
		}
		printf("\nInvallid parameter - not a number\n");	
	}
	printf("\nMissing parameter\n");
	return (float)FAIL;
}

int get_comma(char* S, int j)
{
	for(j=0; (j<strlen(S));j++)
	{
		if(isspace(S[j]))
			continue;
		if(S[j]==',')
		{
			j++;
			return SUCCESS;
		}
		printf("\nMissing parameter\n");
		return FAIL;
	}
	printf("\nMissing parameter\n");
	return FAIL;
}

int end_command(char* S, int j)
{
	for(j=0; (j<strlen(S));j++)
	{
		if(isspace(S[j]))
			continue;
		printf("\nExtraneous text after end of command\n");
		return FAIL;
	}
	return SUCCESS;
}

void copy_comp(complex C, complex D)
{
	C[0] = D[0];
	C[1] = D[1];
}
