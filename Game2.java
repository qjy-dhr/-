package 接口类;
import java.util.Random;
import java.util.Scanner;
public class Game2 {
	
	void release(String a,int id,Actor enemy,int blood) {
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		int temp=r.nextInt(3);
		if(a.equals("Warrior")) {
			if(temp==0) {
				System.out.printf("Warrior%d唱了一首五音不全的歌，%s%d受不了了自己掉了%d点血..(^o^)\n",id,enemy.name,enemy.id,blood);
			
			}
			else if(temp==1) {
				System.out.printf("Warrior%d使用了火球术，烧掉了%s%d的%d点血!(~o~)\n",id,enemy.name,enemy.id,blood);
				
			}
			else {
				System.out.printf("Warrior%d使用了冰冻术，冻了%s%d点血..~(*o*~)\n",id,enemy.name,enemy.id,blood);
		
				
			}
		}
		else if(a.equals("Master")) {
			if(temp==0) {
				System.out.printf("Master%d揪掉了%s%d最后的三根头发，气掉了%s%d的%d点血!(@v@)\n",id,enemy.name,enemy.id,enemy.name,enemy.id,blood);
			}
			else if(temp==1) {
				System.out.printf("Master%d打了%s%d一巴掌，打掉了%d点血..(ToT)\n",id,enemy.name,enemy.id,blood);		
			}
			else {
				System.out.printf("Master%d使用了野蛮冲撞，撞掉了%s%d的%d点血..(0o0)\n",id,enemy.name,enemy.id,blood);
				
			}
			
		}
		else {
			if(temp==0) {
				System.out.printf("Vampire%d咬了%s%d的脖子一口，吸走了%d点血(o^^o)\n",id,enemy.name,enemy.id,blood);
			}
			else if(temp==1) {
				System.out.printf("Vampire%d变成蝙蝠传染了瘟疫，%s%d掉了%d点血(//o//)\n",id,enemy.name,enemy.id,blood);		
			}
			else {
				System.out.printf("Vampire%d使用了猩红冲刺，扎掉了%s%d的%d点血(;_;)\n",id,enemy.name,enemy.id,blood);
				
			}
		}
		
	}
	 Actor setActor(String type,String state,int id) {
		 if(type.equals("Warrior")) {		 
			 Warrior a=new Warrior(state,id);
			 return a;
		 }
		 else if(type.equals("Master")){
			 Master a=new Master(state,id);
			 return a;
		 }
		 else{
			 Vampire a=new Vampire(state,id);
			 return a;
		 }
	 }
	class Master extends Actor{
		Master(String state,int id){
			super(100,id,"Master",80,2,state);	
		}
				
	void attack(Actor enemy) {
		if(enemy.name.equals("Warrior")) {
			enemy.blood-=(attacknum*2)/enemy.defensefactor;
			release("Master",id,enemy,(attacknum*2)/enemy.defensefactor);
		}
		else
			{enemy.blood-=attacknum/enemy.defensefactor;	
		release("Master",id,enemy,attacknum/enemy.defensefactor);
		}
		}
	}
	class Vampire extends Actor{
		Vampire(String state,int id){
			super(200,id,"Vampire",60,2,state);	
		}
		void attack(Actor enemy) {
			int attack=attacknum*enemy.defensefactor;
			release("Vampire",id,enemy,attacknum/enemy.defensefactor);
			enemy.blood-=attack;
			blood+=attack*35/100;							
			}	
	}
	class Warrior extends Actor{
		Warrior(String state,int id){
			super(300,id,"Warrior",40,3,state);		
		}
		void attack(Actor enemy){
			if(enemy.name.equals("Warrior"))
				{enemy.blood-=(attacknum*2)/enemy.defensefactor;
			release("Warrior",id,enemy,(attacknum*2)/enemy.defensefactor);}
			else 
				{enemy.blood-=attacknum/enemy.defensefactor;
				release("Warrior",id,enemy,attacknum/enemy.defensefactor);
				}
		}
	}
	Actor randomActor(int id) {
		Random r=new Random();
		int temp=r.nextInt(3);
		int temp1=r.nextInt(2);
		if(temp==0) {
			if(temp1==0)
			 {Master a=new Master("Defense",id);
			return a;}
			else {
				Master a=new Master("Attack",id);
				return a;
			}	
		}
		else if(temp==1){
			if(temp1==0)
			 {Warrior a=new Warrior("Defense",id);
			return a;}
			else {
				Warrior a=new Warrior("Attack",id);
				return a;
			}			
		}
		else {
			if(temp1==0)
			 {Vampire a=new Vampire("Defense",id);
			return a;}
			else {
				Vampire a=new Vampire("Attack",id);
				return a;
			}		
		}
	}	
	void play()	{
		Scanner sc=new Scanner(System.in);
		System.out.println("角色创建:");
		String actor;
		while(true) {
		System.out.print("请选择角色：Warrior或者Master或者Vampire");
		 actor=sc.next();
		if(actor.equals("Warrior")||actor.equals("Master")||actor.equals("Vampire")) {
			break;
		}
		else {
			System.out.println("请正确输入");
			continue;
		}
		}
		String actortype;
		while(true) {
			System.out.print("请选择操作：Defense或者Attack");
			actortype=sc.next();
			if(actortype.equals("Defense")||actortype.equals("Attack")) {
				break;
				
			}
			else {
				System.out.println("请正确输入");
				continue;
			}
		}	
		Game2 g=new Game2();
		Actor actor1=g.setActor(actor,actortype,1);
			Actor actor2=randomActor(2);
			System.out.println("角色信息:");
			actor1.toString2();
			actor2.toString2();
			System.out.println();
			int temp=0;
			while(true) {
				if(temp>=1) {
					int temp1=temp+1;
					System.out.printf("第%d回合，请选择操作：Defense或者Attack",temp1);
					String actortype1=sc.next();	
					actor1.state=actortype1;
					Random r=new Random();
					int p=r.nextInt(2);
					if(p==1) {
						actor2.state="Defense";
					}
					else actor2.state="Attack";			
				}
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
				
				temp++;
				if(actor1.blood>0&&actor2.blood>0) {				
					System.out.printf("第%d回合",temp);
					System.out.println();
					actor1.toString2();
					actor2.toString2();
					System.out.println();
				}			
				else {
					if(actor1.blood<0) {
						actor1.blood=0;
						}
					else if(actor2.blood<0) {
						actor2.blood=0;
					}
					
				System.out.printf("第%d回合",temp);
				System.out.println();
				actor1.toString2();
				actor2.toString2();
				System.out.println();
				break;
				}
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
