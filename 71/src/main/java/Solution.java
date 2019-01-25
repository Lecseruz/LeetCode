import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    public static void main(String[] args)
    {
//        String path = "/a/./b/../../c/";
        String path = "/..asdsd/..";
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath(path));
    }

    public String simplifyPath(String path)
    {
        LinkedList<String> strings = new LinkedList<>();
        String[] array = path.split("/");
        for (String el : array)
        {
            if (el.equals("..") && !strings.isEmpty())
            {
                strings.pollLast();
            }
            else if (isWord(el))
            {
                strings.addLast(el);
            }
        }
        if (strings.isEmpty())
        {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!strings.isEmpty())
        {
            builder.append("/").append(strings.pollFirst());
        }
        return builder.toString();
    }

    public boolean isWord(String word){
        if(word.equals("")){
            return false;
        }
        if (word.equals(".")){
            return false;
        }
        if (word.equals("..")){
            return false;
        }
        return true;
    }
}
