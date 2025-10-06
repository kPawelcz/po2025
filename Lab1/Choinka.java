public class Choinka{
	public static void main(String[] args){
		int wysokosc = Integer.parseInt(args[0]);
		int licznik=0;
		String string="*";
		for(int i=1; i <= wysokosc; i++){
			licznik++; 
			System.out.println(string.repeat(licznik));
			
		}
		
	}
}