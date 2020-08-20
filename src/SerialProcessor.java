import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SerialProcessor{
    static int row;
    static int col;
   
    static float arr[][];

    /*Reading data in the file as will the surface size*/
    public static void Reader(String fileName) throws FileNotFoundException{
        File filename=new File(fileName);
        Scanner sc=new Scanner(filename);
        row=sc.nextInt();
        col=sc.nextInt();
        arr=new float[row][col];

      // use US locale to be able to identify floats in the string
      sc.useLocale(Locale.US);
        

       
       for(int i=0;i<row;i++){
           for(int j=0;  j<col; j++){
               arr[i][j]=sc.nextFloat();
           }
       }
       System.gc();
       DataProcessor(arr);
      
    }

    /*Data Processing Method*/
    public static void DataProcessor(float[][]arr){
        int basin_counter=0;
        ArrayList <String> results=new ArrayList <String> ();
        long tick=System.currentTimeMillis();
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                float mid_value=arr[i][j];
                float[] nbours = new float[]{ arr[i-1][j-1],arr[i-1][j],arr[i-1][j+1],arr[i][j-1],arr[i][j+1],
                arr[i+1][j-1],arr[i+1][j],arr[i+1][j+1] };

                int counter=0;
                for(float k: nbours){
                    if(k>mid_value+0.01){
                        counter++;
                    }
                }
                if(counter==8){
                    
                    basin_counter++;
                    results.add(i+" "+j);
                }
            }
        }
        long tock=System.currentTimeMillis()-tick;
        System.out.println("Time elapsed: "+tock);
        System.out.println(basin_counter);

        for(String value:results){
            System.out.println(value);
        }


    }

    public static void main(String[]args){
        try
        {
            Reader(args[0]);
        
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

}
