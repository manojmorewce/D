import java.io.*;
import java.util.*;
public class  box
{
    public static float getMedianeven(List<Integer>l)
    {
          float median;
          int x=l.size()/2;
          int t=(int)l.get(x);  
          int t1=(int)l.get(x-1);
          median=(float)(t+t1)/2;
          return median;
    }
    public static int  getMedianOdd(List<Integer>l)
    {
            int r=(int)l.get(l.size()/2);
            return r;

    }
    public static void main(String  args[])
    {
          try
          {

            

             Scanner sc=new Scanner(new File("C:\\Users\\Manoj\\OneDrive\\Desktop\\DMLab\\AFTER DIWALI\\5boxplot\\b.csv"));
             List<Integer>l=new ArrayList();
             while(sc.hasNext())
             {

                 String s=sc.next();
                 s=s.replaceAll("\\,",""); 

                 l.add(Integer.parseInt(s));
 
             }
             //System.out.println(l);
             Collections.sort(l); 

             System.out.println(l);
             int min=(int)l.get(0);
             int max=(int)l.get(l.size()-1); 
            float median=-1;
             if(l.size()%2==0)
             {
                   median=getMedianeven(l);
             }
             else
             {

                   median=getMedianOdd(l);
             }
             List<Integer>l2=new ArrayList();

             List<Integer>l3=new ArrayList();
             for(int i=0;i<l.size();i++)
             {
                     
                  if((int)l.get(i)<median)
                    {
                        l2.add(l.get(i));
                    }
                    else if((int)l.get(i)>median)
                    {

                            l3.add(l.get(i));
                    }
             }
             Collections.sort(l2);
             Collections.sort(l3);
             
             float median2=-1;
             float median3=-1;
             if(l2.size()%2==0)
             {
                  median2=getMedianeven(l2);
             }
             else
             {
                median2=getMedianOdd(l2);
             }  
             if(l3.size()%2==0)
             { 
                      median3=getMedianeven(l3);
             }
             else
             {
                median3=getMedianOdd(l3);
             }
             System.out.println("Box or Whisher Plot summery");
             System.out.println("1.Min:\t"+min);  
             System.out.println("2.Q1:\t"+median2);
             System.out.println("3.median: "+median);
             System.out.println("4.Q3:-\t"+median3);
             System.out.println("5.max:\t"+max);
          }catch(Exception e){}
    }

}
