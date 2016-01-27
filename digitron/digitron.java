package digitron;

import java.util.Scanner; 

public class digitron {
	public static void main(String[] args) {
		Scanner ulaz = new Scanner(System.in);
		Boolean nastavak = true; //promenjiva koja ce na pocetku uvek biti true kako bi poceo racunanje
		while(nastavak){ //sve dok je promanjiva nastavak tacna, on ce ulaziti u petlju
			System.out.println("Unesite r za racunanje, h za pomoc ili e da napustite program");
			int stanje = ulaz.next().charAt(0); //skeniramo karakter koji prvi unesemo
			if(stanje == 'r' || stanje == 'R'){ //pitamo se da li je karakter malo ili veliko r i ako jeste ulazimo u proces izracunavanja
				System.out.println("Unesite brojeve i operaciju (npr. 2 + 3, OBAVEZNI RAZMACI IZMEDJU UNOSA) ");
				float br1 = ulaz.nextFloat(); //unos prvog broja
				String operand = ulaz.next(); //unos operanda
				float br2 = ulaz.nextFloat(); //unos drugog broja
				racun(br1, operand, br2);	 //pozovemo funkciju tipa void koja printuje rezultat na osnovu operanda
				
				
			}
			else if(stanje == 'h' || stanje == 'H'){ //ako uneti karakter nije r pitamo se da li je h. ako jeste h stampamo uputstva za rad sa programom
				System.out.println("Pomoc pri koriscenju digitrona: ");
				System.out.println("\t za sabiranje unesite brojeve u formatu br1 + br2");
				System.out.println("\t za oduzimanje unesite brojeve u formatu br1 - br2");
				System.out.println("\t za mnozenje unesite brojeve u formatu br1 * br2");
				System.out.println("\t za deljenje unesite brojeve u formatu br1 / br2");
				System.out.println("\t za celobrojno deljenje i ostatak unesite brojeve u formatu br1 % br2");
			}
			else if(stanje == 'e' || stanje == 'E'){ //ako uneti karakter nije r ni h pitamo se da li je e, ako je e, izlazimo iz programa
				System.out.println("Dovidjenja");
				nastavak = false; //da se ne bih vratio u petlju
				System.exit(1); //ili nastavak = false ili System.exit(1) rade potpuno isto
			}
			else{
				System.out.println("Nesipravan unos."); //ako nije ni e ni r ni h, kazemo da unos nije ispravan
				
			}
				
				
			}
			
		}
	
	private static void racun(float br1, String operand, float br2) { //funlkcija za racunanje
        switch (operand.charAt(0)) { //koristimo swithc za operand
        case '+': //ako je plus
        	if (((br1 - Math.round(br1)== 0) && ((br2 -Math.round(br2))==0))){ //ovo radim u svakom caseu. Pitam se da li je br1 i br2 - zaokruzeni br1 i br2 i ako jeste kastujem ih u int. Da nisam ovo uradio stampalo bi ako npr imas 5-2 rezultat bi bio 3.0 posto je promenjiva tipa float. A sa ovim proverim da li je broj unet kao ceo ili sa decimalom 
				System.out.printf("Zbir je: %d\n", (int)(br1+br2) ); //ovde stampam kastovane promenjive koje se saberu
			}
        	else{
        		float temp = br1 + br2; 
        		System.out.println("Zbir je: "+temp ); //ovo ako je unet broj sa decimalom, ostaje float. I tako u svakom caseu
        	}
        	break;
        case '-': //ako je minus
        	if (((br1 - Math.round(br1)== 0) && ((br2 -Math.round(br2))==0))){
				System.out.printf("Razlika je: %d\n", (int)(br1-br2) );
			}
        	else{ 
        		float temp = br1 - br2;
        		System.out.println("Razlika je: "+temp );
        	}
        	break;
        case '*': //ako je puta
        	if (((br1 - Math.round(br1)== 0) && ((br2 -Math.round(br2))==0))){
				System.out.printf("Proizvod je: %d\n", (int)(br1*br2) );
			}
        	else{
        		float temp = br1 * br2;
        		System.out.println("Proizvod je: "+temp );
        	}
        	break;
        case '/': //ako je podeljeno
        		if(br2==0){
        			System.out.println("Deljenje nulom nije moguce!"); //kod deljenja nemam onaj deo sa kastovanjem jer hocu da mi 5/2 bude 2.5. Samo proveravam da li je br2 nula i ako jeste stampam deljenje nulom nije moguec
        		}
        		else{
        			float temp = br1 / br2;
        			System.out.println("Kolicnik je: "+temp );
        		}
        	break;
        case '%': // i ako je mod (deljenje sa ostatkom)
        	if (((br1 - Math.round(br1)== 0) && ((br2 -Math.round(br2))==0))){
				System.out.printf("Ceo deo je: %d\nOstatak je: %d\n", (int)(br1/br2), (int)(br1%br2));
        	}
			else{
				System.out.printf("Ceo deo je: %f\nOstatak je: %f\n", (br1/br2),(br1%br2));
			}
        	break;
        default:
        	System.out.println("Nepoznat operand: " + operand); //ako je operant nesto sto nije + - * % / onda stampam nepoznat operand
        	
        	
        }
        
        
    }
}


