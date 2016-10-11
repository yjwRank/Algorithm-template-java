import java.util.Scanner;
import java.util.Vector;

/**
 * Created by yjw on 16-10-11.
 */
public class KMP {


    public void getNext(int[] next,String str){
        int k=-1;
        int j=0;
        next[0]=-1;
        while(j<str.length()-1){
            if(k==-1||str.charAt(k)==str.charAt(j)){
                ++j;
                ++k;
                next[j]=k;
            }else{
                k=next[k];
            }
        }
    }

    public void getPath(int[] next,String ori,String part){
        int i=0;
        int j=0;
        while(i<ori.length()){
            if(j==-1||ori.charAt(i)==part.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }

            if(j==part.length()){
                System.out.println("loc:"+(i-j));
                j=0;
            }


        }
    }

    public static void main(String[] args){
       // Scanner scanner=new Scanner(System.in);
          String a="ABAC";
        int[] next=new int[8];

        KMP k=new KMP();
        k.getNext(next,a);
        k.getPath(next,"ABABACABAC",a);
       // System.out.println(next);
    }
}
