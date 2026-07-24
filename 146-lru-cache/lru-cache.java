class Node{
    int key;
    int val;

    Node prev;
    Node next;

    Node(){
        key=val=-1;
        prev=next=null;
    }

    Node(int key,int val){
        this.key=key;
        this.val=val;

        prev=next=null;
    }
}



class LRUCache {
    Map<Integer,Node> map;
   final int cap;
    Node head;
    Node tail;

    public void deleteNode(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;

    }

    public void insertAfterHead(Node node){
        Node nextNode=head.next;

        head.next=node;
        node.prev=head;

        node.next=nextNode;
        nextNode.prev=node;
    }

   public  LRUCache(int capacity){
        cap=capacity;
        map=new HashMap<>();

        head=new Node();
        tail=new Node();

        head.next=tail;
        tail.prev=head;
    }

    public Node evict(){
        Node op=tail.prev;
        Node nextNode=tail.prev.prev;

        tail.prev=nextNode;
        nextNode.next=tail;

        return op;

    }

    
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node res=map.get(key);

        deleteNode(res);
        insertAfterHead(res);
        

        return res.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            
            deleteNode(node);
            insertAfterHead(node);



            return ;
        }



        if(map.size()==cap){
            Node res=evict();

            map.remove(res.key);

           
        }
        
         Node newNode=new Node(key,value);
            map.put(key,newNode);

            insertAfterHead(newNode);



        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */