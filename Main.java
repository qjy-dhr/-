package 接口类;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请选择游戏类型：Game1或者Game2");
		Scanner sc=new Scanner(System.in);
		String type;
		while(true) {
			type=sc.nextLine();
			if(type.equals("Game1")||type.equals("Game2")) {
				break;
			}
			else {
				System.out.println("请输入正确的内容！");
				continue;
			}
		}
		
		if(type.equals("Game1")) {
		Game1 game1=new Game1();
        game1.play();	
		}
		else {
			Game2 game2=new Game2();
			game2.play();	
		}
	}
}
