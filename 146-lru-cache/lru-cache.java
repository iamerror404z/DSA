import java.util.*;

class Node{
    int key;
    int val;
    
    Node dlPrev;
    Node dlNext;
    
    
    Node mapPrev;
    Node mapNext;
    
    Node(){
        key=val=-1;
        
        dlPrev=dlNext=mapNext=mapPrev=null;
    }
     Node(int key , int val){
        this.key=key;
        this.val=val;
        dlPrev=dlNext=mapNext=mapPrev=null;
    }
    
    
    
}



class Cmap{
    Node[] map;
    final int cap;
    int size=0;
    
    Cmap(int capacity){
        cap=capacity;
        map=new Node[cap];
    }
    
    public int size(){
        return size;
    }
    
    public void remove(Node node){
        int hash=node.key%cap;
        
        if(map[hash]==node){
            Node nextNode=node.mapNext;
            
            if(nextNode!=null){
                nextNode.mapPrev=null;
            }
            
            map[hash]=nextNode;
            size--;
            
            return ;
        }
        
        
        Node prevNode=node.mapPrev;
        Node nextNode=node.mapNext;
        

        if(prevNode!=null){
        prevNode.mapNext=nextNode;
        }

        if(nextNode!=null){
            nextNode.mapPrev=prevNode;
        }
        
        
        
        size--;
    }
    
    public Node get(int key){
        int hash=key%cap;
        
        Node curr=map[hash];
        Node prev=null;
        
        while(curr!=null){
            if(curr.key==key){
                return curr;
            }
            
            prev=curr;
            curr=curr.mapNext;
        }
        
        return prev;
    }
    
    public Node updateObj(Node node){
        Node prevNode=node.mapPrev;
        
        if(prevNode!=null){
            prevNode.mapNext=null;
        }
        
        
        return prevNode;
    }
    
    public void add(Node node,Node prev){
        int hash=node.key%cap;
        
        
        if(prev==null){
            
            System.out.println("num is "+node.key);
            map[hash]=node;
            size++;
            
            return;
        }
        
        prev.mapNext=node;
        node.mapPrev=prev;
        
        
        
        
        size++;
    }
    
    

}

class LRUCache {
    Node head;
    Node tail;
    Cmap map;
    final int cap;
    
    
    public void deleteNode(Node node){
        Node prevNode=node.dlPrev;
        Node nextNode=node.dlNext;
        
        prevNode.dlNext=nextNode;
        nextNode.dlPrev=prevNode;
    }
    
    public void insertAfterHead(Node node){
        Node nextNode=head.dlNext;
        
        head.dlNext=node;
        node.dlPrev=head;
        
        nextNode.dlPrev=node;
        node.dlNext=nextNode;
        
    }
    

    public LRUCache(int capacity) {
        cap=capacity;
        map=new Cmap(cap);
        
        head=new Node();
        tail=new Node();
        
        head.dlNext=tail;
        tail.dlPrev=head;
        
    }
    
    public int get(int key) {
        Node res=map.get(key);
        
        if(res!=null && res.key==key){
            
            deleteNode(res);
            insertAfterHead(res);
            
            return res.val;
        }
        
        

        return -1;
        
    }
    
    public Node evict(){
        Node curr=tail.dlPrev;
        
        Node prevNode=curr.dlPrev;
        
        tail.dlPrev=prevNode;
        
        prevNode.dlNext=tail;
        
        return curr;
        
    }
    
    public void put(int key, int value) {
        Node res=map.get(key);
        
        if(res!=null && res.key==key){
            res.val=value;
            
            deleteNode(res);
            insertAfterHead(res);

            return;
        }
        
       
        
        if(map.size()==cap){
            Node removed=evict();
            System.out.println("rmoved is : "+removed.key);
            
            if(removed==res){
                Node tempRes=map.updateObj(res);
                res=tempRes;
                // System.out.println("obj is : "+tempRes);
            }
            
            map.remove(removed);
        }
        
        Node newNode=new Node(key,value);
        
        map.add(newNode,res);
        // System.out.println("map size is "+map.size());
        // System.out.println("res is : "+res.val);
        
        insertAfterHead(newNode);
        
        
        
    }
}