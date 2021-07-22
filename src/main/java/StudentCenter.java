import org.apache.hadoop.ipc.VersionedProtocol;

public interface StudentCenter extends VersionedProtocol {
    long versionID = 1L;
    String findName(String studentId);
}