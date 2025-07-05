package dailyLeetcodeProblems;
import java.util.ArrayList;
class ListNode{
    int val;
    ListNode next;
}
public class Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points_2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int arr[] = {-1,-1};
        if(head == null || head.next == null || head.next.next == null) return arr;
        ArrayList<Integer> points = new ArrayList<>();
        ListNode prev = null, curr = head;
        int ind = 1;
        while(curr.next != null)
        {
            if(prev == null){
                prev = curr;
                curr = curr.next;
                ind++;
            }
            if(prev.val > curr.val && curr.val < curr.next.val){
                points.add(ind);
            }
            if(prev.val < curr.val && curr.val > curr.next.val){
                points.add(ind);
            }
            prev = curr;
            curr = curr.next;
            ind++;
        }
        if(points.size() >= 2){
            int min = Integer.MAX_VALUE;
            for(int i=1;i<points.size();i++){
                min = Math.min(min,points.get(i)-points.get(i-1));
            }
            arr[0] = min;
            arr[1] = points.get(points.size()-1)-points.get(0);
        }
        return arr;
    }
}
