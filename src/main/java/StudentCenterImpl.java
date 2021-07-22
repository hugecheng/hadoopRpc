import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

public class StudentCenterImpl implements StudentCenter {
    @Override
    public String findName(String studentId) {
        System.out.println("receive student id:" + studentId);
        switch (studentId) {
            case "20210000000000":
                return null;
            case "20210123456789":
                return "XinXin";
            case "20210735010489":
                return "Warren";
            default:
                return "Can't find this student id!";
        }
    }

    @Override
    public long getProtocolVersion(String s, long l) throws IOException {
        return versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return new ProtocolSignature();
    }
}
