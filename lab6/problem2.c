#include <stdio.h>
#include <string.h>



void print(char string[5] , int i){
		if(i == strlen(string)){
			return;
		}
		if(string[i] == '?'){
			string[i] = '0';
			print(string,i+1);
			string[i] = '1';
			print(string,i+1);
		}
		else{
			print(string,i+1);
		}
}



int main(void){

	printf("Enter String :");
	char string[5];
	scanf("%s" , string);

	int n=0;
	int z ;
	for(z=0; string[z] != '\0' ; z++){
		n++;
		//print(string,0);
	}
	print(string,0);


}