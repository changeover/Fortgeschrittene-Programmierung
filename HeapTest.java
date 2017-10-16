public class HeapTest {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap(Integer.class,32);
        heap.populate();
        heap.convert();
        heap.sort();
        System.out.println(heap.toString());
        HeapInt heap2 = new HeapInt(32);
        heap2.populate();
        heap.convert();
        System.out.println(heap2.toString());
        Heap<String> heap3 = new Heap(String.class,32);
        heap3.populate();
        heap3.convert();
        heap3.sort();
        System.out.println(heap3.toString());
    }
}
