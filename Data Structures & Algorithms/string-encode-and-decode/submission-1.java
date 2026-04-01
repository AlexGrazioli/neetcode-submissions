class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String str : strs) {
            builder.append(str.length()).append("#");
            builder.append(str);
        }
        System.out.println(builder);
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder builder = new StringBuilder();
            StringBuilder number = new StringBuilder();
            char currentChar = str.charAt(i);
            while (currentChar != '#') {
                number.append(str.charAt(i));
                i++;
                currentChar = str.charAt(i);
            }
            System.out.println(number);
            int stringLength = Integer.parseInt(number.toString()) + i;
            while (i < stringLength) {
                i++;
                builder.append(str.charAt(i));
            }
            System.out.println(builder);
            strs.add(builder.toString());
        }

        return strs;
    }
}
