# Cucumber tesztek készítése

## Feladat kijelölése

A feladathoz BDD megközelítést alkalmaztam, és Cucumber segítségével teszteket írtam hozzá

# Részletes leírás

Először megismerkedtem a BDD-vel, mint fejlesztési móddal, valamint a Cucumberrel, mint eszközzel ennek megvalósításához.
A munka elkezdése előtt be kellett konfigurálni a fejlesztőkörnyezetet, ez sok időt igénybevett.
Ezután a már létező Unit teszteket használtam inspirációként a Cucumber tesztek írásához.
Ezek már tartalmaztak a Cucumber tesztekben is szükséges Junit teszteket. Így könnyedén tudtam
ezeket hasonlóan alkalmazni, amikor a tesztek validációját készítettem.
Alapvetően mindegyik tesztet hasonlóképpen strukturáltam, az első, "Given" annotációval ellátott
lépés valamilyen objektum(ok) inicializálását, adatokkal való feltöltését jelentette.
Ezután az objektum valamilyen függvényét hívtam meg, amik az adatok manipulációját idézte elő.
Ezután ellenőriztem az adat helyességét.
Így szerintem megfelelő módon igazítottam a teszteket a program viselkedéséhez, alkalmazva így a BDD elveket.