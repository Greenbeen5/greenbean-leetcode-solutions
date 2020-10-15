class Solution {
    class Person{
        int trusted;
        boolean possible;
        public Person(){
            trusted = 0;
            possible = true;
        }
    }
    public int findJudge(int N, int[][] trust) {
        Person[] persons = new Person[N];
        for(int i = 0; i<N; ++i){
            persons[i] = new Person();
        }
        for(int i = 0; i<trust.length; ++i){
            persons[trust[i][0]-1].possible = false;
            persons[trust[i][1]-1].trusted++;
        }
        for(int i = 0; i<N; ++i){
            if(persons[i].possible && persons[i].trusted == N-1){
                return i+1;
            }
        }
        return -1;
    }
    
}