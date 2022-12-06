import java.util.*;
import java.io.*;
public class TDweight
{
   public static List<Integer> getDweight(List<Integer>l,int sum)
   {
       List t=new ArrayList();
       for(int i=0;i<l.size();i++)
       {
             float f=(float)l.get(i)/sum;
             t.add(f);

       }
       return t;

   }
   public static void getTweight(List<Integer>l,List<Integer>l2)
   {
            List D1=new ArrayList();
            List D2=new ArrayList();
            int sum=0;
            for(int i=0;i<l.size();i++)
            {
                  sum=(int)l.get(i)+(int)l2.get(i);
                  float f=(float)((int)l.get(i))/sum;
                  float f1=(float)((int)l2.get(i))/sum;
                  D1.add(f);
                  D2.add(f1);
                      
            }
            //System.out.println("Tweight -i1:\t"+D1);
            //System.out.println("Tweight  -i2:\t"+D2);

   }
   public static void main(String args[])
   {
       try{

        

       Scanner sc=new Scanner(new File("C:\\Users\\Manoj\\OneDrive\\Desktop\\DMLab\\AFTER DIWALI\\4TDweight\\tdweigth.csv"));
       List<String> i0 = new ArrayList<>();
       List<Integer> i1=new ArrayList();
       List<Integer>i2=new ArrayList();
       List<String>l=new ArrayList();
       int i=0;
       int sumi1=0;
       int sumi2=0;
       while(sc.hasNext()) 
       {
            if(i==0)
            {

                   l.add(sc.nextLine());
                   i++;
                   continue;
                   
            } 
            String p=sc.nextLine();
            l.add(p);
            String s[]=(p).split("\\,");
            
            i0.add(s[0]);
            i1.add(Integer.parseInt(s[1]));
            i2.add(Integer.parseInt(s[2]));
       }  
       for(i=0;i<l.size();i++)
       {
           System.out.println(l.get(i)); 
       }

       System.out.println();
       int sum=i1.stream().mapToInt(Integer::intValue).sum();
       System.out.println(i0.get(0)+" : "+sum);
        int sum1=i2.stream().mapToInt(Integer::intValue).sum();
       System.out.println(i0.get(1)+" : "+sum1);
       List Dweighti1=getDweight(i1,sum);
       List Dweighti2=getDweight(i2,sum1);
       
       System.out.println("Dweight -i1:\t"+Dweighti1);
       System.out.println("Dweight i2:\t"+Dweighti2);
       
       getTweight(i1,i2);

      
       }catch(Exception e){}

 
   }
   

}
