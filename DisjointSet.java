import java.util.ArrayList;
public class DisjointSet{
ArrayList<Integer> par;
ArrayList<Integer> rank;
int size;
    DisjointSet(int n){
         this.size=n;
         par=new ArrayList<>();
         rank=new ArrayList<>();
         for(int i=0;i<=n;i++){
            par.add(i);
            rank.add(0);
         }     
    }

    public int findUltimateParent(int x){
        if(par.get(x)==x){
          return x;
        }
       int n= findUltimateParent(par.get(x));
       par.set(x,n);
       return n;
    }

    public void findUnionRank(int x,int y){
        int uparx=par.get(x);
        int upary=par.get(y);
        if(uparx==upary)
        return;
        

        if(rank.get(uparx)<rank.get(upary)){
            par.set(uparx,upary);
        }else if(rank.get(uparx)>rank.get(upary)){
            par.set(upary,uparx);

        }else{
            par.set(upary,uparx);
                rank.set(uparx,rank.get(uparx)+1);
        }

    }

    public boolean help(int x,int y){
        if(findUltimateParent(x)==findUltimateParent(y))
        return true;

        return false;
    }



    public static void main(String[] args) {
        DisjointSet set=new DisjointSet(7);
        set.findUnionRank(1, 2);
        set.findUnionRank(2, 3);
        set.findUnionRank(4, 5);
        set.findUnionRank(6, 7);
        set.findUnionRank(5, 6);
       // set.findUnionRank(3, 7);
        if(set.help(3,7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }
       // set.findUnionRank(1, 2);
    }
}