package template;

import Constant.Keywords;
import Constant.Symbol;
import Constant.Variable;
import Event.VariableEvent;
import utils.linespace;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yjw on 16-10-28.
 */
public  class CLASS{

    private String PPP;
    private boolean ABSTRACT;
    private boolean Final;
    private String CLASSNAME;
    private boolean Extends;
    private String ExtendClass;
    private List<String> member;
    private List<String> method;
    private boolean Impletment;
    private String ImplementInterface;
    private String BaseSpace;

    public CLASS(){
        this.PPP=null;
        this.ABSTRACT=false;
        this.Final=false;
        this.CLASSNAME=null;
        this.Extends=false;
        this.ExtendClass=null;
        this.member=new LinkedList<String>();
        this.method=new LinkedList<String>();
        this.Impletment=false;
        this.ImplementInterface=null;
        this.BaseSpace="";
    }

    public CLASS(String PPP,String CLASSNAME){
        this();
        this.PPP=PPP;
        this.CLASSNAME=CLASSNAME;
    }

    public CLASS(String PPP,String CLASSNAME,List<String>member){
        this(PPP,CLASSNAME);
        this.member=member;
    }

    public CLASS(String PPP,String CLASSNAME,List<String>member,List<String>method){
        this(PPP,CLASSNAME,member);
        this.method=method;
    }

    public CLASS(String PPP,String CLASSNAME,List<String>member,List<String>method,boolean Extends,String ExtendsClassName){
        this(PPP,CLASSNAME,member,method);
        this.Extends=Extends;
        this.ExtendClass=ExtendsClassName;
    }

    public CLASS(boolean ABSTRACT,String PPP,String CLASSNAME,List<String>member,List<String>method){
        this(PPP,CLASSNAME,member,method);
        this.ABSTRACT=ABSTRACT;
    }

    public CLASS(boolean ABSTRACT,String PPP,String CLASSNAME,List<String>member,List<String>method,boolean Extends,String ExtendsClass){
        this(PPP,CLASSNAME,member,method,Extends,ExtendsClass);
        this.ABSTRACT=ABSTRACT;
    }

    public CLASS(String PPP,String CLASSNAME,List<String>member,List<String>method,boolean Extends,String ExtendsClassName,boolean Final){
        this(PPP,CLASSNAME,member,method,Extends,ExtendsClassName);
        this.Final=Final;
    }

    public CLASS(String PPP,String CLASSNAME,List<String>member,List<String>method,boolean Extends,String ExtendsClass,boolean ABSTRACT,boolean Final,boolean Implement,String ImplemetClass){
        this(PPP,CLASSNAME,member,method);
        this.Extends=Extends;
        this.ExtendClass=ExtendsClass;
        this.ABSTRACT=ABSTRACT;
        this.Final=Final;
        this.Impletment=Implement;
        this.ImplementInterface=ImplemetClass;
    }

    public void addMethod(FUNCTION f){
        method.add(f.getFunction());
    }

    public String getCLASS(){
        StringBuffer sb=new StringBuffer();
        sb.append(PPP+ linespace.SPACE);
        if(Final)
            sb.append(Keywords.FINAL+linespace.SPACE);
        if(ABSTRACT)
            sb.append(Keywords.ABSTRACT+linespace.SPACE);
        sb.append(Keywords.CLASS+linespace.SPACE);
        sb.append(CLASSNAME);
        if(Extends)
            sb.append(linespace.SPACE+Keywords.EXTENDS+linespace.SPACE+ExtendClass);
        if(Impletment)
            sb.append(linespace.SPACE+Keywords.IMPLEMENTS+linespace.SPACE+ImplementInterface);

        sb.append(Symbol.L_ANGLE_BRACKETS+linespace.NULL_LINE);

        for(String mem:member){
            sb.append(BaseSpace+linespace.FIGURE_SHIFT+mem+linespace.NULL_LINE);
            sb.append(BaseSpace+linespace.FIGURE_SHIFT+linespace.NULL_LINE);
        }

        sb.append(BaseSpace+linespace.NULL_LINE);
        for(String meth:method){
            sb.append(BaseSpace+meth+linespace.NULL_LINE);
            sb.append(BaseSpace+linespace.NULL_LINE);
        }

        sb.append(Symbol.R_ANGLE_BRACKETS);


        return sb.toString();
    }


    public static void main(String[] args){
        List<String> member=new LinkedList<String>();
        member.add(VariableEvent.createVariableWithPropery(Keywords.PUBLIC,Variable.STRING,"a",true,true,true));
        member.add(VariableEvent.createVariableWithPropery(Keywords.PUBLIC,Variable.INT,"b",true,false,true));

        List<String> method=new LinkedList<String>();
        List<String> list=new LinkedList<String>();
        list.add(VariableEvent.createVariable(Variable.STRING,"a"));
        list.add(VariableEvent.createVariable(Variable.INT,"b"));
        FUNCTION t=new FUNCTION(Keywords.PUBLIC, Variable.VOID,"myfunction",list,false,linespace.FIGURE_SHIFT,true,false);
        method.add(t.getFunction());
        list.add(VariableEvent.createVariable(Variable.BOOLEAN,"c"));
        FUNCTION st=new FUNCTION(Keywords.PRIVATE, Variable.INT,"myfunction2",list,false,linespace.FIGURE_SHIFT,true,true);
        method.add(st.getFunction());

        CLASS cl=new CLASS(Keywords.PUBLIC,"testclass",member,method,false,"",false,false,false,"");
        System.out.println(cl.getCLASS());
    }
}
