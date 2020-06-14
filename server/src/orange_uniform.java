import java.util.Vector;


	public class orange_uniform    {
		
		private String con="0";
		private String num;
		public static int turn=-1;
		
	
		public orange_uniform(String nu) {
			this.con=nu;
			//turn++;
			this.num=nu;
		//System.out.println(con);
			
			
			
			}
		public static long time = System.currentTimeMillis();
		public  void msg(String m) {
			 System.out.println(time +num+m);}
		
		private void executing(String t) {
			try {
				
				msg(" executing :" +t);
				Thread .sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
			}
		}
		
			 public void entryGoups() {
					
				 executing("creating group of 2 green and 1 orange");					
					
				}
			 public void  circlingArround() {
					executing("circling arround the stadium ");
					
				}
			 public void enterShow() {
				 Object convey =new Object();
				 synchronized(convey) {
				
					 if (monitor.showOn(convey)) {msg("Left the tent");
						 
							try {
								
								convey.wait();
							
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						 
				 }
				 }
				 msg("entered the show");
			 }
			 
	}
