package designpattern.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 可以存储文件夹和其他文件
 */
public class Folder extends Root{



    List<Root> folders = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void setFolders(List<Root> folders) {
        this.folders = folders;
    }

    public List<Root> getFolders() {
        return folders;
    }

    @Override
    public void addFile(Root root) {
        folders.add(root);
    }

    @Override
    public void removeFile(Root root) {
        folders.remove(root);
    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++){
            sb.append("-");
        }
        System.out.println(sb.toString() + this.getName());

        for (Root r : folders){
            //每个下级，横线多2个
            r.display(depth + 2);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Folder)) return false;
        Folder folder = (Folder) o;
        return Objects.equals(getFolders(), folder.getFolders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFolders());
    }
}
