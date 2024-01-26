class BrowserHistory {
    List<String> history;
    int index = 0;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        index = 0;
    }
    
    public void visit(String url) {        
        int i = history.size() - 1;        
        while (i != index) {
            history.remove(i);
            i--;
        }
        history.add(url);
        index = history.size() - 1;
    }
    
    public String back(int steps) {
        index = Math.max(0, index-steps);
        return history.get(index);
    }
    
    public String forward(int steps) {
        index = Math.min(history.size()-1, index+steps);
        return history.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */