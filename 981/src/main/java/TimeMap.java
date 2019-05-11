import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap
{
    private Map<String, List<Value>> map = new HashMap<>();

    public TimeMap()
    {

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Value(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Value> A = map.get(key);
        int i = Collections.binarySearch(A, new Value(timestamp, "{"), Comparator.comparingInt(Value::getTimestamp));

        if (i >= 0)
            return A.get(i).getValue();
        else if (i == -1)
            return "";
        else
            return A.get(-i-2).getValue();
    }

    class Value
    {
        private int timestamp;
        private String value;

        Value(int timestamp, String value)
        {
            this.timestamp = timestamp;
            this.value = value;
        }

        int getTimestamp()
        {
            return timestamp;
        }

        public void setTimestamp(int timestamp)
        {
            this.timestamp = timestamp;
        }

        String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }
    }
}