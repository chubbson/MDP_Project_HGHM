Salut
Methoden der Programmierung 
Hauri, Homberger, Marcin, Gamma

Klene git Einführung: 

Bei erstmaligem konfigurieren: 
  git config --global user.name "Your Name"
  git config --global user.email chubbson@gmail.com

Um Lokaler Ordner auf ein bestehendes Repo zu verlinken  
  cd existing_git_repo
  git remote add origin git@github.com:chubbson/MDP_Project_HGHM.git
  git push origin master

Um zusammen auf einem Repo arbeiten zu können, könnt ihr ein bestehendes Repo clonen. 
  cd collaborating git Repo
  git clone git@github.com:chubbson/MDP_Project_HGHM.git

Dateien Adden, add auf lokale neue datei ausführen
  git add TESTFILE.txt 
somit ist das TESTFILE getrackt, mit add müssen alle files die ihr tracken mit einem eigenen add tracken. 
  wollt ihr ein File trotzdem nich tracken, könnt ihr es aus der list mit checkout wieder rausnehmen
  git checkout TESTFILE.txt
Habt ihr viele dateien zum Tracken un möchtet ihr diese am liebsten in separaten Commits einchecken, könnt ihr auch ein gui zur hilfe nehmen. 
  git gui 
Oeffnet ein Gui mitwelchem ihr alle geänderten daten per 'Click auf das Datei Icon' Tracken könnt, Diese erscheinen dann im unteren Feld. 
Ein solche vorgang ist stellvertretende für ein add. 
Mit einem Klick auf das icon der Dateien in der unteren Liste lassen siech diese wieder untracken, was einem checkout entspricht. 

Um es dann lokal zu versionieren verwendet man den Befehl commit um alle getrackten daten einzuchecken, den kommentar mit -m nicht vergessen! 
  git commit -m 'Irgend ein Kommentar, beschreibt was geändert hat'

Um es im Repo in github zu verfügung zu stellen
  git push origin master 

Um zu prüfen ob man auf dem aktuellsten stand von Github ist, kann man gitk ausführen. Es erscheint ein tolles Fenster welches dir den History tree ausgibt mit der aktuellen Rev nr etc. 
  gitk

Inkl allen Branches
  gitk --all

Um Aktuelle daten aus dem git auszuchecken 
  git pull origin master 

Im masterbranch sollte nichts eingecheckt werden was nicht fertig, oder sauber entwickelt wurde. Sprich, CodeStyle eingehalten? CodeDokumentation vorhanden? UnitTest dafür geschrieben? 

Für ein sauberes design werden wir auf ende iteration auf den Master branchen. 
Der Master ist immer sauberzuhalten mit einer aktuellen lauffähigen Version. Pro Iteration wird ein Brunch erstellt. Für Lokale hacks sind selbstverständlich eigene Branches erlaubt

Maven: 
- Java Version:
Java- Installtation prüfen, mind 1.5 oder 1.6!!
> java -version
Nicht vergessen das die JAVA_HOME umgebungsvariable welches auf das jdk verweisst gesetzt ist. 

- Maven Installation 
Aktuelle version runterladen von http://maven.apache.org/download.html
In gewünschtem Ort entpacken, z.B. c:\Program Files\

Nun müssen Umgebungsvariablen gesetzt werden. 
> set M2_HOME=c:\Program Files\apache-maven-2.0.9
> set Path=%M2_HOME%\bin

- Maven version prüfen 
> mvn -v 
Maven 2.0.9

- HGHM mit Maven starten 
Um alle umgebungs Files und Ressourcen zu laden muss in dem Ordner wo sich das pom von HGHM befindet maven install ausgeführt werden. 
> cd D:/Develop/Java/HGHM
Hier liegt das pom.xml
> mvn install
Maven lädt nun alle fehlenden jars die im Projekt benötigt werden runter, 
probiert das Programm zu compilieren und führt gleich alle Unit Tests aus. 

>mvn test
Führt nur die Unit Tests aus

>mvn exec:java -Dexec.mainClass=ch.hszt.hs_2010.mdp.HGHM.RunHello 
Füht die Main Methode aus der Klasse RunHello aus. 

