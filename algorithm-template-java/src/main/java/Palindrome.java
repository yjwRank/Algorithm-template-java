/**
 * Created by yjw on 16-10-11.
 */
public class Palindrome {


    public int getMaxPalindrome(String str){
        int count=0;
        int max=0;
        int n=str.length();
        for(int i=0;i<n;i++){
            for(int j=0;(i-j)>=0&&(i+j)<n;j++){
                if(str.charAt(i-j)!=str.charAt(i+j))
                    break;
                count=j*2+1;
            }

            if(count>max){
                max=count;
            }
            for(int j=0;(i-j)>=0&&(i+j+1)<n;j++){
                if(str.charAt(i-j)!=str.charAt(i+j+1))
                    break;
                count=j*2+2;
            }
            if(count>max){
                max=count;
            }
        }
        return max;
    }


    public int getMaxPalindrome_Manacher(String str,String charactor){
        StringBuffer tmp=new StringBuffer();
        tmp.append("$");
        tmp.append(charactor);
        for(int i=0;i<str.length();i++){
            tmp.append(str.charAt(i));
            tmp.append(charactor);
        }

        String s=tmp.toString();
        int mx=0;
        int n=s.length();
        int[] p=new int[s.length()+2];
        int id=0;
        for(int i=1;i<s.length();i++){
            if(mx>i){
                p[i]=p[2*id-i]>mx-i?mx-i:p[2*id-i];
            }else{
                p[i]=1;
            }
            while((i+p[i]<n)&&(s.charAt(i+p[i])==s.charAt(i-p[i])))
                p[i]++;
            if(p[i]+i>mx){
                mx=p[i]+i;
                id=i;
            }
        }
        int max=0;
        for(int i=0;i<p.length;i++){
            if(max<p[i]){
                max=p[i];
            }
        }
        return max-1;
    }


    public static void  main(String[] args){
        Palindrome test=new Palindrome();
        System.out.println(test.getMaxPalindrome("abababa"));
        System.out.println(test.getMaxPalindrome_Manacher("abababa","#"));

    }
}
