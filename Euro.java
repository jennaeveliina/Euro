/*
 * Lausekielinen ohjelmointi, ensimm‰inen Harjoitustyˆ, syksy 2014
 *
 * Java-ohjelma, joka tutkii euroseteleiden [1, 2] sarjanumeroja.
 * Ohjelmalla voi tarkastaa onko sarjanumero oikeellinen 
 * ja laskea sarjanumerolle tarkisteen.
 *
 * Jenna Halmetoja
 */
public class Euro{
   public static void main(String[] args){
      /*
       * Vakiot.
       */
      //Jatkokomento vakiona.
      final char JATKA = 'k';
      //Lopetus komento vakiona.
      final char LOPETA = 'e';
      //Vanha setelisarja.
      final char SARJA1 = '1';
      //Uudempi setelisarja.
      final char SARJA2 = '2';
      //virheilmoitus.
      final String VIRHE = "Virhe!";
      //merkkijonon pituus.
      final int PITUUS = 12;

      /*
       * Esitell‰‰n ja alustetaan selkeyden vuoksi 
       * tavalliset muuttujat ohjelman alussa.
       */
      //Setelisarjan valinta.
      char sarja = 0;
      //Sarjanumeron merkit.
      char merkki = 0;
      //kirjain-merkki lukuna.
      int luku = 0;
      //Valinta siit‰ jatketaanko kyselyj‰.
      char valinta = 0;
      //Luettujen lukujen summa.
      int summa = 0;
      //ensimm‰isen ja viimeisen numeron summat,
      //jos summa ei ole yksinumeroinen.
      int apuSumma1 = 0,apuSumma2 = 0;
      //apumuuttuja tarkistusluvun laskemiseen.
      int tarkiste = 0;
      //laskurimuuttuja, joka laskee kierroksia.
      int i = 1;
      //muutetaan k‰ytt‰j‰n syˆtteet merkkijonoksi.
      String kokoSarja = "";
      //Tutkitaan jatketaanko ohjelman suoritusta.
      boolean jatketaan = false;
      //tutkitaan onko syˆte ok.
      boolean syoteOK = false;
      //tutkitaan onko sarjanumero oikea.
      boolean oikein = false;
      //tutkitaan onko merkki i:n paikassa oikeanlainen.
      boolean merkkiOK = false;
      //tutkitaan t‰ytyykˆ laskea tunniste.
      boolean lasketaanTunniste = false;

      //Tulostetaan ohjeteksti
      System.out.println("Moi! Tutkin euroseteleiden sarjanumeroja.");
      /*
      * P‰‰silmukka, toistetaan kunnes
      * k‰ytt‰j‰ haluaa lopettaa.
      */
      do{
         // Kysyt‰‰n kumpaa setelisarjaa tutkitaan:
         do{
            System.out.println("Setelisarja (1/2)?");
            sarja = In.readChar();
            
            // Jos valinta ei ole 1 tai 2 tulostetaan virheilmoitus.
            if(sarja != SARJA1 && sarja != SARJA2)
               System.out.println(VIRHE);
         }while(sarja != SARJA1 && sarja != SARJA2);
         
         //luetaan luvut kunnes lukuja on 12
         do{
            //pyydet‰‰n merkki‰ kunnes syote on ok 
            //kullekin i:n paikalle.
            do{
               //luetaan luvut k‰ytt‰j‰lt‰ ohjeistaen.
               System.out.println("Anna "+i+ ". merkki:");
               merkki = In.readChar();
               
               //merkki on ensimm‰inen ja iso kirjain
               //k‰‰nnet‰‰n lippumuuttujan arvo true:ksi.
               if(i == 1 && ('A' <= merkki && merkki <= 'Z'))
                  merkkiOK = true;
               
               //jos ei ole ensimm‰inen kierros ja merkki on numero
               else if(i > 1 && sarja == SARJA1 &&
               '0' <= merkki && merkki <= '9')
                  merkkiOK = true;
               
               //jos sarja2:n 2 ensimm‰ist‰ merkki‰ on isoja kirjaimia
               //k‰‰nnet‰‰n lippumuuttujan arvo true:ksi.
               else if(i == 2 && sarja == SARJA2 && 
               ('A' <= merkki && merkki <= 'Z'))
                  //k‰‰nnet‰‰n lippu
                  merkkiOK = true;
               
               //jos viimeinen merkki ja merkki on kysymysmerkki tai numero
               //k‰‰nnet‰‰n lippumuuttujan arvo true:ksi.
               else if(i == PITUUS && 
               (merkki == '?' || '0' <= merkki && merkki <= '9'))
                  //k‰‰nnet‰‰n lippu
                  merkkiOK = true;
               
               //jos toinen tai suurempi luettava merkki ja merkki on numero
               //k‰‰nnet‰‰n lippumuuttuja arvo true:ksi
               else if(i > 2 && sarja == SARJA2 && 
               '0' <= merkki && merkki <= '9')
                  //k‰‰nnet‰‰n lippu
                  merkkiOK = true;
               
               //jos syote on virheellinen.
               else{
                  System.out.println(VIRHE);
                  merkkiOK = false;
               } 
               //jos merkki on ok, muutetaan kirjain-merkki numeroksi
               //tai numeromerkki numeroksi.
               if(merkkiOK){
                  //muutetaan kirjain-merkki numeroksi.
                  if(merkki == 'I' || merkki == 'R')
                     luku = 1;
                  else if(merkki == 'A' || merkki == 'J' || merkki == 'S')
                     luku = 2;
                  else if(merkki == 'B' || merkki == 'K' || merkki == 'T')
                     luku = 3;
                  else if(merkki == 'C' || merkki == 'L' || merkki == 'U')
                     luku = 4;
                  else if(merkki == 'D' || merkki == 'M' || merkki == 'V')
                     luku = 5;
                  else if(merkki == 'E'|| merkki == 'N' ||merkki == 'W')
                     luku = 6;
                  else if(merkki == 'F' || merkki == 'O' ||merkki == 'X')
                     luku = 7;
                  else if(merkki == 'G' || merkki == 'P' || merkki == 'Y')
                     luku = 8;
                  else if(merkki == 'H' || merkki == 'Q' || merkki == 'Z')
                     luku = 9;
                  else if(merkki == '?')                         
                     lasketaanTunniste = true;
                  else if('0' <= merkki && merkki <= '9') 
                     //muutetaan merkki numeroksi.
                     luku = merkki - '0';
               }
            }while(!merkkiOK);
            //tarkistetaan haluaako k‰ytt‰j‰ laskea tunnistenumeron.
            if (!lasketaanTunniste){
               //liitet‰‰n merkit merkkijonoon.
               kokoSarja = kokoSarja + merkki;
               //summataan merkit.
               summa = summa + luku;
            }
            
            //kasvatetaan kierroslaskuria.
            i++;
            
         }while(i <= PITUUS);
           
         //asetetaan i takaisin alkuarvoonsa 
         //seuraavaa kierrosta varten.
         i = 1;
         
         //jos summa ei ole yksinumeroinen
         do{
            //lasketaan luvun viimeinen ja ensimm‰inen numero
            apuSumma1 = summa / 10;
            apuSumma2 = summa % 10;
             
            //lasketaan ensimm‰isen ja viimeisen numeron summa.
            summa = apuSumma1 + apuSumma2;

         }while (summa > 9);
         //jos tarkastussumma on yhdeks‰n, sarjanumero on oikeellinen.
         if(summa == 9)
            oikein = true;
         else
            oikein = false;
         //lasketaan tarkiste, v‰hent‰m‰ll‰ summa luvusta 9.
         tarkiste = 9 - summa;
         
         //jos tarkiste on nolla,silloin tarkiste on aina yhdeks‰n,
         //n‰in tarkiste on aina v‰lilt‰ 1-9.
         if (tarkiste == 0){
            tarkiste = 9;
         }
           
         //liitet‰‰n merkit merkkijonoon 
         //jos lasketaan lasketaan tunniste
         if (lasketaanTunniste){
            kokoSarja = kokoSarja + tarkiste;
            oikein = true;
         }
         //Tulostetaan lopputulos.
         if(oikein){
            if (lasketaanTunniste)
               System.out.println("Sarjanumero on " + kokoSarja + ".");
            else
               System.out.println("Sarjanumero " + kokoSarja + " on oikeellinen.");
         }
         else
            System.out.println("Sarjanumero " + kokoSarja + " on virheellinen.");
         
         // Resetoidaan, ett‰ saadaan seuraavan kierroksen sarjat oikein. 
         lasketaanTunniste = false;
         kokoSarja = "";
         merkkiOK = false;
         summa = 0;

         //Silmukka, jossa p‰‰tell‰‰n halutaanko jatkaa vai ei.
         do {
            // Luetaan k‰ytt‰j‰n valinta
            System.out.println("Jatketaanko (" + JATKA + "/" + LOPETA + ")?");
            valinta = In.readChar();
            if(valinta != JATKA && valinta != LOPETA)
               System.out.println(VIRHE);
            // Asetetaan lippumuuttujan arvo.
            if(valinta == JATKA || valinta == LOPETA)
               syoteOK = true;
            else
               syoteOK = false;
         }while (!syoteOK);

         // Jos valinta on 'k', silloin jatketaan.
         if (valinta == JATKA)
            jatketaan = false;
         //jos valinta on 'e', ohjelman suoritus lopetetaan.
         else
            jatketaan = true;
      
      //p‰‰silmukka p‰‰ttyy.
      }while (!jatketaan);
      
      // Tulostetaan lopputervehdys.
      System.out.println("Kiitokset - tavataan taas.");
  }
}