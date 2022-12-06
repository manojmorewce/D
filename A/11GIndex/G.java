import java.util.*;
//import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
class G {
    public static void main(String[] args) throws Exception {  


        

        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Manoj/OneDrive/Desktop/DMLab/AFTER DIWALI/11GIndex/data.csv"));
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        String[] s = br.readLine().trim().split(",");

        int n = s.length;
        
        while (true) {
            String str[] = new String[n];
            try 
            {
                str = br.readLine().trim().split(",");
            } 
            catch (NullPointerException e) 
            {
                break;
            }
            ArrayList<String> temp = new ArrayList<>();

            for (String s1 : str){
                temp.add(s1);
            }
            data.add(temp);
            
        }

        int CINEMA = 0, TENNIS = 0;
        for (int i = 0; i < data.size(); i++) 
        {
            if (data.get(i).get(4).equals("CINEMA"))  
                 CINEMA++;
            else
                TENNIS++;
        }
        System.out.println("Class : DECISION");
        System.out.println("Count of CINEMA : "+CINEMA  +  "\nCount of TENNIS : "+TENNIS);
        double totRecord = data.size();
        double GineIndex = 1.0-Math.pow((CINEMA / totRecord),2)  - Math.pow( (TENNIS / totRecord),2)  ;
        System.out.println("Gini Index of DECISION :"+GineIndex);
        System.out.println("=========================================================");
        for(int i=1;i<data.get(0).size()-1;i++){
            System.out.println("Gini Index Of "+ s[i]+" :"+findAllGineIndex(i,GineIndex,data,s));
            System.out.println("=========================================================");
        }

        br.close();
    }

    private static double findAllGineIndex(int i, double GineIndex, ArrayList<ArrayList<String>> data, String[] s) {
        Set<String> attribute=new HashSet<>();
        for(ArrayList<String>x:data)
            attribute.add(x.get(i));
        Map<String,double[]>total=new HashMap<>();
        for(String x:attribute){
            total.put(x,new double[2]);
        }
        for(ArrayList<String> x:data){
            if(x.get(4).equals(("CINEMA")))
                total.get(x.get(i))[0]++;
            else
                total.get(x.get(i))[1]++;

        }
        double totalE=0.0;
        System.out.println("Count Table for  :"+s[i]);
        System.out.println(s[i]+" CINEMA  TENNIS ");
        for(Map.Entry<String,double[]> x:total.entrySet()){
            double total1=x.getValue()[0]+x.getValue()[1];
            System.out.println(x.getKey()+"  "+x.getValue()[0]+"  "+x.getValue()[1]);
            if(x.getValue()[0]==0||x.getValue()[1]==0)
                continue;
            double temp= 1-Math.pow((x.getValue()[0] / total1),2) - Math.pow((x.getValue()[1]/ total1),2);
            //System.out.println(temp);
            totalE+=(total1/ data.size())*temp;


        }

       // double finalE=GineIndex-totalE;
        return totalE;
    }


}