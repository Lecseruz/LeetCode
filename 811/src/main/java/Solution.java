import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution
{
    public List<String> subdomainVisits(String[] cpdomains)
    {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains)
        {
            String[] array = cpdomain.split(" ");
            String[] frags = array[1].split("\\.");
            int count = Integer.valueOf(array[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }
        return map.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(
                Collectors.toList());
    }
}