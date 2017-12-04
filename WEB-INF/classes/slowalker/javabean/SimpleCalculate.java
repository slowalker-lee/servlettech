package slowalker.javabean;

//import java.lang.Exception;

public class SimpleCalculate{
    private String first;
    private String operate;
    private String last;

    public String getFirst(){
        return this.first;
    }

    public String getOperate(){
        return this.operate;
    }

    public String getLast(){
        return this.last;
    }

    public void setFirst(String first){
        this.first = first;
    }

    public void setOperate(String operate){
        this.operate = operate;
    }

    public void setLast(String last){
        this.last = last;
    }

    public String getResult() throws Exception{
        double a = Double.parseDouble(first);
        double b = Double.parseDouble(last);
        
        if(operate.equals("+")){
            return (a + b) + "";
        }else if(operate.equals("-")){
            return (a - b) + "";
        }else if(operate.equals("*")){
            return (a * b) + "";
        }else if((operate.equals("/")) && (b != 0) ){
            return (a / b) + "";
        }else{
            throw new Exception("check agin");
        }
    }
}