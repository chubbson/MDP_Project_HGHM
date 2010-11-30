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

Dateien Adden, add auf lokale neue date
  git add TESTFILE.txt

Um es dann lokal zu versionieren 
  git commit -m 'Irgend ein Kommentar, beschreibt was geändert hat'

Um es ins Repo in github zu verfügung zu stellen
  git push origin master 

Im masterbranch sollte nichts eingecheckt werden was nicht fertig, oder sauber entwickelt wurde. Sprich, CodeStyle eingehalten? CodeDokumentation vorhanden? UnitTest dafür geschrieben? 

Für ein sauberes design werden wir auf ende iteration auf den Master branchen. 
Der Master ist immer sauberzuhalten mit einer aktuellen lauffähigen Version. Pro Iteration wird ein Brunch erstellt. Für Lokale hacks sind selbstverständlich eigene Branches erlaubt

Maven: 
- Java Version:
Java- Installtation prüfen, mind 1.5 oder 1.6!!
> java -version

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

