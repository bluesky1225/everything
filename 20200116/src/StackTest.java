import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack <String> stack = new Stack();
		
		// 데이터 저장은 push LIFO
		stack.push("안중근");
		stack.push("윤봉길");
		stack.push("김좌진");
		
		// 마지막 데이터 삭제하면서 가져오기
		String human = stack.pop();
		
		System.out.println(human);
		
		// 마지막 데이터 삭제하지 않고 가져오기
		human = stack.peek();
		System.out.println(human);
		human = stack.peek();
		System.out.println(human);
		human = stack.peek();
		System.out.println(human);
		
		
		
	}
}
