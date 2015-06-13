/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jubair.dealerbusinessmanagement;

/**
 *
 * @author Ferozeal
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sha1 {

    // Step1 : Initial some values ....
    private  String h0 = "01100111010001010010001100000001";
     private  String h1 = "11101111110011011010101110001001";
     private  String h2 = "10011000101110101101110011111110";
     private  String h3 = "00010000001100100101010001110110";
     private  String h4 = "11000011110100101110000111110000";
     
     // Initialize the value of A, B , C, D, E
     private  String A = h0;
     private  String B = h1;
     private  String C = h2;
     private  String D = h3;
     private  String E = h4;
     private  String F = "";
     private  String K = "";
     
     
     
    
     
     // Basic functionality of this function is to take a string and produced equivalent hash password
     public String createHashPassword(String text){ 
         
          List <Character> characterList = separateCharacter(text);
          
          List <Integer> integerList = characterEquivalentInteger(characterList) ;
          
          
          
          List <String> equivalentBinaryList = computeBinaryList(integerList);  
          
          
          
          String mergedBinaryString = mergeBinaryStringAndAdd1(equivalentBinaryList);
          
          
          
          int numberOfZero = calculateNumberOfZero(mergedBinaryString);
         
          
          String mergedBinaryString2nd = mergeBinaryStringWithZero(numberOfZero, mergedBinaryString);
          
          
          String finalMergerString = merge2ndBinaryStringMessageBinaryLength(mergedBinaryString.length()-1, mergedBinaryString2nd);
          
          List <String> chunkList = break_Each_chunk(finalMergerString);
          
         chunkList =  extend_chunkList_into_80_words(chunkList);
         
        
        
        
         
         calculateTheValueOfABCDE(chunkList);
         
         
        
         
          
         List<String> list =  addition();
         
         return createFinalHashPassword(list);
         
        
     }
     
     // This function take a binary string as input and produced equivalent hexadecimal numbering system output 
     private String binaryToHexaDecimalConversion(String binaryString){ 
    	 
    	 int numberOfZero = 0;
    	 if(binaryString.length() % 4  != 0 ){
    		 
    		 numberOfZero = 4 - (binaryString.length() % 4) ; 
    		 
    		 String helper = "";
    		 
    		 for(int i = 0; i < numberOfZero; i++)
    			 helper += '0';
    			 
    			 binaryString = helper + binaryString;
    			 
    			 
    		 
    	 }
    	 
    	 int count = 0;
    	 String temp = "", output = "";
    	 for(int i = 0; i < binaryString.length(); i++)	 {
    		 count++;
    		 temp += binaryString.charAt(i);
    		 
    		 if(count == 4){
    			 int equivalentDecimal = binaryStringToIntegerValue(temp);
    			 
    			 if(equivalentDecimal < 10)
    				 output += equivalentDecimal;
    			 
    			 else if(equivalentDecimal == 10)
    				 output += 'A';
    			 
    			 else if(equivalentDecimal == 11)
    				 output += 'B';
    			 
    			 else if(equivalentDecimal == 12)
    				 output += 'C';
    			 
    			 else if(equivalentDecimal == 13)
    				 output += 'D';
    			 
    			 else if(equivalentDecimal == 14)
    				 output += 'E';
    			 
    			 else if(equivalentDecimal == 15)
    				 output += 'F';
    			 
    			 else System.out.println("Invalid input Or Error !!!!!!!");
    			 
    			 count = 0;
    			 temp = "";
    		 }
    		 
    		 
    		 
    	 }
    	 
    	 return (output);
    	 
     }

     // This funtion take a final string list and produced hashedPassword
    private String createFinalHashPassword(List<String> list) {
		
    	String hashedPassword = "";
    	
    	for(String x : list)
    		hashedPassword += binaryToHexaDecimalConversion(x);
    	
    	
		return hashedPassword;
	}

	// This function take a string as input and produced a list that contains separate characters of the String 
    private List<Character> separateCharacter(String text) {
        
        List <Character> characterList = new ArrayList<>();
        
        for(int i = 0; i < text.length(); i++){ 
            characterList.add(text.charAt(i));
        }
        
        return characterList;
    }

    // This function take a character list as input and produced a list of equivalent ASCI values 
    private List<Integer> characterEquivalentInteger(List<Character> characterList) {
        List <Integer> integerList = new ArrayList<>();
        
        for(Character x : characterList){
            int temp = x;
            integerList.add(temp);
            
        }
                
        return integerList;
    }
     
     
    public String computeBinaryProdueNumberOfBit(int number, int bit){ 
        String temp ="";
        
        while(number != 0){ 
            
            temp += number%2;
            number = number/2;
            
        }
        
        String x = new StringBuilder(temp).reverse().toString();
        
        return  binaryBitGenerator(x, bit);
    }
     
    public String computeBinary(int number){ 
        String temp ="";
        
        while(number != 0){ 
            
            temp += number%2;
            number = number/2;
            
        }
        
        return new StringBuilder(temp).reverse().toString();
    }
     
     
/*
    public static void main(String[] args) {
        
        Sha1 s = new Sha1();
        Scanner stdio = new Scanner(System.in);
        
        
        System.out.println(s.createHashPassword("IIT"));
        
        
        
        
    }*/

    private List<String> computeBinaryList(List<Integer> integerList) {
        
        List <String> binaryList = new ArrayList<>();
        
        for(int x : integerList)
            binaryList.add(computeBinaryProdueNumberOfBit(x, 8));
       
        return binaryList;
        
    }

    // The funtionality of this function is to append all string of a list and add 1 at the last of append list and return the append list
    private String mergeBinaryStringAndAdd1(List<String> equivalentBinaryList) {

        String mergeString = "";
        
        for(String x : equivalentBinaryList)
            mergeString += x;
        
        
        mergeString += "1";
        
        
        return mergeString;
    }

    // This function calculate number of zero to merge 
    private int calculateNumberOfZero(String mergedBinaryString) {
       
        return (448 - mergedBinaryString.length());
    }

    // This function merge existing string with '0' character what the string needed to fill 448 ....it take two parameter as input one is message in binary string and other is number of '0' is required to append with the message string
    private String mergeBinaryStringWithZero(int numberOfZero, String mergedBinaryString) {
        for(int i = 0; i < numberOfZero; i++)
            mergedBinaryString += '0';
        
        
        return mergedBinaryString;
    }
    // First our goal is to convert the length of message to binary form then add number of zero before the binary string to calculate 64 bit .
    // Finally append this 64 bit with merged binary string
    private String merge2ndBinaryStringMessageBinaryLength(int length, String mergedBinaryString2nd) {
        String binaryString = computeBinary(length);
        int binaryStringsLength = binaryString.length();
        
        String temp = "";
        
        for(int i = 0; i < (64-binaryStringsLength); i++)
            temp += '0';
        
        temp += binaryString;
         mergedBinaryString2nd += temp;
        
        
        return mergedBinaryString2nd;
    }

    // It takes 512 bit string as input and separate the string into 16 part in each part contains consecutive 32 bit ....
    private List<String> break_Each_chunk(String finalMergerString) {

        List <String> chunkList = new ArrayList<>();
        
        
        int count = 0;
        int index = 1;
        String temp = "";
       for(int i = 0; i < finalMergerString.length(); i++  ){
           count++;
           temp += finalMergerString.charAt(i);
           
           if(count == 32){ 
               chunkList.add(temp);
               temp = "";
               count = 0;
               
           }
       }
        
        return chunkList;
    }

    private List<String> extend_chunkList_into_80_words(List<String> chunkList) {

        for(int i = 16; i < 80; i++){ 
            
            /*
            Now that we have our words selected we will start by performing what's known 
            as an 'XOR' or 'Exclusive OR' on them. In the end all four words will be XOR'ed together, 
            but you can think of it as first doing [i-3]XOR[i-8] then XOR'ing that by [i-14]
            and that again by [i-16]. XOR is one of a few simple logical operators.
            All it means is that you compare the two numbers bit by bit and
            if exactly one of them has the value '1', output a '1'.
            However, if both numbers have a '0' for that bit, or they both have a '1', output a '0'. 
            This works very similar to a logical 'OR' which will be used later. The only difference is that an 'OR' will return a '1' so long as either column has a '1' even if both of them do. 

            */
            String temp;
            String temp1 = chunkList.get(i - 3);
            String temp2 = chunkList.get(i - 8);
            String temp3 = chunkList.get(i - 14);
            String temp4 = chunkList.get(i - 16);
            
            temp = Xor_function(temp1, temp2);
            
            
             temp = Xor_function(temp3, temp);
            temp = Xor_function(temp, temp4);
            
            
            // Now we need to shift one bit left .....that's means delete first bit of temp and add '0' in the end
            Character ch = temp.charAt(0);
            temp = removeCharAt(temp, 0);
            temp += ch;
            
            chunkList.add(temp);
            
        }
        
      
        
        return chunkList;
    }

    // This function perform to find out result of Exclusive or of the given two parameter ....if length of these two parameter is not equal then it appends some zero before the string that consists less length between them until length is equal ....
    
    private String Xor_function(String temp1, String temp2) {
       
        String temporary1 = "", temporary2 = "", xorOutput = "" ;
        /*
        if(temp1.length() > temp2.length()){
            temporary1 = temp1;
            temporary2 =  beforeFillWithZero(temp2,temp1.length() );
            
        }
        
        else{
            temporary1 = temp2;
            temporary2 = beforeFillWithZero(temp2,temp1.length() );
        }
        */
        
        for(int i = 0; i < temp1.length(); i++){ 
            
            if(temp1.charAt(i) == temp2.charAt(i))
                xorOutput += '0';
            
            else xorOutput += '1';
        }
        return xorOutput;
        
        
    
    }

    // This method is perform to equal two string length by adding zero before the smaller string 
    private String beforeFillWithZero(String temp2, int length) {
        String t = "";
        for(int i = 0; i < (length- temp2.length()); i++)
            t += '0';
        
        return (t + temp2);
        
    }

    // This is used for delete a character from string
    private String removeCharAt(String temp, int pos) {
        return (temp.substring(0, pos) + temp.substring(pos+1));
    }

    // This function is used to calculate value of A , B, C, D, E that is needed to combine with ho, h1, h2, h3, h4 
    private void calculateTheValueOfABCDE(List<String> chunkList) {
        
        String temp = "";
        
        for(int i = 0; i < chunkList.size(); i++){
            
            
            
            if(i <= 19){
               // Perform (B AND C) or (!B AND D)
                
                F = Or_Function(And_Function(A, C), (  And_Function(Not_Function(B), D ) ));
                
            }
            
            else if(i <= 20 && i >= 39 ){ 
                // perform B XOR C XOR D
                F = Xor_function(Xor_function(B, C) ,D);
            }
            
            else if(i <= 40 && i >= 59){ 
                // Perform ((B AND C) OR (B AND D)) OR (C AND D)
                String temp1, temp2, temp3, temp4;
                temp1 = And_Function(B, C);
                temp2 = And_Function(B, D);
                temp3 = And_Function(C, D);
                
                F = Or_Function( Or_Function(temp1, temp2), temp3);
            }
            
            else{ 
                F = Xor_function(Xor_function(B, C) ,D);
            }
            
            binarySubtruction(F, chunkList.get(i));
            
            String temp2 = leftRoted(A, 4);
            int temp1 =  binaryStringToIntegerValue(temp) + binaryStringToIntegerValue(F) + binaryStringToIntegerValue(E) + binaryStringToIntegerValue(K);
            if(temp1 < 0)
                temp1 = (-1 * temp1);
            temp = computeBinaryProdueNumberOfBit(temp1, 32);
            
            E =D;
            D = C;
            C = leftRoted(B, 4);
            B = A;
            A = temp;
           
            
           
        }
    }
    
    public String And_Function(String temp1, String temp2){ 
        String temporary1 = "", temporary2 = "", andOutput = "" ;
        /*
        if(temp1.length() > temp2.length()){
            temporary1 = temp1;
            temporary2 =  beforeFillWithZero(temp2,temp1.length() );
            
        }
        
        else{
            temporary1 = temp2;
            temporary2 = beforeFillWithZero(temp2,temp1.length() );
        }
        */
        for(int i = 0; i < temp1.length(); i++){ 
            
            if(temp1.charAt(i) == '0' ||temp2.charAt(i) == '0' )
                andOutput += '0';
            
            else andOutput += '1';
                
        }
        
        return andOutput;
    }
    
    public String Not_Function(String temp){ 
        String notOutput = "";
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == '0')
                notOutput += '1';
            else notOutput += '0';
        }
        
        return notOutput;
    }
    
    public String Or_Function(String temp1, String temp2){ 
        String temporary1 = "", temporary2 = "", orOutput = "" ;
        /*
        if(temp1.length() > temp2.length()){
            temporary1 = temp1;
            temporary2 =  beforeFillWithZero(temp2,temp1.length() );
            
        }
        
        else{
            temporary1 = temp2;
            temporary2 = beforeFillWithZero(temp2,temp1.length() );
        }
        */
        
        for(int i = 0; i < temp1.length(); i++){ 
            
            if(temp1.charAt(i) == '1' ||temp2.charAt(i) == '1' )
                orOutput += '1';
            
            else orOutput += '0';
                
        }
        return  orOutput;
    }

    private void binarySubtruction(String F, String get) {

       int intValueOfF = binaryStringToIntegerValue(F);
       int intValueOFGet = binaryStringToIntegerValue(get);
       
       int subResult = (intValueOfF - intValueOFGet);
       
       if(subResult < 0)
           subResult = (-1 * subResult);
       
       K = computeBinaryProdueNumberOfBit(subResult, 32);
    }

    private int binaryStringToIntegerValue(String F) {
        int integerValue = 0 ;
        int length = F.length();
        
        
        for(int i = 0; i <length ; i++){ 
            int x = F.charAt(i) - '0';
            
            integerValue += x*Math.pow(2, (length - (i+1)));
        }
        
        return integerValue;
    
    }

    private String convertDecimalToBinary(int value) {
        String output = "";
        while(value != 0){ 
            output += value%2;
            value = value / 2;
        }
        
        return output;
    
    }

    private String leftRoted(String A, int numberOfRotation) {
        
        for(int i =0; i < numberOfRotation; i++){
            Character x = A.charAt(0);
            A = removeCharAt(A, 0);
            A += x;
            
        }
        
        return A;

    }

    private String binaryBitGenerator(String x, int bit) {
        
        int numberOfZeroRequired = (bit - x.length());
        String temp = "";
        for(int i = 0; i < numberOfZeroRequired; i++)
            temp += '0';
        
        return (temp + x);
    }

    // This addition function perform to 
    private List<String> addition() {
        
        List <String> myList = new ArrayList<>();
        myList.add( add_Function(h0, A) );
        myList.add(add_Function(h1, B));
        myList.add(add_Function(h2, C));
        myList.add(add_Function(h3, D));
        myList.add(add_Function(h4, E));
        
        return myList;
    }

    private String add_Function(String X, String Y) {
        int number1 = binaryStringToIntegerValue(X);
        int number2 = binaryStringToIntegerValue(Y);
        
        int number = number1 + number2;
        
        
        if(number < 0)
            number = number*-1;
        return (computeBinaryProdueNumberOfBit(number, 32));
    }
    
    
    

    
    
}
