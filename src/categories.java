/**
 * Created by Rachel
 **/
public class categories
{
   private String typeOfCategory, q1, q2, q3, q4 ;

   protected categories(String pType, String pQ1, String pQ2, String pQ3, String pQ4){
      typeOfCategory = pType ;
      q1 = pQ1 ;
      q2 = pQ2 ;
      q3 = pQ3 ;
      q4 = pQ4 ;
   }

   protected String getCategory(){
      return typeOfCategory ;
   }//get the type of category


   protected String getQ1(){
      return q1 ;
   }//get question 1

   protected String getQ2(){
      return q2 ;
   }//get q2

   protected String getQ3(){
      return q3 ;
   }//get q3

   protected String getQ4(){
      return q4 ;
   }//get q4

}//class