import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class StudentCenterDriver {
    public static void main(String[] args){
        RPC.Builder builder = new RPC.Builder(new Configuration());

        builder.setBindAddress("127.0.0.1");
        builder.setPort(16888);

        builder.setProtocol(StudentCenter.class);
        builder.setInstance(new StudentCenterImpl());

        try {
            RPC.Server server = builder.build();
            server.start();
            System.out.println("---Student center service stared!---");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
