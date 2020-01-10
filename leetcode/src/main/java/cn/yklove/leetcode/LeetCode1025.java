package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode1025 {
    public boolean divisorGame(int N) {
        if(N <2){
            return false;
        }
        boolean[] ans = new boolean[N + 1];
        ans[2] = true;
        for(int i=3;i<=N;i++){
            for(int j=1;j<i;j++){
                if(i % j == 0){
                    if(!ans[i - j]){
                        ans[i] = true;
                        break;
                    }
                }
            }
        }
        return ans[N];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1025().divisorGame(0));
        System.out.println(new LeetCode1025().divisorGame(1));
        System.out.println(new LeetCode1025().divisorGame(2));
        System.out.println(new LeetCode1025().divisorGame(3));
        System.out.println(new LeetCode1025().divisorGame(4));
        System.out.println(new LeetCode1025().divisorGame(1000));
    }
}
