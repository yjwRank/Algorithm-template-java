package sentence;

import Constant.Symbol;

/**
 * Created by yjw on 16-10-28.
 */

public class SystemOutPrintLine {

    public static String System_out_printlen(String str){
        return "System.out.println"+ Symbol.L_CURVES+Symbol.D_QUOTATION+str+Symbol.D_QUOTATION+Symbol.R_CURVES+Symbol.SMEICOLON;
    }


    public static String System_out_printlen(String str,boolean var){
        if(var){
            return "System.out.println"+ Symbol.L_CURVES+str+Symbol.R_CURVES+Symbol.SMEICOLON;
        }else{
            return "System.out.println"+ Symbol.L_CURVES+Symbol.D_QUOTATION+str+Symbol.D_QUOTATION+Symbol.R_CURVES+Symbol.SMEICOLON;
        }
    }

    public static void main(String[] args){
        String str=System_out_printlen("hello",false);
        System.out.println(str);
    }
}
