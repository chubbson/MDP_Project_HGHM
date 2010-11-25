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

