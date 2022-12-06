import java.util.*;
import java.io.*;
public class MinMaxZscore
{
   public static void main(String args[]) throws Exception
   {
  	List<Integer> l=new ArrayList();
  	Scanner sc=new Scanner(new File("C://Users/Manoj/OneDrive/Desktop/DMLab/AFTER DIWALI/2minmax/input.csv"));
  	while(sc.hasNext())
  	{  
     	l.add(Integer.parseInt(sc.next()));
  	}
  	float min=(float)Collections.min(l);
  	float max=(float)Collections.max(l);
  	float newmin=0;
  	float newmax=5;
  	float f=(newmax-newmin);
  	List l2=new ArrayList();
  	for(int i=0;i<l.size();i++)
  	{
       	float m=(((int)l.get(i)-min)/(max-min))*f+newmin;
       	l2.add(m);
 	 
  	}
	System.out.println("\nData:\n"+l);
	System.out.println("\nMin max Normalization\n"+l2);
 	int sum1=l.stream().filter(i->i>5).mapToInt(i->i).sum();
 	int mean=sum1/l.size();
 	float sum2=0;
 	for(int i=0;i<l.size();i++)
 	{
     	sum2+=(float)Math.pow((int)l.get(i)-mean,2);
	 
 	}
 	sum2=sum2/l.size();
 	float sd=(float)Math.sqrt(sum2);
 	List l3=new ArrayList();
 	for(int i=0;i<l.size();i++)
 	{
      	float gd=(float)((int)l.get(i)-mean)/sd;
      	l3.add(gd);
     	 
 	}
 	System.out.println("\nZ Score Normalization:\n"+l3);
   
   }
 

}

