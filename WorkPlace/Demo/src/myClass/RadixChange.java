package myClass;

public class RadixChange {
    //十进制整数转其他进制
    public static String TenChangeRadix(int num, int toRadix){
        StringBuffer sb = new StringBuffer();
        int q=0;
        int r=0;
        while(true){
            if (num>=toRadix){
                q=num/toRadix;
                r=num%toRadix;
                num=q;
                sb.append(r);
            }else
                break;
        }
        sb.append(q);
        return sb.reverse().toString();
    }
    //其他进制整数转十进制数,传入字符串整数和进制基数，返回十进制数
    public static int otherRedixChangeTen(String num, int fromRadix){
        int n = 0;
        char c = 0;
        int m = 1;
        int tens = 0;
        for (int i = 0,l = num.length(); i < l; i++) {
            c = num.charAt(l-1-i);
            if (c>='0' && c<='9'){
                tens=c-'0';
            }else if (c>='a' && c<='z') {
                tens=c-'a'+10;
            }else if (c>='A' && c<='Z') {
                tens=c-'A'+10;
            }
            if(i>0)
                m *= fromRadix;
            n += tens * m;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(TenChangeRadix(11,2)+"|"+
                otherRedixChangeTen("aa",16));
    }
}