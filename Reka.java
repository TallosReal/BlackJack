/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Tallos
 */
public class Reka {
	
	private Karta[] reka = new Karta[12];
	private int licznik = 0;
	
	public Karta dobierzKarte( Talia talia ) {
		
		Karta nowa = talia.wezKarte();
		reka[licznik] = nowa;
		licznik++;
		return nowa;
				
	}
	
	public int obliczWartosc() {
		
		int wartosc = 0;
		for( int i = 0; i <= ( licznik-1 ); i++ ) {
			wartosc += reka[i].jakaWartosc();
		}
		return wartosc;
		
	}
		
}
