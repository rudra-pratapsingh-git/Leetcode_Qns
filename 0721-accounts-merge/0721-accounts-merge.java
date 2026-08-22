class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    int findParent(int node){
        if(parent.get(node) == node) return node;

        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);

        return parent.get(node);
    }

    void unionByRank(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;

        if(rank.get(pu) < rank.get(pv)){
            parent.set(pu,pv);
        }else if(rank.get(pu) > rank.get(pv)){
            parent.set(pv,pu);
        }else{
            parent.set(pv,pu);
            rank.set(pu,rank.get(pu)+1);
        }
    }

    void unionBySize(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;

        if(size.get(pu) < size.get(pv)){
            parent.set(pu,pv);
            int sizeul = size.get(pu) + size.get(pv);
            size.set(pv,sizeul);
        }else{
            parent.set(pv,pu);
            int sizeul = size.get(pu) + size.get(pv);
            size.set(pu,sizeul);
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);

                if(map.containsKey(mail) == false){
                    map.put(mail,i);
                }else{
                    ds.unionByRank(i,map.get(mail));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();

        for(int i=0;i<n;i++){
            mergedMail.add(new ArrayList<>());
        }
        //merge mails at one place
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            String mail = entry.getKey();
            int node = ds.findParent(entry.getValue());
            mergedMail.get(node).add(mail);
        }

        // construct the final answer
        List<List<String>> ans  = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail.get(i).size() == 0) continue;

            Collections.sort(mergedMail.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for(String it: mergedMail.get(i)){
                temp.add(it);
            }

            ans.add(temp);
        }

        return ans;




    }
}