# include "complex.h"

void read_comp(complex C, float a, float b)
{
	C[0] = a;
	C[1] = b;
}

void print_comp(complex C)
{
	printf("\n %f+(%f)i\n", C[0], C[1]);
}

complex* add_comp(complex C, complex D)
{
	read_comp(OUT,C[0]+D[0],C[1]+D[1]);
	return OUT;
}

complex* sub_comp(complex C, complex D)
{
	read_comp(OUT,C[0]-D[0],C[1]-D[1]);
	return OUT;
}

complex* mult_comp_real(complex C, float a)
{
	read_comp(OUT,C[0]*a,C[1]*a);
	return OUT;
}

complex* mult_comp_img(complex C, float a)
{
	read_comp(OUT,-C[1]*a,C[0]*a);
	return OUT;
}

complex* mult_comp_comp(complex C, complex D)
{
	read_comp(OUT,C[0]*D[0]-C[1]*D[1],C[0]*D[1]+C[1]*D[0]);
	return OUT;
}

float abs_comp(complex C)
{
	return sqrt(pow(C[0],2)+pow(C[1],2)); 
}
