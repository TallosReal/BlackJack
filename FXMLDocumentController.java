/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author Tallos
 */
public class FXMLDocumentController implements Initializable {
	
	@FXML
	public Label labelInfo, punktyGracza, punktyKrupiera;
	public Button btnStart, btnDobierz, btnStop;
	public TextArea kartyGracza, kartyKrupiera;
	
	public Talia taliaGlowna;
	public Reka rekaGracza, rekaKrupiera;
	public String nowaKarta;
	
	@FXML
	private void startGry(ActionEvent event) throws InterruptedException {
		
		labelInfo.setText( "Gramy!" );
		kartyGracza.clear();
		kartyKrupiera.clear();

		taliaGlowna = new Talia();
		rekaGracza = new Reka();
		rekaKrupiera = new Reka();

		nowaKarta = rekaKrupiera.dobierzKarte( taliaGlowna ).jakaKarta();
		kartyKrupiera.appendText( nowaKarta );
		nowaKarta = rekaGracza.dobierzKarte( taliaGlowna ).jakaKarta();
		kartyGracza.appendText( nowaKarta );
		nowaKarta = rekaKrupiera.dobierzKarte( taliaGlowna ).jakaKarta();
		kartyKrupiera.appendText( '\n' + nowaKarta );
		nowaKarta = rekaGracza.dobierzKarte( taliaGlowna ).jakaKarta();
		kartyGracza.appendText( '\n' + nowaKarta );
		
		punktyGracza.setText( "Punkty: " + Integer.toString( rekaGracza.obliczWartosc() ));
		punktyKrupiera.setText( "Punkty: " + Integer.toString( rekaKrupiera.obliczWartosc() ));

		if( rekaKrupiera.obliczWartosc() == 21 || rekaGracza.obliczWartosc() == 21 ) {
			if( rekaKrupiera.obliczWartosc() > rekaGracza.obliczWartosc() ) { labelInfo.setText( "Krupier ma 21 punktów! Wygrana krupiera." ); }
			else if( rekaKrupiera.obliczWartosc() < rekaGracza.obliczWartosc() ) { labelInfo.setText( "Gracz ma 21 punktów! Wygrana gracza." ); }
			else { labelInfo.setText( "Obaj uczestnicy mają po 21 punktów! Remis." ); }
		} else {
			btnDobierz.setDisable( false );
			btnStop.setDisable( false );
		}
		
	}
	
	@FXML
	private void dobieraGracz(ActionEvent event) {
		
		nowaKarta = rekaGracza.dobierzKarte( taliaGlowna ).jakaKarta();
		kartyGracza.appendText( '\n' + nowaKarta );
		punktyGracza.setText( "Punkty: " + Integer.toString( rekaGracza.obliczWartosc() ));

		if( rekaGracza.obliczWartosc() > 21 ) {
			labelInfo.setText( "Gracz ma więcej niż 21 punktów. Wygrana krupiera." );
			btnDobierz.setDisable( true );
			btnStop.setDisable( true );
		}

	}
	
	@FXML
	private void dobieraKrupier(ActionEvent event) throws InterruptedException {
		
		while( rekaKrupiera.obliczWartosc() < 17 ) {
			nowaKarta = rekaKrupiera.dobierzKarte( taliaGlowna ).jakaKarta();
			kartyKrupiera.appendText( "\n" + nowaKarta );
			punktyKrupiera.setText( "Punkty: " + Integer.toString( rekaKrupiera.obliczWartosc() ));
		}

		if( rekaKrupiera.obliczWartosc() > 21 ) {
			labelInfo.setText( "Krupier ma więcej niż 21 punktów. Wygrana gracza." );
		} else if( rekaKrupiera.obliczWartosc() == 21 || rekaGracza.obliczWartosc() == 21 ) {
			if( rekaKrupiera.obliczWartosc() == 21 && rekaGracza.obliczWartosc() != 21 ) {
				labelInfo.setText( "Krupier ma 21 punktów! Wygrana krupiera." );
			} else if( rekaKrupiera.obliczWartosc() != 21 && rekaGracza.obliczWartosc() == 21 ) {
				labelInfo.setText( "Gracz ma 21 punktów! Wygrana gracza." );
			} else {
				labelInfo.setText( "Obaj uczestnicy mają po 21 punktów! Remis." );
			}
		} else {
			if( rekaKrupiera.obliczWartosc() > rekaGracza.obliczWartosc() ) {
				labelInfo.setText( "Krupier ma więcej punktów. Wygrana krupiera." );
			} else if( rekaKrupiera.obliczWartosc() < rekaGracza.obliczWartosc() ) {
				labelInfo.setText( "Gracz ma więcej punktów. Wygrana gracza." );
			} else {
				labelInfo.setText( "Obaj uczestnicy mają tyle samo punktów. Remis." );
			}
		}
		
		btnDobierz.setDisable( true );
		btnStop.setDisable( true );
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}	
	
}
