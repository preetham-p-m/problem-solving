package array.helper;

public class MaximumSumSubArrayOutput {
    private int sum;

    private int[] sumArray;

    public MaximumSumSubArrayOutput(int sum, int[] sumArray) {
        this.sum = sum;
        this.sumArray = sumArray;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int[] getSumArray() {
        return sumArray;
    }

    public void setSumArray(int[] sumArray) {
        this.sumArray = sumArray;
    }

}