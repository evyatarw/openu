/*******************************************************
 * The program gets binary tree and two nodes and then *
 * checks if the second is a descendant of the first   *
 *******************************************************/

#include <stdio.h>
#include <string.h>

#define N 6
#define T "TRUE"
#define F "FALSE"

typedef int adjmat[N][N];


char* path(adjmat adj, int v, int u);
void input(adjmat adj);

adjmat adj;
int u,v=0;

int main()
{
   input(adj);
   while((u!=(-1))&&(v!=(-1)))
   {
      printf("\n\nWe are ready to check the family relation between to nodes");
      printf("\nplease enter the index number of node in the binary three");
      printf(" (if you want to quit press twice -1)\n");
      scanf("%d",&u);
      printf("please enter the index number of node and we will check ");
      printf("if it's a descendant of the first node you entred\n");
      scanf("%d",&v);
      printf("The nodes you entered is: %d,%d", u, v);
      if(strcmp(path(adj,u,v),"TRUE")==0)
         printf("\nThe node %d is a descendant of the node %d.\n",v,u);
      else   printf("\nThe node %d is not a descendant of the node %d.\n",v,u);
   }
   return 0;
}

char* path(adjmat adj, int u, int v)
{
	int i;
	if(u==v)
		return T;
	for(i=0;i<N;i++)
	{
		if(adj[i][v]==1)
		{
			if(i==u)
				return T;
			if(strcmp(path(adj,u,i),"TRUE")==0)
				return T;
		}
	}
	return F;
}

void input(adjmat adj)
{
	int i,j = 0;
	printf("\n The size of the matrix is %dX%d.",N,N);
	printf("\n Please enter the matrix nodes (0 or 1) in a row");
	printf(" and after every node press \"Enter\".");
	printf("\n after you finish inserting a row,");
	printf(" continue at the beginning of the next row\n");
	
	for(i=0; i<N; i++)
	{
		for(j=0; j<N; j++)
			scanf("%1d", &adj[i][j]);
	}
	printf("\n Thank you for entering the whole matrix.\n");
	printf("\n The matrix is looks like this:\n");
	printf("   ");
	for(i=0; i<N; i++)   /* index line */
		printf(" %d", i);
	printf("\n   ");
	for(i=0; i<N; i++)   /* index seperator */
		printf("â€“â€“");
	for(i=0; i<N; i++) 
	{
		(i<10)?printf("\n "):printf("\n");
		printf("%d|",i);   /* index row */
		for(j=0; j<N; j++)
		{
			printf(" %d", adj[i][j]);   /* the matrix content */
			if(j>9)
				printf(" ");
		}
	}
}
