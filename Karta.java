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
public class Karta {
	
	private String figura;
	private String kolor;
	private int wartosc;
	
	public Karta( int kodK, int kodF ) {
		
		switch( kodK ) {
			case 1: kolor = "Karo"; break;
			case 2: kolor = "Trefl"; break;
			case 3: kolor = "Kier"; break;
			case 4: kolor = "Pik"; break;
			default: kolor = "brak"; break;
		}
		
		switch( kodF ) {
			case 1: figura = "As"; wartosc = 11; break;
			case 2: figura = "dwójka"; wartosc = 2; break;
			case 3: figura = "trójka"; wartosc = 3; break;
			case 4: figura = "czwórka"; wartosc = 4; break;
			case 5: figura = "piątka"; wartosc = 5; break;
			case 6: figura = "szóstka"; wartosc = 6; break;
			case 7: figura = "siódemka"; wartosc = 7; break;
			case 8: figura = "ósemka"; wartosc = 8; break;
			case 9: figura = "dziewiątka"; wartosc = 9; break;
			case 10: figura = "dziesiątka"; wartosc = 10; break;
			case 11: figura = "Walet"; wartosc = 10; break;
			case 12: figura = "Dama"; wartosc = 10; break;
			case 13: figura = "Król"; wartosc = 10; break;
			default: figura = "Joker"; wartosc = 0; break;	
		}
		
	}
	
	public String jakaKarta() {
		return figura + " " + kolor;
	}
	
	public int jakaWartosc() {
		return wartosc;
	}
	
}
