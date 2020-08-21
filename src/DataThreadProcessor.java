import java.util.concurrent.RecursiveAction;
import java.util.ArrayList; 

class DataThreadProcessor extends RecursiveAction{
   /* int sequential_cutoff=4;*/
    ArrayList <String> result;
    float[][]arr; int lo; int hi;

    DataThreadProcessor(float[][]arr,ArrayList<String>res,int lo, int hi){
        this.arr=arr;
        this.lo=lo;
        this.hi=hi;
        this.result=res;
    }

    protected void compute(){

        if(hi-lo<=100){
            for(int i=lo;i<hi;i++){
                for(int j=1;j<arr[j].length-1;j++){
                    float mid_value=arr[i][j];
                  //  System.out.println(mid_value);
                    float[] nbours = new float[]{ arr[i-1][j-1],arr[i-1][j],arr[i-1][j+1],arr[i][j-1],arr[i][j+1],
                    arr[i+1][j-1],arr[i+1][j],arr[i+1][j+1] };


                    int counter=0;
                    for(float k: nbours){
                        if(k>mid_value+0.01){
                            counter++;
                            
                        }
                    }
                    if(counter==8)
                    {
                        result.add(i+" "+j);
                
                    }
                    
                }   
            }
        }
        else{
            DataThreadProcessor left=new DataThreadProcessor(arr,result,lo,(hi+lo)/2 );
            left.fork();
            DataThreadProcessor right=new DataThreadProcessor(arr,result,(hi+lo)/2,hi);
            right.compute();
            left.join();
        }

    }

    




}