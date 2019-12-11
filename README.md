# ZPO-Thread 

### English Below

## (PL) Opis:
Program ma za zadanie (wykorzystując trzy wątki) stworzyć plik tekstowy zawierający zawartość trzech plików źródłowych w różnych kombinacjach.

## Kombinacje:
- naprzemienne wstawianie pojedynczych znaków z każdego pliku,
- naprzemienne wstawianie pojedynczych wyrazów z każdego pliku,
- naprzemienne wstawianie pojedynczych linii z każdego pliku,
- naprzemienne wstawianie całej zawartości z każdego pliku.

W przypadku zakończenia wstawiania danych z pliku, wątek zostaje zakończony.
Po zakończonej pracy na końcu stworzonego pliku wstawiane jest słowo "KONIEC". 

Interfejs graficzny wykonany z wykorzystaniem JavaFX.
Zawartość plików źródłowych to opis serialu animowanego Ghost In the Shell: Standalone Complex.

## (ENG) Description:
The goal of this program is to create a text file what will contain the content of three source files in various combinations (using threads).

## Combinations: 
- one char from each of source files by turns,
- one word from each of source files by turns,
- one line from each of source files by turns,
- whole content from each of source files by turns.

In case of file content depletion, that file's thread is killed.
When the threads' work is complete, program will append the word 'KONIEC' at the end of created file.

GUI has been made in JavaFX.
The content of source files is from the description of Ghost in the Shell: Standalone Complex animated serie.
