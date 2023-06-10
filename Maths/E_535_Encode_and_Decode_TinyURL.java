public class Codec {
    Map<Integer,String> map = new HashMap<>();
    String prefix = "http://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Integer r = Integer.valueOf((int)Math.random()*100);
        while(map.containsKey(r)){
            r = Integer.valueOf((int)Math.random()*100);
        }
        map.put(r,longUrl);
        return prefix+r.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] urlArr = shortUrl.split(".com/");
        if(urlArr.length==2){
            if(map.containsKey(Integer.valueOf(urlArr[1]))){
                return map.get(Integer.valueOf(urlArr[1]));
            }
        }
        return "";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));