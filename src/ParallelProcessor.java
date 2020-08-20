import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class ParallelProcessor{

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
    }

    public static void main(String[]args){
        try{
            Reader(args[0]);
        }

        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }   

}