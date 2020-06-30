public class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node<K, V> getRoot() {
        return this.root;
    }

    public void add(K key, V value) {
        if(key==null){
            return;
        }
        Node<K, V> item=new Node<K, V>( key,  value);
        addNode(item,this.root);

    }

    public void addNode(Node<K, V> item, Node<K, V> tree){
        if(tree==null){
            root=item;
        }else {

            if (item.getKey().compareTo(tree.getKey()) == 0) {
                tree.setValue((V) item.getValue());
            } else if (item.getKey().compareTo(tree.getKey()) < 0) {
                if(tree.getLeft()==null){
                    tree.setLeft(item);
                }else{
                    addNode(item, tree.getLeft());
                }


            } else if (item.getKey().compareTo(tree.getKey()) > 0) {
                if(tree.getRight()==null){
                    tree.setRight(item);

                }else{
                    addNode(item, tree.getRight());
                }

            }
        }

    }

    public V find(K key) {
        if(root==null){
            return null;
        }else {
            Node<K, V> tree=this.root;
            return findItem(key,tree);
        }
    }

    public V findItem(K key,Node<K,V> tree){
        V result=null;
        if (key.compareTo(tree.getKey()) == 0) {
            result= tree.getValue();
        } else if (key.compareTo(tree.getKey()) < 0) {
            if(tree.getLeft()==null){
                result= null;
            }else{
                findItem(key, tree.getLeft());
            }


        } else if (key.compareTo(tree.getKey()) > 0) {
            if(tree.getRight()==null){
                result= null;

            }else{
                findItem(key, tree.getRight());
            }

        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public V[] flatten() {
        return (V[]) new Object[0];
    }

    public void remove(K key) {

    }

    public boolean containsSubtree(BinaryTree<K, V> other) {
        return false;
    }
}
