# Egységtesztek

### Feladat kijelölése
Egységtesztek írása a kód dinamikus viselkedésének vizshálatához.


### Egységtesztek leírása

Az alábbiakban röviden bemutatjuk 
az egyes osztályokhoz kötődő tesztmetódusokat


#### ExponentialMATest

- **checkSmooth():** Ellenőrizzük, hogy az exponenciális mozgóátlag simítási paramétere ($\alpha$) 
megfelel-e a mozgóátlag tagszámának. A két érték között egyértelmű megfeleltés van.
  
- **checkCalc():** Exponenciális mozgóátlag értékének ellenőrzése, MATLAB alapján.

- **checkArgument():** Ellenőrizzük, hogy a megfelelő típusú kivétel (*IllegalArgumentException*) dobódik-e érvénytelen
árkomponens (pl. "Min") megadásakor. 


#### SimpleMATest

- **checkCalc():** Egyszerű mozgóátlag értékének ellenőrzése, MATLAB alapján.

- **checkArgument():** Ellenőrizzük, hogy a megfelelő típusú kivétel (*IllegalArgumentException*) dobódik-e érvénytelen
  árkomponens (pl. "Min") megadásakor.


#### CSVReaderTest

- **checkRead():** Ellenőrizzük, hogy a megfelelő típusú kivétel 
  (*IOException*) dobódik-e érvénytelen fájlnév megadásakor.


#### OptimizerTest

- **maxWRTest():** Ellenőrizzük, hogy a winning ratio-t maximalizálva 
  helyesen választunk-e a különböző konfigurációjú Trader-ek közül. 

- **maxWRValueTest():** Ellenőrizzük a legjobb winning ratio értékét. 

- **maxProfitTest():** Ellenőrizzük, hogy a Profitot maximalizálva
  helyesen választunk-e a különböző konfigurációjú Trader-ek közül.

- **maxProfitValueTest():** Ellenőrizzük a maximális profit értékét.


#### PortfolioTest

- **checkWinnigRatio():** Ellenőrizzük, hogy helyesen történik-e a kereskedés során elért
  winning ratio értékének kiszámítása.

- **checkNetProfit():** Ellenőrizzük, hogy helyesen történik-e a kereskedés során
  realizált profit értékének kiszámítása. 


#### TraderTest

- **ctorTraderTest():** Ellenőrizzük, hogy az elvárt típusú kivétel 
  (*IllegalArgumentException*) dobódik-e, amennyiben a Trader-nek érvénytelen típusú
  indikátort (mozógátlagot) adunk meg. 


#### TimeSeriesTest

- **checkGetLength():** Ellenőrizzük, hogy a minta elemszáma egyezik-e a beolvasott input adathalmaz méretével.

- **checkConvert():** Ellenőrizzük, hogy az egyes idősíkok közötti konverzió (M15 -> H1) helyesen történik-e?

- **checkArgument():** Ellenőrizzük, hogy az elvárt típusú kivétel dobódik-e, ha nem támogatott idősíkok (M15, H1, D1) 
  között szeretnénk konverziót végrehajtani.

  