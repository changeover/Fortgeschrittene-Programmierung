public class HeapInt
{
   private int[] heap;
   private int n;
   
   public HeapInt(int n)
   {
      heap = new int[n+1];
      this.n = n;
   }

   private void swap(int i, int j)
   {
      int tmp = heap[i]; heap[i] = heap[j]; heap[j] = tmp;
   }

   private void restore (int L, int R)
   {
      int i = L;
      int j;

      while (i <= R/2)
      {
         if ((2*i < R) && (heap[2*i+1] < heap[2*i]))
            j = 2*i+1;
         else j = 2*i;
         if (heap[j] < heap[i])
         {
            swap(i, j);
            i = j;
         }
         else i = R;
      }
   }
   
   public void populate()
   {
      for (int i = 1; i <= n; i++)
      {
         heap[i] = (int)(100.0*Math.random());
      }
   }
   
   public void convert()
   {
      for (int i = n/2; i >= 1; i--)
         restore(i, n);
   }
   
   public void sort()
   {
      for (int i = n; i>=2 ; i--)
      {
         swap(1, i);
         restore(1, i-1);
      }
   }

   public String toString()
   {
      StringBuilder sb = new StringBuilder("(");
      for (int i = 1; i < n; i++)
      {  sb.append(heap[i]); sb.append(", ");
      }
      sb.append(heap[n]); sb.append(")");
      return sb.toString();
   }
}
