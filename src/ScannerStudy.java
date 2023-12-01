/*

인코딩 처리 방식
자바는 UTF-16을 사용한다 => 인코딩 시 널(NULL) 문자가 나타나지 않기 위해서

처리 과정(파일 인코딩을 UTF-8로 설정해놓았을 때)
입력(UTF-8) -> 송수신(modified UTF-8) -> 자바 메모리(UTF-16) -> 송수신(modified UTF-8) -> 출력(UTF-8)
시스템 설정에 맞춰 입력 받으면 UTF-16 규칙으로 인코딩되어 메모리에 올라감
이후 UTF-16 값을 시스템 설정에 맞춰 출력하는 방식

Stream이란 A에서 B로 물을 흐르게 해주는 관 역할으로

Scanner in = new Scanner(System.in)
에서 System.in이 System 클래스에서 in 이라는 변수라는 뜻이다.

고로 키보드 입력 등의 행위가 System.in을 통해 연결된다는 의미이다.

하지만 이 InputStream은 모든 데이터를 바이트 단위로 읽어오게 된다. (입력 바이트 스트림)

과정을 살펴 보자면 맨 처음 UTF-8로 입력을 받는다.
read() 메서드를 사용할 경우 맨 앞 1byte만 읽기 때문에 나머지 byte는 스트림에 잔존한다.
읽어온 바이트 값은 메모리에 UTF-16에 대응되는 문자로 2진수 값이 저장된다.
출력시 UTF-8로 변환되어 출력된다.

==> Scanner(System.in)은 입력 바이트 스트림인 InputStream을 통해 표준 입력을 받는다.

여기서 문자는 제대로 못 읽어오기 때문에 InputStreamReader(문자스트림)이 등장한다. (중개자 역할)

InputStreamReader
1. 바이트 단위 데이터를 문자 단위 데이터로 처리할 수 있도록 변환해줌.
2. char 배열로 데이터를 받을 수 있다.

Scanner에서 nextInt() 메서드는
nextInt(int radix)로 오버로딩 되고
buildIntegerPatternString()까지 가게 되는데 이 함수는 정규식대로 변환 후 반환하는 역할을 수행한다.
이것이 Scanner의 속도를 느려지게하는 범인이다.

Scanner의 과정
1. InputStream (바이트스트림) 을 통해 입력 받음
2. 문자로 온전하게 받기 위해 중개자 역할을 하는 InputStreamReader(문자스트림) 을 통해 char 타입으로 데이터를 처리함
3. 입력받은 문자는 입력 메소드( next(), nextInt() 등등.. ) 의 타입에 맞게 정규식을 검사함
4. 정규식 문자열을 Pattern.compile() 이라는 메소드를 통해 Pattern 타입으로 변환함
5. 반환된 Pattern 타입을 String으로 변환함
6. String 은 입력 메소드의 타입에 맞게 반환함 ( nextInt() - Integer.parseInt() / nextDouble() - Double.parseDouble() 등등.. )


BufferReader도 비슷한 원리이지만 BufferReader를 쓰는 장점은 문자열을 선언해야 한다는 단점을 상쇄한다는 것이다.
Buffer(버퍼)를 통해 입력받은 문자를 쌓아뒀다가 한번에 문자열처럼 보내버리는 것이다.

정리하자면 바이트 단위 [InputStream]로 문자를 입력받아 문자(character) [InputStreamReader]로 처리한 뒤
버퍼(buffer) [BufferedReader]에 담아두었다가 일정 조건이 되면 버퍼를 비우면서 데이터를 보내는 것이다.
InputStream -> InputStreamReader -> BufferReader

이렇게 Scanner처럼 복잡한 정규식의 검사를 하지 않아도 되어 성능이 좋다는 장점이 있지만
프로그래머가 직접 해당 데이터를 파싱해줘야 하는 단점도 존재한다.

 */