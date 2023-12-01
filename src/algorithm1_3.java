/*
설명

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.

문장속의 각 단어는 공백으로 구분됩니다.


입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한

단어를 답으로 합니다.

*/

import java.util.Scanner;
public class algorithm1_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){
            int len= x.length();
            if(len>m){
                m=len;
                answer = x;
            }
        }
        /*
        indexOf() 함수는 괄호 안에 들어가는 문자 발견시 해당 번호 리턴, 발견 못할 시 -1을 리턴하는 함수이다.

        띄어쓰기를 발견 못하면 -1 리턴, 발견하면 해당 인덱스 번호 리턴
        ex) it is time to study
        i가 0번 t가 1번 띄어쓰기가 2번 ==> 2를 리턴
        이 인덱스 번호까지 substring으로 잘라냄

        while((pos=str.indexOf(' ') != -1){
            String tmp = str.substring(0, pos); //이것은 0부터 pos전까지 자름 ==> it 까지 자름
            int len = tmp.length();
            if(len>m){ //긴 단어가 여러개일경우 가장 앞쪽 단어를 써야하기 때문에 >= 가 아닌 > 만 하는것이다.
                m=len;
                answer=tmp;
            }
            str=str.substring(pos+1); //substring 인자가 하나면 해당 숫자 이후로 끝까지 자름 => is time to study 로 갱신됨
        }
        if(str.length()>m) answer=str; //마지막 단어가 study라 가장 긴데 띄어쓰기가 없으므로 while문에 못들어가기 때문에 이를 방지하고자 수행
         */
        System.out.println(answer);
    }
}
