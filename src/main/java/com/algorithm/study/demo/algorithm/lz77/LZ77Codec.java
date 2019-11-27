package com.algorithm.study.demo.algorithm.lz77;

/**
 * @author xun2.liu
 * @title: LZ77Codec
 * @projectName algorithm-study
 * @description: LZ77算法实现
 * @date 2019/11/25 0:54
 */
public class LZ77Codec {
    /**
     * 搜索最大相同字符串的辅助类
     */
    private class SearchResult{
        public int off = 0;
        public int length = 0;
    }

    /**
     * search the max matched string in the slide window;
     * 可以使用KMP算法提高效率
     * @param s 需要编码的字符串
     * @param currentPosition 当前位置
     * @return
     */
    private SearchResult search(String s,int currentPosition){
        SearchResult result = new SearchResult();
        for (int i = 0; i < currentPosition; i++) {
            SearchResult t = new SearchResult();
            for (int j = i; j < currentPosition; j++) {
                // 区别已匹配和没有匹配的情况
                if(s.charAt(currentPosition+j-i)==s.charAt(j)){
                    // 已经匹配的话 length+1
                    // 没有匹配的话 length=1 并计算偏移量
                    if(t.length >0){
                        t.length++;
                    }else{
                        t.length=1;
                        // 计算偏移量
                        t.off = currentPosition - j;
                    }
                }else {
                    break;
                }
            }
            if(t.length>result.length){
                result=t;
            }
        }
        return result;
    }
    /**
     * 编码
     *
     * 目前发现的问题
     * 1. 从左往右扫描和从右往左扫描off可能不一样
     * @param s 需要编码的字符串
     * @return 已经编码的字符串
     */
    String encoding(String s) {
        StringBuilder builder = new StringBuilder();
        // set current coding position pointer to the start of message
        int currentPosition = 0;
        while (true){
            // search the max matched string in the slide window;
            SearchResult result = search(s,currentPosition);
            System.out.println("result:"+result.off+" "+result.length+" "+s.substring(currentPosition,currentPosition+result.length+1));
            Character nextChar = s.charAt(currentPosition+result.length);
            if(result.length!=0){
                builder.append("(").append(result.off).append(",").append(result.length).append(",").append(nextChar).append(")");
                currentPosition+=result.length+1;
            }else {
                builder.append("(0,0,").append(nextChar).append(")");
                currentPosition++;
            }
            if(currentPosition>=s.length()){
                break;
            }
        }
        return builder.toString();
    }

    /**
     * 解码
     * @param s 已经编码的字符串
     * @return 已经解码的字符串
     */
    String decoding(String s) {
        StringBuilder builder = new StringBuilder();
        // 提取(off,length,next_char)
        String[] arr = s.split("\\)\\(");
        if (arr.length==0){
            return "";
        }
        arr[0]=arr[0].substring(1,arr[0].length());
        if(arr.length>1){
            arr[arr.length-1]=arr[arr.length-1].substring(0,arr[arr.length-1].length()-1);
        }
        for(String it : arr){
            String[] data = it.split(",");
            Integer off = Integer.valueOf(data[0]);
            Integer length = Integer.valueOf(data[1]);
            String nextChar = data[2];
            Integer iv = builder.length()-off;
            for (int i = 0; i < length; i++) {
                builder.append(builder.charAt(iv+i));
            }
            builder.append(nextChar);
            System.out.println("decoding:"+iv+" "+ builder.toString());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LZ77Codec codec = new LZ77Codec();
        String input = "AABCAABCCAABCE";
//        String output = "(0,0,A)(1,1,B)(0,0,C)(4,4,C)(5,4,E)";
        String code = codec.encoding(input);
        System.out.println(code);

        String message = codec.decoding(code);
        System.out.println(message);
    }
}
