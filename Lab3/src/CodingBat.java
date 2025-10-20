public class CodingBat {

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (weekday == false && vacation == false){
            return true;
        }
        else if (weekday == true && vacation == false){
            return false;
        }
        else if (weekday == false && vacation == true){
            return true;
        }
        else
            return true;

    }

    public int sumDouble(int a, int b) {
        if (a == b ){
            return (a+b)*2;
        }
        else{
            return (a+b);
        }
    }

    public int bigDiff(int[] nums) {
        int min = 100;
        int max = 0;

        if(nums.length == 1){
            return 0;
        }
        for(int i = 0; i < nums.length; i ++){
            if(min>nums[i]){
                min = nums[i];
            }
            if(max<nums[i]){
                max = nums[i];
            }
        }
        return max - min;



    }
}

