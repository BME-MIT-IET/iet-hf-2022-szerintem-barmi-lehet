# Statikus analizis

## Build keretrendszer beüzemelése

A statikus analízist végző eszköz működéséhez szükség volt a build keretrendszer és CI beüzemelésére. A build keretrendszer Maven lett. Ezt az IntelliJ IDEA segítségével adtuk hozzá. Sajnos a pom.xml, ami létrejött hibás volt, ezért sok időt kellett töltenünk hibakereséssel. A végén kiderült, hogy hibás verzió volt a pom.xml-ben, miután ezt kijavítottuk működött rendesen minden. A CI beüzemeléséhez egy új workflowt kellett létrehozni, ez problémamentesen ment.

## SonarCloud használata

Miután elvégeztük az előző lépeseket és létrehoztunk egy új Secret-et a SonarCloud számára, utána már sikeresen analizálta is a projektünket. Rengeteg Code Smellt talált, ezek egy részét javítottuk. Ezek mellett még talált biztonsági kockázatokat is, ezeket mindet helyrehoztuk. A kódban többször is szerepelt hibakezelésként, hogy printStackTrace(), ami túl sok információt adhat ki. Ez a funkció akkor jó, ha debugolni akarunk.
Bugot is talált néhányat, ezeket is mindet javítottuk. Ezek főleg abból álltak, hogy felesleges elágazások voltak a kódban, több kifejezés is mindig igaz-ra értékelődött ki.