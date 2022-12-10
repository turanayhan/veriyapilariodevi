import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



public class HuffmanKodu
{

    public static void hufmanOluştur(String text)
    {
        //Kullanıcı veri girmiş mi kontrol yapılır
        if (text == null || text.length() == 0)
        {
            return;
        }

        //Map oluşturma
        Map<Character, Integer> freq = new HashMap<>();
        //döngü dize üzerinde yinelenir ve metni karakter dizisine dönüştürür
        for (char c: text.toCharArray())
        {
            //put() yöntemini çağırarak karakterleri ve frekanslarını  kayıt yeri
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        //here a point to note that the highest priority means the lowest frequency
        PriorityQueue<index> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));
        //loop iterate over the Map and returns a Set view of the mappings contained in this Map
        for (var entry: freq.entrySet())
        {
            pq.add(new index(entry.getKey(), entry.getValue()));
        }

        while (pq.size() != 1)
        {
            //en yüksek önceliğe (en düşük frekansa) sahip veri sıradan çıkarma
            index left = pq.poll();
            index right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new index(null, sum, left, right));
        }
        index root = pq.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encodeData(root, "", huffmanCode);
        System.out.println("\n"+"Girilen karakterler: " + text);
        System.out.println("\n"+"Karakterlerin Huffman Kodları " + huffmanCode);
        //ilk verileri yazdırır

        //StringBuilder sınıfının bir örneğini oluşturma
        StringBuilder sb = new StringBuilder();
        //karakter dizisi üzerinde döngü yineleme
        for (char c: text.toCharArray())
        {
            //prints encoded string by getting characters
            sb.append(huffmanCode.get(c));
        }
        System.out.println("\n"+"Karakterlerin karşılıkları:" + sb);

        System.out.print("\n"+"Kodlanmış karakterleri çözme: ");
        if (isLeaf(root))
        {
            while (root.freq-- > 0)
            {
                System.out.print(root.ch);
            }
        }
        else
        {
            int index = -1;
            while (index < sb.length() - 1)
            {
                index = decodeData(root, index, sb);
            }
        }
    }

    public static void encodeData(index root, String str, Map<Character, String> huffmanCode)
    {
        if (root == null)
        {
            return;
        }
        if (isLeaf(root))
        {
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
        }
        encodeData(root.left, str + '0', huffmanCode);
        encodeData(root.right, str + '1', huffmanCode);
    }

    public static int decodeData(index root, int index, StringBuilder sb)
    {

        if (root == null)
        {
            return index;
        }

        if (isLeaf(root))
        {
            System.out.print(root.ch);
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decodeData(root, index, sb);
        return index;
    }

    public static boolean isLeaf(index root)
    {
        //her iki koşul da true değerini döndürürse true değerini döndürür
        return root.left == null && root.right == null;
    }

}