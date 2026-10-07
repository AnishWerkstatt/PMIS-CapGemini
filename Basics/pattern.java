/* 1. *****
      *****
      *****
      *****
 */
/*class solidBox{
    public static void main(String[] args){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }

    }
} */

/*
2. 
* * * * *
*       *
*       *
* * * * *

*/
/*package Basics;
class hollowBox{
    public static void main(String [] args){

        int n = 4;
        int m = 5;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            } System.out.println();
        }
    }
}
    */

/*
3. *
   **
   ***
   ****
*/
/*package Basics;
class triangle{
    public static void main(String[] args){
        int n = 4;
        for(int i = 0; i < n; i++){
            for (int j = 0; j <= i ; j++){
                System.out.print(" * ");
            } System.out.println();

        }
    }
} */

/*
4. ****
   ***
   **
   *
*/
/*package Basics;
class triangle{
    public static void main(String[] args){
        int n = 4;
        for(int i = 0; i < n; i++){
            for (int j = n; j > i ; j--){
                System.out.print(" * ");
            } System.out.println();

        }
    }
}
*/

/*
5.     *
      **
     ***
    ****
*/
/*package Basics;
class triangle{
    public static void main(String[] args){
        int n = 4;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();

        }
        
    }
}
*/

/*
6.
1
12
123
1234
12345
*/

/*package Basics;
class triangle{
    public static void main(String[] args){
        int n = 5;
        for(int i = 1; i<=n;i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);

            } System.out.println();
        }
        
    }
}*/


/*
7.
12345
1234
123
12
1
*/
/*package Basics;
class triangle{
    public static void main(String[] args){
        int n = 5;
        for(int i = 1; i<=n;i++){
            for(int j = 1; j <= n - i + 1; j++){
                System.out.print(j);

            } System.out.println();
        }
        
    }
}
    
*/

/*
8.
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

*/
/*package Basics;
class triangle{
    public static void main(String[] args){
        int n = 5;
        int number = 1;
        for(int i = 1; i<=n;i++){
            for(int j = 1; j <= i; j++){
                System.out.print(number + " ");
                number ++;

            } System.out.println();
        }
        
    }
}
    
*/

/*
9.
1
01
101
0101
10101
*/
package Basics;
class triangle{
    public static void main(String[] args){
        int n = 5;
        for(int i = 1; i<=n;i++){
            for(int j = 1; j <= i; j++){
                if((i + j) % 2 == 0){
                    System.out.print(1 + " ");
                }
                else{
                    System.out.print(0 + " ");
                }

            } System.out.println();
        }
        
    }
}