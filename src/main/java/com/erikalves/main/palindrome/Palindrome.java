package com.erikalves.main.palindrome;



import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Palindrome {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Palindrome.class);

    public boolean isPalindrome(String text){
        LOGGER.debug(" ----->  text {}",text );

        if(!isValidInSize(text)){
            LOGGER.debug(" >>>>  Not valid in size <<<<");
            return false;
        }

        text = trimText(text);

        if(text.length() %2 ==0){
            //it's even number
            LOGGER.debug("it's even number ");
            finalCheck(mapLetters(charfyText(text)),false);
        }
        else{
            //it's odd number
            LOGGER.debug("it's odd number ");
            finalCheck(mapLetters(charfyText(text)),true);
        }
        return true;
    }

    private boolean finalCheck(Map <String,Integer> map, boolean isOdd){

       boolean isPalindrome= true;
       boolean isOddValueAlreadyProcessed=false;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            LOGGER.debug("Item :  {} Count {} ",  entry.getKey(), entry.getValue());

            if (entry.getValue() ==1){
                if(isOdd && !isOddValueAlreadyProcessed){
                    isOddValueAlreadyProcessed = true;
                    continue;
                }
                else{
                    isPalindrome = false;
                    break;
                }

            }
            else{

                if(entry.getValue() % 2 == 0){
                    continue;
                }
                else{
                   isPalindrome = false;
                    break;
                }

            }



        }


            return isPalindrome;
    }


    private boolean isValidInSize(String text){

        if(null== text || text.length()<2){
            return false;
        }

        return true;
    }

    private String trimText (String text){

        return text.replaceAll("\\s+","");

    }

    private char[] charfyText(String text){

        char [] chtext = text.toCharArray();
        LOGGER.debug("------> {} ",String.valueOf(chtext));
        return chtext;
    }

    private Map mapLetters(char[] chtext){

        Map <String,Integer> map = new HashMap<>();
        String s;
        int count;
        for(char c : chtext){
           s = String.valueOf(c);
            if(map.containsKey(s)){
                count = map.get(s);
                count++;
                map.put(s,count);
            }
            else{
                map.put(s,1);
            }
        }
        return map;
    }

}
