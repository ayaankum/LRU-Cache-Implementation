public class LRUImplementation {
    public static void main(String[] args) {
        LRU<Integer, String> cache = new LRU<>(4);
        cache.put(1,"CNN");
        cache.put(2,"OOPS");
        cache.put(3,"DSA");
        cache.put(4,"OS");
        cache.put(5,"CLOUD");
        cache.printCache();
    }
}