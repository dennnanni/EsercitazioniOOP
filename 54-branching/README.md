# Esercizio con Git, in locale

Per ogni passo,
si annoti in questo file il comando utilizzato ed il suo output,
per confrontarlo con le soluzioni.

### Si crei una nuova directory
mkdir git_test

### Si inizializzi un repository Git dentro la cartella suddetta.
cd git_test
git init

Initialized empty Git repository in C:/Users/denno/Desktop/OOP/git_test/.git/

### Si osservi lo stato del repository
git status

On branch main

No commits yet

nothing to commit (create/copy files and use "git add" to track)

### Si scriva un file `HelloWorld.java` contenente un `main` con una stampa a video e si osservi il contenuto del repository
touch HelloWorld.java
ls -la

total 4
drwxr-xr-x 1 denno 197609 0 Oct 19 21:09 ./
drwxr-xr-x 1 denno 197609 0 Oct 19 21:05 ../
drwxr-xr-x 1 denno 197609 0 Oct 19 21:08 .git/
-rw-r--r-- 1 denno 197609 0 Oct 19 21:09 HelloWorld.java

### Si aggiunga `HelloWorld.java` allo stage, e si osservi lo stato del repository
git add HelloWorld.java
git status

On branch main

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   HelloWorld.java

### Si crei il primo commit, con messaggio ragionevole. Se necessario, si configuri nome utente ed email di git usando i dati dell'account istituzionale.
git commit -m "Aggiunto HelloWorld"

### Si compili il file Java e si verifichi lo stato del repository
javac HelloWorld.java
git status

On branch main
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   HelloWorld.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        HelloWorld.class


### Si noti che c'è un file rigenerabile (`HelloWorld.class`). Si costruisca una lista di file ignorati che ignori tutti i file con estensione `.class`
echo '*.class' >> '.gitignore'

### Si osservi lo stato del repository
git status

On branch main
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   HelloWorld.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitignore

no changes added to commit (use "git add" and/or "git commit -a")

### Si crei un nuovo commit che tracci il la ignore list, aggiungendo allo stage i file necessari. Si osservi sempre lo stato del repository dopo l'esecuzione di un comando
git add .gitignore
git commit -m "Aggiunto .gitignore"

[main 77c82cd] Aggiunto .gitignore
 2 files changed, 6 insertions(+)
 create mode 100644 .gitignore

git status

On branch main
nothing to commit, working tree clean

### Si gestiscano i caratteri di fine linea in modo appropriato, creando un file `.gitattributes`
echo '* text=auto eol=lf' >> '.gitattributes'
echo '*.[bB][aA][tT] text eol=crlf' >> '.gitattributes'
echo '*.[cC][mM][dD] text eol=crlf' >> '.gitattributes'
echo '*.[pP][sS]1 text eol=crlf' >> '.gitattributes'

### Si osservi la storia del repository usando `git log --all --graph`
git log --all --graph

* commit 77c82cd72ed8358a02450bfaa7e9252737c98895 (HEAD -> main)
| Author: denise.nanni <denise.nanni1@gmail.com>
| Date:   Wed Oct 19 21:25:11 2022 +0200
|
|     Aggiunto .gitignore
|
* commit cedfee774e050e341987ae4f8378b5c6daa0d294
  Author: denise.nanni <denise.nanni1@gmail.com>
  Date:   Wed Oct 19 21:21:18 2022 +0200

      Aggiunto HelloWorld


### Da questo punto in poi, prima e dopo ogni comando, ci si assicuri di osservare lo stato del repository con `git status`

### Si crei un file Mistake.java, con contenuto arbitrario, lo si aggiunga al tracker, e si faccia un commit
echo "Contenuto arbitrario" >> Mistake.java

On branch main
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitattributes
        Mistake.java

nothing added to commit but untracked files present (use "git add" to track)

git add Mistake.java
git commit -m "Aggiunto .gitattributes e Mistake.java"

git status


### Si rinomini `Mistake.java` in `ToDelete.java`, e si faccia un commit che registra la modifica

mv Mistake.java ToDelete.java
git add ToDelete.java
git commit -m "Mistake rinominato"
git status

### Si elimini `ToDelete.java` e si registri la modifica in un commit
git rm ToDelete.java
rm ToDelete.java 
git status

### Si osservi la storia del repository e si identifichi il commit dove è stato creato `Mistake.java`. Per una visione compatta, si usi l'opzione `--oneline`
git log --all --graph --oneline

* 12e19fa (HEAD -> main) ToDelete eliminato
* 680d625 Mistake rinominato
* d811e4c Aggiunto .gitattributes e Mistake.java
* 77c82cd Aggiunto .gitignore
* cedfee7 Aggiunto HelloWorld

### Si ripristini Mistake.java dal commit identificato al passo precedente
git checkout d811e4c Mistake.java

### Si rimuova il file ripristinato e si ripulisca lo stage
git rm Mistake.java 
rm Mistake.java

### Si torni al commit precedente a quello in cui `Mistake.java` è stato creato. Si utilizzi la storia del repository se utile.
git checkout 77c82cd

### Si crei un nuovo branch di nome `experiment` e si agganci la `HEAD` al nuovo branch
git branch experiment
git checkout experiment

### Si crei un file README.md con contenuto a piacere, e si faccia un commit che lo includa
echo "contenuto a piacere" >> README.md
git add README.md
git commit -m "aggiunto readme"

### Si torni sul branch master e si elenchino i branch disponibili
git checkout master
git branch -a

### Si unisca il branch experiment al branch master (si faccia un merge in cui experiment viene messo dentro master, e non viceversa)
git merge experiment

### Si osservi la storia del repository
git log --all --graph

*   commit 56284380f4af1d157de9b2ec2262da319b4522c2 (HEAD -> main)
|\  Merge: 12e19fa bf68eff
| | Author: denise.nanni <denise.nanni1@gmail.com>
| | Date:   Wed Oct 19 21:56:25 2022 +0200
| |
| |     Merge branch 'experiment'
| |
| * commit bf68eff21b73878bbde8c26ca002ff499d9abc74 (experiment)
| | Author: denise.nanni <denise.nanni1@gmail.com>
| | Date:   Wed Oct 19 21:49:56 2022 +0200
| |
| |     Aggiunto README
| |
* | commit 12e19fa1d53c2eafcc2c480ea4b1c15946197372
| | Author: denise.nanni <denise.nanni1@gmail.com>
| | Date:   Wed Oct 19 21:35:00 2022 +0200
| |
| |     ToDelete eliminato
| |
* | commit 680d625d95e531106a0a729690407e9c9cb577d9
| | Author: denise.nanni <denise.nanni1@gmail.com>
| | Date:   Wed Oct 19 21:34:38 2022 +0200
| |
