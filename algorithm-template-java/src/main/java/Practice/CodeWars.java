package Practice;

/**
 * Created by yjw on 16-10-12.
 */
public class CodeWars {
    public static int summation(int n) {
        return  n*(n+1)/2;
    }
    /*Take 2 strings s1 and s2 including only letters from ato z.
    Return a new sorted string, the longest possible,
    containing distinct letters, - each taken only once - coming from s1 or s2.*/
    public static String longest (String s1, String s2) {
        // your code
        int[] num=new int[26];
        for(int i=0;i<s1.length();i++){
            num[(int)s1.charAt(i)-97]=1;
        }
        for(int i=0;i<s2.length();i++){
            num[(int)s2.charAt(i)-97]=1;
        }

        StringBuffer str=new StringBuffer();
        for(int i=0;i<26;i++){
            if(num[i]>0){
                str.append((char)(i+97));
            }
        }
        return str.toString();
    }

    public static String longestBest (String s1, String s2) {
        String s = s1 + s2;
        return s.chars().distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
    /*********************************end**********************************************/

    /*You live in the city of Cartesia where all roads are laid out in a perfect grid.
     You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk.
     The city provides its citizens with a Walk Generating App on their phones -- everytime
      you press the button it sends you an array of one-letter strings representing
      directions to walk (eg. ['n', 's', 'w', 'e']). You know it takes you one minute to traverse one city block,
       so create a function that will return true if the walk the app gives you will take you exactly ten minutes
        (you don't want to be early or late!) and will, of course,
         return you to your starting point. Return false otherwise.*/
    public static boolean isValid(char[] walk) {
        // Insert brilliant code here
        int sum=0;
        if(walk.length==10)
        {
        for(int i=0;i<walk.length;i++){
            switch (walk[i]){
                case 'n':
                    sum+=1;
                    break;
                case 's':
                    sum-=1;
                    break;
                case 'w':
                    sum+=10;
                    break;
                case 'e':
                    sum-=10;
                    break;
            }
        }
            if(sum==0)
                return true;
            else
                return false;
        }else{
            return false;
        }


    }
    /*********************************end**********************************************/

    /*Your task is to construct a building which will be a pile of n cubes. The cube at the bottom will have a volume of n^3, the cube above will have volume of (n-1)^3 and so on until the top which will have a volume of 1^3.

You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?

The parameter of the function findNb (find_nb, find-nb) will be an integer m and you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m if such a n exists or -1 if there is no such n.*/
    public static long findNb(long m) {
        // your code
        long n=1;
        long sum=0;
        while(sum<m){
            sum=(n*(n-1)/2)*(n*(n-1)/2);
            n++;
        }
        if(sum==m)
            return n-1;
        else
            return -1;
    }
    /*********************************end**********************************************/

    public static void main(String[] args){
       // System.out.println(longestBest("loopingisfunbutdangerous", "lessdangerousthancoding"));
       // System.out.println(isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        System.out.println();
    }
}
