/**
 * @Author: lty
 * @Date: 2021/1/28 09:38
 */
public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract int countNumOfFiles();
    public abstract long countSizeOfFiles();
}
