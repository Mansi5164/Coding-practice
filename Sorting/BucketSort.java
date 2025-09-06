import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static float maximum(float arr[]){
        float max = Float.MIN_VALUE;
        for (int idx = 0; idx < arr.length; idx++) {
            max = Math.max(max, arr[idx]);
        }
        return max;
    }
    public static ArrayList<Float> BucketSort(float[] arr){
        int n = arr.length;
        ArrayList<Float> result = new ArrayList<>();
        if(arr.length == 0) return result;

        float maxEle = maximum(arr);
        int maxIndex = (int) (maxEle*n);
        int bucketSize = maxIndex+1;

        ArrayList<Float> buckets[] = new ArrayList[bucketSize];
        for(int i=0;i<bucketSize;i++){
            buckets[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int index = (int)(arr[i] * n);
            buckets[index].add(arr[i]);
        }
        for(int i=0;i<bucketSize;i++){
            Collections.sort(buckets[i]);
        }
        for(int i=0;i<bucketSize;i++)
        {
            System.out.println("Bucket ["+i+"] -> "+buckets[i]);
            for(Float ele : buckets[i]){
                result.add(ele);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        float arr[] = {0.78f,0.17f,0.39f,0.26f,0.72f,0.94f,0.21f,0.12f,0.23f,0.68f};

        ArrayList<Float> list = new ArrayList<>();
        list = BucketSort(arr);

        // after sorting print the element
        System.out.print("After sorting the elements of an array : ");
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

    }
}
