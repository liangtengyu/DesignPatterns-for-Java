/**
 * @Author: lty
 * @Date: 2020/11/24 15:38
 */

public class Stack {
    private  Integer have;
    private  Integer uesd;

    public Integer getHave() {
        return have;
    }

    public void setHave(Integer have) {
        this.have = have;
    }

    public Integer getUesd() {
        return uesd;
    }

    public void setUesd(Integer uesd) {
        this.uesd = uesd;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "have=" + have +
                ", uesd=" + uesd +
                '}';
    }
}
