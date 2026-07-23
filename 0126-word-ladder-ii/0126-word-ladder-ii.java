class Solution {
    String b;
    HashMap<String,Integer> mpp;
    List<List<String>> ans;

    private void dfs(String word,List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return ;

        }

        int steps = mpp.get(word);
        int sz = word.length();
        for(int i=0;i<sz;i++){
            for(char ch='a';ch<='z';ch++){
                char replaceArr[] = word.toCharArray();
                replaceArr[i] = ch;
                String replacedWord = new String(replaceArr);
                if(mpp.containsKey(replacedWord)==true && mpp.get(replacedWord)+1 == steps){
                    seq.add(replacedWord);
                    dfs(replacedWord,seq);
                    seq.remove(replacedWord);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<String>();
        int len = wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }

        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.add(beginWord);
        mpp = new HashMap<>();
        mpp.put(beginWord,1);
        int sizee = beginWord.length();
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.poll();
            int steps = mpp.get(word);

            if(word.equals(endWord)) break;

            for(int i=0;i<sizee;i++){
                for(char ch = 'a';ch<='z';ch++){
                    char replaceArr[] = word.toCharArray();
                    replaceArr[i] = ch;
                    String replacedWord = new String(replaceArr);
                    if(st.contains(replacedWord)==true){
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mpp.put(replacedWord,steps+1);
                    }
                }

            }
        }

        ans = new ArrayList<>();
        if(mpp.containsKey(endWord) == true){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
}