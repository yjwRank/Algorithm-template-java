package Event;

import Constant.Keywords;
import Constant.Symbol;
import Constant.Variable;
import utils.linespace;

import java.security.Key;

/**
 * Created by yjw on 16-10-28.
 */
public class VariableEvent {

    public static String createVariable(String var,String name){
        return var+ linespace.SPACE+name;
    }

    public static String createVariable(String var,String name,boolean smeicolon){
        if(smeicolon)
            return var+linespace.SPACE+name+ Symbol.SMEICOLON;
        else
            return createVariable(var,name);
    }

    public static String createVariable(String var,String name,String value){
        StringBuffer sb=new StringBuffer();
        sb.append(var+linespace.SPACE);
        sb.append(name+Symbol.EQUAL);
        if(var.equals(Variable.INT)){
            sb.append(value);
        }else if(var.equals(Variable.BOOLEAN)){
            sb.append(value);
        }else if(var.equals(Variable.BYTE)){
            sb.append(value);
        }else if(var.equals(Variable.CHAR)){
            sb.append(Symbol.QUOTATION+value+Symbol.QUOTATION);
        }else if(var.equals(Variable.DOUBLE)){
            sb.append(value+"d");
        }else if(var.equals(Variable.FLOAT)){
            sb.append(value+"f");
        }else if(var.equals(Variable.LONG)){
            sb.append(value+"L");
        }else if(var.equals(Variable.SHORT)){
            sb.append(value);
        }else if(var.equals(Variable.STRING)){
            sb.append(Symbol.D_QUOTATION+value+Symbol.D_QUOTATION);
        }
        sb.append(Symbol.SMEICOLON);
        return sb.toString();
    }

    public static String createVariableWithPropery(String PPP,String var,String name,boolean STATIC,boolean FINAL){
        StringBuffer sb=new StringBuffer();
        sb.append(PPP+linespace.SPACE);
        if(STATIC)
            sb.append(Keywords.STATIC+linespace.SPACE);
        if(FINAL)
            sb.append(Keywords.FINAL+linespace.SPACE);
        sb.append(createVariable(var,name));
        return sb.toString();
    }

    public static String createVariableWithPropery(String PPP,String var,String name,boolean STATIC,boolean FINAL,boolean smeicolon){
        if(smeicolon)
            return createVariableWithPropery(PPP,var,name,STATIC,FINAL)+Symbol.SMEICOLON;
        else
            return createVariableWithPropery(PPP,var,name,STATIC,FINAL);
    }

    public static String createVariableWithPropery(String PPP,String var,String name,String value,boolean STATIC,boolean FINAL){
        StringBuffer sb=new StringBuffer();
        sb.append(PPP+linespace.SPACE);
        if(STATIC)
            sb.append(Keywords.STATIC+linespace.SPACE);
        if(FINAL)
            sb.append(Keywords.FINAL+linespace.SPACE);
        sb.append(createVariable(var,name,value));
        return sb.toString();
    }


    public static void main(String[] args){
       /* System.out.println(createVariable(Variable.INT,"e","13132"));
        System.out.println(createVariable(Variable.BOOLEAN,"e","true"));
        System.out.println(createVariable(Variable.CHAR,"e","1"));
        System.out.println(createVariable(Variable.DOUBLE,"e","13132"));
        System.out.println(createVariable(Variable.FLOAT,"e","13132"));
        System.out.println(createVariable(Variable.LONG,"e","13132"));
        System.out.println(createVariable(Variable.SHORT,"e","13132"));
        System.out.println(createVariable(Variable.STRING,"e","13132"));*/
        System.out.println(createVariableWithPropery(Keywords.PUBLIC,Variable.INT,"e","123",true,false));
    }
}
