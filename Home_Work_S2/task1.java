
public class task1 {
    public static void main(String[] args) {
        String str = "{'name':'Ivanov','country':'Russia','city':'Moscow','age':'null'}";
        System.out.println(assembleString(transformationStr(str)));
    }

    public static String[] transformationStr(String str){
        str = str.replace("{", "");
        str = str.replace("}", "");
        str = str.replace(":", "=");
        String[] arr = str.split(",");
        return arr;
    }

    public static StringBuilder assembleString(String[] arr){
        StringBuilder resString = new StringBuilder("select * from students where ");
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            int index = item.indexOf('=');
            System.out.println(item.substring(index + 1));
            if (!item.substring(index + 1).equals("'null'")){
                resString.append(item);
                resString.append(" and ");
            }
        }
        return resString.delete(resString.length() - 5, resString.length());
    }
}
