class DisjointSet{
    public:
        vector<int> parent,rank,size;

        DisjointSet(int n){
            parent.resize(n+1);
            rank.resize(n+1);
            size.resize(n+1);

            for(int i=0;i<=n;i++){
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        int findParent(int node){
            if(node == parent[node]) return node;

            return parent[node] = findParent(parent[node]);
        }

        void unionBySize(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return;

            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }

        void unionByRank(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return ;

            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }else if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
};

class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        int n = accounts.size();
        DisjointSet ds(n);
        unordered_map<string,int> map;

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts[i].size();j++){
                string mail = accounts[i][j];
                if(map.find(mail) == map.end()){
                    map[mail] = i;
                }else{
                    ds.unionBySize(i,map[mail]);
                }
            }
        }

        // merge mails 
        vector<vector<string>> mergedMail(n);
        for(auto it: map){
            string mail = it.first;
            int node = ds.findParent(it.second);

            mergedMail[node].push_back(mail);
        }


        // combine all merged mails into an answer
        vector<vector<string>> ans;
        for(int i=0;i<n;i++){
            if(mergedMail[i].size() ==0) continue;

            sort(mergedMail[i].begin(),mergedMail[i].end());

            vector<string> temp;
            //transfer all mail accounts to one list

            //appned name to list
            temp.push_back(accounts[i][0]);

            for(auto it: mergedMail[i]){
                temp.push_back(it);
            }

            ans.push_back(temp);
        }

        return ans;
    }
};