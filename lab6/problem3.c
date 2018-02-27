#include <stdio.h>

int main(){
	char string[20];
    int N;
   // printf("Enter a value: ");
	//scanf("%d", &N);
	//printf("N is  %d" , N);
	for(int i=0; i<N ; i++){
		scanf("%[^\n]%*c" , string);
	    //printf("%s" , string);
	}

	

	return 0;
}