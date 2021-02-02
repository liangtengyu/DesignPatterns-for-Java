import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/1/28 09:39
 */
public class Directory extends FileSystemNode{
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int num = 0;
        for (FileSystemNode dir : subNodes) {
            num+= dir.countNumOfFiles();
        }
        return num;
    }

    @Override
    public long countSizeOfFiles() {
        int size = 0;
        for (FileSystemNode dir : subNodes) {
            size+=dir.countSizeOfFiles();
        }
        return size;
    }

    public void addSubNode(FileSystemNode node) {
        subNodes.add(node);
    }

    public void removeNode(FileSystemNode node) {
        int size = subNodes.size();
        for (int i = 0; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(node.getPath())) {
                subNodes.remove(i);
            }

        }

    }
}
