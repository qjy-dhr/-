package 接口类;

public class Actor {
//extends Game 
//implements CanPlay 
	int blood;
	int id;
	String name;
	int attacknum;
	int defensefactor;
	String state;//声明
	Actor(int blood,int id,String name,int attacknum,int defensefactor,String state){
		this.blood=blood;
		this.id=id;
		this.name=name;
	    this.attacknum= attacknum;
	    this.defensefactor= defensefactor;
		this.state=state;	
	}
	void toString2() {
			System.out.printf("character%d:%s %d %s",id,name,blood,state);
			System.out.println();
	}
	void toString1() {
		System.out.printf("%s actor%d Blood:%d",name,id,blood);
		System.out.println();
}
	void defense() {
		defensefactor++;
		attacknum=attacknum+10;
	}
	void removedefense() {
		defensefactor--;
	}
	void attack(Actor enemy){
	}
}