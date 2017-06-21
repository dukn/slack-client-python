import java.util.Collection;
import java.util.List;


public class TreeNode {

    private Collection<TreeNode> children;
    private String caption;
    private int rate;

    public TreeNode(Collection<TreeNode> children, String caption, int rate) {
        super();
        this.children = children;
        this.caption = caption;
        this.rate = rate;
    }

    public Collection<TreeNode> getChildren() {
        return children;
    }
    public int getRate(){
        return rate;
    }

    public void setChildren(Collection<TreeNode> children) {
        this.children = children;
    }
    public void setRate(int rate){
        this.rate = rate;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}