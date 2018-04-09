/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;

/**
 *
 * @author Tallos
 */
public class Talia {
	
	private final Karta[] talia = new Karta[52];
	private int wskaznik = 0;
	
	public Talia() {
		stworzPelnaTalie();
		tasujPelnaTalie();
	}
	
	private void stworzPelnaTalie() {
		
		for( int k = 1; k <= 4; k++ ) {
			for( int f = 1; f <= 13; f++ ) {
				talia[wskaznik] = new Karta( k, f );
				wskaznik++;
			}
		}
		
	}
	
	private void tasujPelnaTalie() {
			
		Karta temp;
		Random gen = new Random();
		int ran;

		for( int i = 0; i <= 51; i++ ) {
			ran = gen.nextInt( 52 );
			temp = talia[i];
			talia[i] = talia[ran];
			talia[ran] = talia[i];
		}
		
	}
	
	public Karta wezKarte() {
		
		wskaznik--;
		return talia[wskaznik];
		
	}
	
}
