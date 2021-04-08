package 接口类;
import java.util.Scanner;
import java.util.Random;
public class Game1 {
 Actor setActor(String type,String state) {
	 if(type.equals("Warrior")) {		 
		 Warrior a=new Warrior(state);
		 return a;
	 }
	 else {
		 Master a=new Master(state);
		 return a;
	 }
 }
class Master extends Actor{
	Master(String state){
		super(100,0,"Master",300,2,state);	
	}
			
void attack(Actor enemy) {
	if(enemy.name.equals("Warrior")) {
		enemy.blood-=(attacknum*2)/enemy.defensefactor;
	}
	else
		enemy.blood-=attacknum/enemy.defensefactor;			
	}
	}
class Warrior extends Actor{
	Warrior(String state){
		super(300,1,"Warrior",100,3,state);		
	}
	void attack(Actor enemy){
		if(enemy.name.equals("Warrior"))
			enemy.blood-=(attacknum*2)/enemy.defensefactor;
		else 
			enemy.blood-=attacknum/enemy.defensefactor;
	}
}
Actor randomActor() {
	Random r=new Random();
	int temp=r.nextInt(2);
	int temp1=r.nextInt(2);
	if(temp==0) {
		if(temp1==0)
		 {Master a=new Master("Defense");
		return a;}
		else {
			Master a=new Master("Attack");
			return a;
		}	
	}
	else {
		if(temp1==0)
		 {Warrior a=new Warrior("Defense");
		return a;}
		else {
			Warrior a=new Warrior("Attack");
			return a;
		}			
	}
}	
void play()	{
	Scanner sc=new Scanner(System.in);
	System.out.print("请选择角色：Warrior或者Master");
	String actor=sc.next();
	System.out.print("请选择操作：Defense或者Attack");
	String actortype=sc.next();
	Game1 g=new Game1();
	Actor actor1=g.setActor(actor,actortype);
		Actor actor2=randomActor();
		actor1.toString2();
		actor2.toString2();
		if(actor1.state.equals("Attack")&&actor2.state.equals("Attack")){
			actor1.attack(actor2);
			actor2.attack(actor1);
		}
		else if(actor1.state.equals("Defense")&&actor2.state.equals("Attack")) {
			actor1.defense();
			actor2.attack(actor1);	
			actor1.removedefense();
		}
		else if(actor1.state.equals("Attack")&&actor2.state.equals("Defense")) {
			actor2.defense();
			actor1.attack(actor2);
			actor2.removedefense();
		}		
		if(actor1.blood>actor2.blood) {
			System.out.println("You are the winner!");
			actor1.toString1();
		}
		else if(actor1.blood<actor2.blood) {
			System.out.println("You are the loser!");
			actor2.toString1();	
		}
		else {
			System.out.println("Drew!");
			actor1.toString1();	
			actor2.toString1();	
		}
}
}
