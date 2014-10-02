#include <stdio.h>

int main()
{
	char orig[]  ="abcdefghijklmnop";
	char *c = orig;
	char *cur = c;
	//char *orig = c;

	while(*cur++);

	cur--;
	char *tmp = cur;
	cur--;

	while(cur>c) {
		//printf("swap %c and %c\n",*c,*cur);
		*tmp = *c;
		*c=*cur;
		*cur=*tmp;
		c++;cur--;
	}

	*tmp = 0;

	puts(orig);
}
