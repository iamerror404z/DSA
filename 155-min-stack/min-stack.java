class MinStack {
    List<Integer> stack;
    List<Integer> track;

    public MinStack() {
        stack=new LinkedList<>();
        track=new LinkedList<>();
    }
    
    public void push(int val) {
        if(track.size()==0){
            track.add(val);
        }else{
            int last=track.get(track.size()-1);
            track.add(Math.min(val,last));
        }

        stack.add(val);
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
        track.remove(track.size()-1);
    }
    
    public int top() {
        int temp=stack.get(stack.size()-1);
        return temp;
    }
    
    public int getMin() {
        return track.get(track.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */