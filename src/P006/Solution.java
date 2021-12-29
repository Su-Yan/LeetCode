package P006;

public class Solution {

    //暴力求解
    public String convert(String s, int numRows) {
        int strLength=s.length();
        if (strLength==0||strLength==1||numRows==1){
            return s;
        }
        String res="";
        int rowGroupNum=strLength/(2*numRows-2);
        if (strLength%(2*numRows-2)!=0){
            rowGroupNum++;
        }
        int rowLenth=(numRows-1)*rowGroupNum;
        int key=0;
        boolean ckEnd=false;
        if (strLength!=0){
            ckEnd=true;
            char [][]strArray=new char[numRows][rowLenth];
            for (int i = 0; ckEnd&&i < rowGroupNum; i++) {
                int keyPos=-2;  //用来确定斜线方向上字母定位
                for (int j = 0; ckEnd&&j < numRows-1; j++) {   //列循环
                    int xPos = i*(numRows-1)+j; //真实X轴坐标
                    for (int k = 0; k < numRows; k++) { //行
                        if (j==0){
                            strArray[k][xPos]=s.charAt(key++);
                            keyPos++;
                            if (key>=strLength){
                                ckEnd=false;
                                break;
                            }
                            continue;
                        }
                        strArray[keyPos--][xPos]=s.charAt(key++);
                        if (key>=strLength){
                            ckEnd=false;
                            break;
                        }
                        break;
                    }
                }
            }
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < rowLenth; j++) {
                    if (strArray[i][j]!='\0'){
                        res+=strArray[i][j];
                    }
                }
            }
        }
        return  res;
    }

//    public String convert2(String s,int numRows){
////        int strLength=s.length();
////        if (strLength==0||strLength==1||numRows==1){
////            return s;
////        }
////        int []pos=new int[strLength];
////        int lastZeroIndex=-1;
////        for (int i = 0; i < strLength; i++) {
////            pos[i]=-1;
////        }
////        for (int i = 0; i*(2*numRows-2) < strLength; i++) {
////            pos[i*(2*numRows-2)]=0;
////            lastZeroIndex=i*(2*numRows-2);
////        }
////        int key=1;
////        for (int i = 0; i < strLength; i++) {
////            if (pos[i]==0){
////                key=1;
////                continue;
////            }
////            pos[i]=key++;
////        }
////        key=1;
////        for (int i = lastZeroIndex-1; i >=0 ; i--) {
////            if (pos[i]==0){
////                key=1;
////                continue;
////            }
////            if (pos[i]==key){
////                continue;
////            }
////            pos[i]=key++;
////        }
////
////    }

    public String convert2(String s,int numRows){
        String res="";
        int strLen=s.length();
        if (strLen==0||strLen==1||numRows==1){
            return s;
        }
        char strArray[]=s.toCharArray();
        int []pos=new int[strLen];
        int ckStatus=0;
        int cnt=0;
        for (int i = 0; i < strLen; i++) {
            pos[i]=cnt;
            switch (ckStatus){
                case 0:
                    cnt++;
                    break;
                case 1:
                    cnt--;
                    break;
            }
            if (cnt==numRows){
                ckStatus=ckStatus==0?1:0;
                cnt-=2;
            }else if (cnt<=0){
                cnt=0;
                ckStatus=ckStatus==0?1:0;
            }
        }
        String []tmp=new String[numRows];
        for (int i = 0; i < numRows; i++) {
            tmp[i]="";
        }
        for (int i = 0; i < strLen; i++) {
            tmp[pos[i]]+=strArray[i];
        }
        for (int i = 0; i < numRows; i++) {
            if (tmp[i]==null){
                continue;
            }
            res+=tmp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String s="PAYPALISHIRING";
        System.out.println(solution.convert(s,4));
        System.out.println(solution.convert2(s,4));
        s="ABCD";
        System.out.println(solution.convert(s,2));
        System.out.println(solution.convert2(s,2));
    }
}
