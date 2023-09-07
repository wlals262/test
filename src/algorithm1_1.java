// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
import java.util.Scanner;
public class algorithm1_1 {
    public static void main(String[] args) {
        // 캐럿을 강조 표시된 텍스트에 놓고 Alt+Enter을(를) 누르면
        // IntelliJ IDEA의 수정 제안을 볼 수 있습니다.
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char text1 = in.next().charAt(0);
        int count = 0;
        int temp;
        if(text1>=65 && text1<=90) //2번째 입력문 소문자화
            text1 = (char)((int)text1+32);
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)>=65 && str.charAt(i)<=90){
                temp = (int)str.charAt(i);
                if(temp+32 == (int)text1) count++;
            }
            else{
                if(str.charAt(i)==text1) count++;
            }
        }
        System.out.println(count);
    }
}