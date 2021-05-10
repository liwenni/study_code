package java0404;
public class Test {

    //给一个数，求该数最少需要多少步才能变成斐波那契数
        public static void find(int n){
            int[] F=new int[n];
            F[1]=1;
            F[0]=0;
            int i=0;
            if(i>1){
                F[i]=F[i-1]+F[i-2];
            }

            for(i=2;i<n;i++){
                if(i>1){
                    F[i]=F[i-1]+F[i-2];
                    if(F[i]>n){
                        break;
                    }
                }
            }
            int a=F[i]-n;
            int b=n-F[i-1];
            if(a<b){
                System.out.println(a);
            }else{
                System.out.println(b);
            }

        }

        public static void main(String[] args) {
            find(15);
        }
    }

