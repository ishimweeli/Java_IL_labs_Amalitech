package week1_IL_labs;

public class DataValidation {
  public static <T> boolean validateData(T data){
    if(data instanceof Integer){
        int value=(Integer) data;
        return value>=0 && value<=10;
    }else if(data instanceof String){
        String str=(String) data;
        return str.length() ==1 && str.matches("a-dA-D");
    }else if(data instanceof Boolean){
        return true;
    }
    return false;
  }

    public static void main(String[] args) {
        int validInt=5;
        Boolean vaildBoolean=true;

System.out.println(validateData(validInt));
System.out.println(validateData(vaildBoolean));
    }

}


