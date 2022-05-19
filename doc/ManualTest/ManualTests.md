# Manuális tesztelés

### Feladat kijelölése
Program tesztelése más formátumú adathalmazzal

### Részletes leírás
A program alapvetően kizárólag .csv fájlokból tudott adatot olvasni, ezért készítettem hozzá
egy JSON formátumú input olvasására alkalmas osztályt. Emellett bevezettem egy közös absztrakt
osztályt az új json olvasó és a már meglévő csv olvasó osztálynak, illetve megoldottam, hogy a
program ne beégetve tartalmazza, hogy melyik osztályt és milyen fájlt használjon inputnak, 
hanem konstruktorparaméterként kapja meg a felelős osztály.
A feladat kidolgozása során egy fontos bugot találtunk a Trader osztály trade függvényében. A metódusban
lévő iteráció leállási feltétele nem a legnagyobb idősíkot vette figyelembe, ezért a program az eredeti példa
inputtól eltérő bemenetre hibát dobott és leállt. Az eredeti adathalmaz esetében a 15 perces tőzsdei 
gyertya záró dátuma éppen egybe esett a napi gyertya záró dátumával, ezért iebben az esetben nem jelentkezett
a hiba, viszont az újonnan felvett json olvasó tesztelésekor használt adat esetében probléma volt. A hibát
sikerült kijavítani, a program helyesen működik json formátummal is.

A hiba kijavítása után néhány inputtal teszteltük az eredeti adathalmazon és az új json adathalmazon is 
a programot.
    

