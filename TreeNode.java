import Weight;

public class TreeNode{

    private TreeNode left, right, center;
    private Integer weight;
    private int x,y;

    public TreeNode(){

    }

    public TreeNode(int x, int y, Integer weight){
        this.x = x;
        this.y = y;
        this.weight = weight;
        left = new TreeNode();
        right = new TreeNode();
        center = new TreeNode();
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public TreeNode getCenter(){
        return center;
    }

    public Integer getWeight(){
        return weight;
    }

    public void addLeft(TreeNode left){
        this.left = left;
    }
}
