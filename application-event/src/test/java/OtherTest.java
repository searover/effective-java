import org.junit.Test;

public class OtherTest {
    @Test
    public void hashTest() {
        System.out.println("2^3 = " + (2 ^ 3));
        System.out.println("2&3 = " + (2 & 3));
    }

    @Test
    public void calc() {
        System.out.println(1 << 4);
    }

    public void printBinary(int num) {
        int tmp = 1 << 31; //用于计算的临时变量

        System.out.println();
        for (int i = 0; i < Integer.SIZE - 1; i++) {
            //System.out.print(number &(tmp>>>=1));
            System.out.print((num & (tmp >>>= 1)) > 0 ? 1 : 0);
        }
    }
}
