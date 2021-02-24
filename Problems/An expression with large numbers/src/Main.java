import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // put your code here

        Scanner scanner = new Scanner(System.in);
        String[] in = scanner.nextLine().split(" ");
        BigInteger bi1 = new BigInteger(in[0]);
        BigInteger bi2 = new BigInteger(in[1]);
        BigInteger bi3 = new BigInteger(in[2]);
        BigInteger bi4 = new BigInteger(in[3]);

        BigInteger result = bi1.negate().multiply(bi2).add(bi3).subtract(bi4);
        System.out.println(result);

    }
}