class ExcelRow{

public String getRow(int numCode){
 StringBuilder excelRowString = new StringBuilder("");
 while(numCode > 0){
   int digit = (numCode%26) + 'A' - 1;
   excelRowString.insert(0,Character.toChars(digit));
   numCode = numCode/26;
 }
 return excelRowString.toString();
}

public int convertString(String input) {
  int num = 0;
  while(input != null){
  num += Math.pow(26,input.length()-1)*(input.charAt(0) - 'A' + 1);
  if (input.length() == 1)
     break;
   input = input.substring(1,input.length());
  }
return num;
}

public static void main (String[] args){
 ExcelRow excel = new ExcelRow();
 System.out.println("703:"+ excel.getRow(703));
 System.out.println("AAA:"+ excel.convertString("AAA"));
 
}
}
