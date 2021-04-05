import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Program is about the MergeSort Algorithm
 * Here used Integer List for example
 */
public class MergeSort {
    /**
     * main method where the execution starts
     * @param args
     */
    public static void main(String[] args) {
        // Creating list
        List<Integer> integerList = Arrays.asList(10,2,80,0,1,5,6);
        System.out.println("Before Sorting");
        printItems(integerList);

        // sort list
        integerList = sortList(integerList);

        // print to check the list
        System.out.println("\n\nAfter Sorting");
        printItems(integerList);
    }

    /**
     * which accepts list of integers and print the items
     * @param list
     */
    public static void printItems(List<Integer> list) {
        // The lambda function is used inside the foreach()
        list.forEach(item-> System.out.print(item+" "));
    }

    /**
     * Accepts List and sort
     * @param list
     * @return
     */
    static List<Integer> sortList(List<Integer> list) {
        // If list has only 1 Element return the list
        if(list.size()<=1) {
            return list;
        }

        // Here following Divide and Conquer method so
        // dividing the list
        int mid = list.size()/2;

        // Following the Recursive pattern to divide the List
        List<Integer> left = sortList(list.subList(0,mid));
        List<Integer> right = sortList(list.subList(mid,list.size()));

        // calling the merge() on Divided List
        return merge(left,right);
    }

    /**
     * Accepts two list to sort and merge
     * @param leftL
     * @param rightL
     * @return
     */
    static List<Integer> merge(List<Integer> leftL, List<Integer> rightL) {
         int left=0,right=0,result=0;
         // Declaring and Initializing a new List
         // that will be returned after the merge complete
         List<Integer> resultL = new ArrayList<>();

         //check whether left or Right elements are traversed or not
         while(left<leftL.size() || right < rightL.size()) {

             //condition where left and Right elements are not fully traversed
             if(left < leftL.size() && right < rightL.size()) {
                 // check the present traversing element in left list is less than
                 // element present in right list
                 // If less add the element from left list to result list
                 if(leftL.get(left) < rightL.get(right)) {
                     resultL.add(leftL.get(left));
                     left++;
                 } else { // If not less add the element from right list to result list
                     resultL.add(rightL.get(right));
                     right++;
                 }
                 result++;
             }
             //condition where elements in right list are fully traversed and elements are still remaining in left list
             else if(left < leftL.size()) {
                 resultL.add(leftL.get(left));
                 left++;
                 result++;
             }
             //condition where elements in left list are fully traversed and elements are still remaining in right list
             else if(right < rightL.size()) {
                 resultL.add(rightL.get(right));
                 right++;
                 result++;
             }
         }

         // return the result list where both list are sorted and merged
         return resultL;
    }

}
