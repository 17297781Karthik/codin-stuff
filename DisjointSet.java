import java.util.ArrayList;
public class DisjointSet{
ArrayList<Integer> par;
ArrayList<Integer> rank;
ArrayList<Integer> rsize;
int size;
    DisjointSet(int n){
         this.size=n;
         par=new ArrayList<>();
         rank=new ArrayList<>();
         rsize=new ArrayList<>();
         for(int i=0;i<=n;i++){
            par.add(i);
            rank.add(0);
            rsize.add(1);
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
    public void findUnionSize(int x,int y){
        int rootx=findUltimateParent(x);
        int rooty=findUltimateParent(y);
        if(rootx==rooty)
        return;

        if(rsize.get(rootx)>rsize.get(rooty)){
            par.set(rooty,rootx);
            rsize.set(rootx,rsize.get(rootx)+rsize.get(rooty));
        }else{
            par.set(rootx,rooty);
            rsize.set(rooty,rsize.get(rootx)+rsize.get(rooty));  
        }
    }

    public boolean isSameParent(int x,int y){
        return (findUltimateParent(x)==findUltimateParent(y));
        
    }



    public static void main(String[] args) {
        DisjointSet set=new DisjointSet(7);
        set.findUnionRank(1, 2);
        set.findUnionRank(2, 3);
        set.findUnionRank(4, 5);
        set.findUnionRank(6, 7);
        set.findUnionRank(5, 6);
       // set.findUnionRank(3, 7);
        if(set.isSameParent(3,7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }
       // set.findUnionRank(1, 2);
    }
}