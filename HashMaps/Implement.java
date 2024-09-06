import java.util.ArrayList;
import java.util.LinkedList;


public class Implement {

    static class HashMap<K,V> {

        private class Node {
           K key;
           V value;

           Node(K key,V value) {
            this.key=key;
            this.value=value;
           }
        }


        private LinkedList<Node> bucket[];
        private int N=4;
        private int n;


        @SuppressWarnings("unchecked")
        HashMap() {
            this.bucket = new LinkedList[N];
            for(int i=0;i<bucket.length;i++) {
                bucket[i] = new LinkedList<>();
            }

        }

        public int hashFun(K key) {
           int bi = key.hashCode();
           return Math.abs(bi)%N;  // to generate the bucket index within the array size
           }
      
        public int searchll(int bi, K key) {
            LinkedList<Node> ll = bucket[bi];
            int di=0;
            for(int i=0;i<ll.size();i++) {
            Node node = ll.get(i);
            if(node.key==key) {
                return di;
            } 
              di++;
            }
            return -1;
            
        }

        public void put(K key,V value) {
            int bi = hashFun(key);
            int di = searchll(bi,key);
            if(di!=-1) {
                Node node = bucket[bi].get(di);
                node.value=value;
            } else {
                bucket[bi].add(new Node(key, value));
                n++;
            }
         }
        public V get(K key) {
            int bi = hashFun(key);
            int di = searchll(bi,key);
            if(di!=-1) {
                Node node = bucket[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFun(key);
            int di = searchll(bi,key);
            if(di!=-1) {
                return true;
            } else {
                return false;
            }
        }
        public V remove(K key) {
            int bi = hashFun(key);
            int di = searchll(bi,key);
            if(di!=-1) {
          Node node = bucket[bi].get(di);
          V val = node.value;
          bucket[bi].remove(di);
          n--;
          return val;
            } else {
                return null;
            }
        }

        public ArrayList<K> KeySet() {
        ArrayList<K> a = new ArrayList<>();
        for(int i=0;i<bucket.length;i++) {
            LinkedList<Node> ll = bucket[i];
            for(Node node: ll) {
                a.add(node.key);
            }

        }
        return a;
        }

        public boolean isEmpty() {
            return n==0;
        }
    }
    public static void main(String[] args) {
    HashMap<String,Integer> hm = new HashMap<>();
    hm.put("Shubham", 12);
    hm.put("Devansh", 50);

    ArrayList<String> a = hm.KeySet();
    for(String s : a) {
        System.out.println(s);
    }


    }
}