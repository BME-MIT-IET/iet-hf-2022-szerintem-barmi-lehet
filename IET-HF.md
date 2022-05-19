# Tőzsdei kereskedőrobot

A projekt egy tőzsdei kereskedőrobot paraméter-optimalizálását végzi el. A
robot működése egy meglehetősen egyszerű logikát követ: Három mozgóátlag (lassú, közepes,
és gyors) metszése alapján jelzi a piacra való belépési és kilépési pontokat. A lassú (alap
konfiguráció esetén 200 tagú) mozgóátlag jelöli ki a trend irányát. Ha az adott devizapár
(instrumentum) piacán azt látjuk, hogy emelkedő trend mellett a gyors (20 tagú) mozgóátlag
(továbbiakban: MA) alulról felelé metszi a közepest (50 tagú), akkor a robot vételi (long) pozíció
nyitását javasolja. Az így nyitott long pozíció zárására akkor kerül sor, ha a gyors MA ezek után
felülről lefelé metszi a köztes 50 tagú MA-t. Az eladási (short) pozíció nyitása és zárása az
előzőkkel analóg módon történik. 

A projektben van GUI is , ahol megadhatjuk, hogy az egyes tagszámokat milyen
korlátok között szeretnénk optimalizálni, így egy háromdimenziós paraméter-teret kapunk. Az
egyes paraméter-hármasok, pl.: {20; 50; 200}, {17; 47; 192} egy egyedi azonosítót (kulcs, key)
határoznak meg. Az egyedi kulcshoz tartozó érték (value) az a profit lesz, ami a belépési és kilépési
pontok között az adott piacon realizálható. Azt is beállíthatjuk majd, hogy milyen célváltozó
szerint történjen az optimalizáció: Ha a winnig-ratio-t szeretnénk maximalizálni, akkor a célunk
az, hogy egy veszteséges ügyletre lehetőleg minél több nyereséges tranzakció jusson. Egy másik
megközelítés alapján azt is mondhatjuk, hogy a nettó profit (összes nyereség – összes veszteség)
értékét szeretnénk maximalizálni.

Az eredményekről egy összefoglaló táblázatot is készítünk, ahol megvizsgáljuk, hogy a kezdeti
(alapértelmezett) paraméter értékek optimalizálásával mennyivel sikerült növelni a robot
hatékonyságát.
A projekt az EURUSD piac 15 perces idősíkjáról, 2010 és 2016 között rendelkezésre álló
adatállomány alapján (csv formátumú input adat) végzi el az optimalizálást. 