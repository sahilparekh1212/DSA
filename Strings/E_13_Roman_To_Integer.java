class Solution {
    public int romanToInt(String s) {
        // HashMap<String,Integer> hm = new HashMap<>();
        // hm.put("I",1);
        // hm.put("IV",4);
        // hm.put("V",5);
        // hm.put("IX",9);
        // hm.put("X",10);
        // hm.put("XL",40);
        // hm.put("L",50);
        // hm.put("XC",90);
        // hm.put("C",100);
        // hm.put("CD",400);
        // hm.put("D",500);
        // hm.put("CM",900);
        // hm.put("M",1000);

        // int i=0;
        // int sum = 0;
        // int sLength = s.length();
        // while(i<sLength){
        // if(i+1<sLength && hm.containsKey(s.substring(i,i+2))){
        // sum += hm.get(s.substring(i,i+2));
        // i = i+2;
        // }else{
        // sum += hm.get(s.charAt(i)+"");
        // i = i+1;
        // }
        // }
        // return sum;

        int sum = 0;
        int i = s.length() - 1;
        int currentDigit = 0;
        while (i >= 0) {
            switch (s.charAt(i)) {
                case 'I':
                    currentDigit = 1;
                    break;

                case 'V':
                    currentDigit = 5;
                    break;

                case 'X':
                    currentDigit = 10;
                    break;

                case 'L':
                    currentDigit = 50;
                    break;

                case 'C':
                    currentDigit = 100;
                    break;

                case 'D':
                    currentDigit = 500;
                    break;

                case 'M':
                    currentDigit = 1000;
                    break;

                default:
                    break;
            }
            i--;
            if (4 * currentDigit < sum) {
                sum -= currentDigit;
            } else {
                sum += currentDigit;
            }
        }
        return sum;
    }
}