import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(InetAddress.getByName("localhost"), 16888);

        StudentCenter studentCenterProxy = RPC.getProxy(StudentCenter.class, StudentCenter.versionID, address, new Configuration());

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Please input student id:");
            String inputStr = scan.nextLine();
            if (inputStr.equals("quit"))
                break;
            String result = studentCenterProxy.findName(inputStr);
            System.out.println(result);
        }
    }
}
