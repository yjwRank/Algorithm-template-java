package template;

import Constant.Keywords;
import Constant.Symbol;
import Constant.Variable;
import Event.VariableEvent;
import utils.linespace;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yjw on 16-10-31.
 */
public class FUNCTION {
    private String PPP;
    private boolean ABSTRACT;
    private boolean STATIC;
    private boolean FINAL;
    private String RETURN;
    private String functionName;
    private List<String> parameter=new LinkedList<String>();
    private boolean Constructor;
    private String BaseSpace;
    public FUNCTION(){
        parameter=new LinkedList<String>();
    }

    public FUNCTION(String RETURN,String functionName){
        this.PPP=null;
        this.ABSTRACT=false;
        this.STATIC=false;
        this.FINAL=false;
        this.RETURN=RETURN;
        this.functionName=functionName;
        this.parameter=new LinkedList<String>();
        this.Constructor=false;
        this.BaseSpace="";
    }

    public FUNCTION(String PPP,String RETURN,String functionName){
        this(RETURN,functionName);
        this.PPP=PPP;
    }

    public FUNCTION(String PPP,String RETURN,String functionName,List<String> parameter){
        this(PPP,RETURN,functionName);
        this.parameter=parameter;
    }

    public FUNCTION(String PPP,String RETURN,String functionName,List<String> parameter,boolean Constructor){
        this(PPP,RETURN,functionName,parameter);
        this.Constructor=Constructor;
    }
    public FUNCTION(String PPP,String RETURN,String functionName,List<String> parameter,boolean Constructor,String BaseSpace){
        this(PPP,RETURN,functionName,parameter,Constructor);
        this.BaseSpace=BaseSpace;
    }

    public FUNCTION(String PPP,String RETURN,String functionName,List<String> parameter,boolean Constructor,String BaseSpace,boolean ABSTRACT){
        this(PPP,RETURN,functionName,parameter,Constructor,BaseSpace);
        this.ABSTRACT=ABSTRACT;
    }

    public FUNCTION(String PPP,String RETURN,String functionName,List<String> parameter,boolean Constructor,String BaseSpace,boolean ABSTRACT,boolean STATIC){
        this(PPP,RETURN,functionName,parameter,Constructor,BaseSpace,ABSTRACT);
        this.STATIC=STATIC;

    }
    public FUNCTION(String PPP,String RETURN,String functionName,List<String> parameter,boolean Constructor,String BaseSpace,boolean ABSTRACT,boolean STATIC,boolean FINAL){
        this(PPP,RETURN,functionName,parameter,Constructor,BaseSpace,ABSTRACT,STATIC);
        this.FINAL=FINAL;
    }


    public FUNCTION(String PPP,String RETURN,String functionName,List<String> parameter,String BaseSpace){
        this.PPP=PPP;
        this.RETURN=RETURN;
        this.functionName=functionName;
        this.parameter=parameter;
        this.Constructor=true;
        this.BaseSpace=BaseSpace;
    }

    public void addParameter(String param){
        this.parameter.add(param);
    }


    public String getFunction(){
        StringBuffer sb=new StringBuffer();
        if(PPP!=null)
            sb.append(BaseSpace+PPP+linespace.SPACE);
        if(STATIC)
            sb.append(Keywords.STATIC+linespace.SPACE);
        if(FINAL)
            sb.append(Keywords.FINAL+linespace.SPACE);
        if(ABSTRACT)
            sb.append(Keywords.ABSTRACT+linespace.SPACE);
        if(!Constructor)
            sb.append(RETURN+linespace.SPACE);
        sb.append(functionName);
        sb.append(Symbol.L_CURVES);
        if(parameter.size()>0){
            for(int i=0;i<parameter.size();i++){
                if(i==0)
                    sb.append(parameter.get(i)+Symbol.COMMA);
                else
                    sb.append(parameter.get(i));
            }
        }
        sb.append(Symbol.R_CURVES);
        sb.append(Symbol.L_ANGLE_BRACKETS);
        sb.append(BaseSpace+linespace.NULL_LINE);
        sb.append(BaseSpace+linespace.FIGURE_SHIFT+linespace.TODO);
        sb.append(BaseSpace+linespace.NULL_LINE);
        sb.append(BaseSpace+linespace.FIGURE_SHIFT+Keywords.RETURN+linespace.SPACE+Keywords.NULL+Symbol.SMEICOLON+linespace.NULL_LINE);
        sb.append(BaseSpace+Symbol.R_ANGLE_BRACKETS);

        return sb.toString();
    }
    public static void main(String[] args){
        List<String> list=new LinkedList<String>();
        list.add(VariableEvent.createVariable(Variable.STRING,"a"));
        list.add(VariableEvent.createVariable(Variable.INT,"b"));
        FUNCTION t=new FUNCTION(Keywords.PUBLIC, Variable.VOID,"myfunction",list,false,"  ",true,false);
        System.out.println(t.getFunction());
    }
}
