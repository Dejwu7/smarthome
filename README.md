Zarządzanie Systemem Inteligentnego Domu (Smart Home)

Zadanie 0:
Utwórz projekt o nazwie smarthome w swoim środowisku programistycznym lub repozytorium.

Zadanie 1 (Wzorzec Singleton): 
Zdefiniuj klasę HomeHub, która będzie pełnić rolę centralnej jednostki zarządzającej wszystkimi urządzeniami w domu. Ponieważ w jednym domu powinna znajdować się tylko jedna główna centrala, upewnij się, że w całym cyklu życia programu może istnieć tylko jeden obiekt tej klasy. Wykorzystaj do tego wzorzec projektowy Singleton. Wewnątrz klasy zdefiniuj prywatną listę (List) przechowującą podłączone urządzenia (na tym etapie możesz przyjąć, że lista przechowuje typ Object).

Zadanie 2(Podstawy OOP i Hermetyzacja):
Zdefiniuj klasę SmartDevice reprezentującą inteligentne urządzenie. Klasa powinna zawierać następujące prywatne pola:
id (String) – unikalny identyfikator,
name (String) – nazwa urządzenia,
room (String) – nazwa pomieszczenia, w którym się znajduje,
macAddress (String) – adres sieciowy maszyny,
firmwareVersion (double) – wersja oprogramowania. Zapewnij odpowiednie metody dostępowe (gettery). W klasie HomeHub zmień typ listy przechowywanych obiektów z Object na SmartDevice.

Zadanie 3. (Wzorzec Builder):
Klasa SmartDevice posiada wiele parametrów, co sprawia, że tworzenie jej instancji za pomocą konstruktora staje się nieczytelne i podatne na błędy. Zastosuj wzorzec Builder (Budowniczy). Wewnątrz klasy SmartDevice utwórz publiczną, statyczną klasę Builder. Budowniczy powinien wymagać podania parametrów id oraz name w swoim konstruktorze (jako parametry niezbędne). Pozostałe właściwości (room, macAddress, firmwareVersion) powinny być opcjonalne i ustawiane za pomocą odpowiednich metod (np. withRoom(), withMacAddress(), zwracających instancję buildera). Napisz metodę build(), która zwróci gotowy obiekt SmartDevice. Zablokuj możliwość tworzenia obiektów SmartDevice z pominięciem budowniczego (np. definiując wyłącznie prywatny konstruktor w klasie SmartDevice, który jako argument przyjmuje obiekt Builder).

Zadanie 4 (Obsługa wyjątków):
Napisz klasę InvalidMacAddressException (dziedziczącą po Exception lub RuntimeException). Zmodyfikuj metodę withMacAddress() w klasie Budowniczego tak, aby rzucała ten wyjątek, jeśli przekazany adres MAC ma niewłaściwy format (np. jest krótszy niż 17 znaków lub nie zawiera dwukropków). Przechwyć ten wyjątek w funkcji main() podczas próby budowania niepoprawnego urządzenia i wyświetl stosowny komunikat błędu wykorzystując metodę getMessage().

Zadanie 5 (Wzorzec Factory):
Pewne typy urządzeń są tworzone na tyle często, że ciągłe ustawianie ich parametrów za pomocą Budowniczego staje się powtarzalne. Zastosuj wzorzec Factory (Metoda Wytwórcza / Fabryka). Utwórz klasę DeviceFactory. Zdefiniuj w niej statyczne metody wytwórcze, które wykorzystają Twojego Budowniczego do szybkiego dostarczania prekonfigurowanych obiektów:
createLivingRoomBulb(String id, String name) – zwraca urządzenie z automatycznie ustawionym pomieszczeniem na "Living Room" i domyślnym adresem MAC oraz najnowszym firmware'em.
createBasicThermostat(String id) – zwraca urządzenie z automatycznie ustawioną nazwą "Thermostat", bez przypisanego pokoju, ze starszą wersją firmware'u (np. 1.0).

Zadanie 6 (Kolekcje i Logika biznesowa):
W klasie HomeHub napisz metodę registerDevice(SmartDevice device). Metoda ta powinna dodawać przekazane urządzenie do listy w centrali. Napisz klasę DuplicateDeviceException. Zmodyfikuj metodę registerDevice() tak, aby rzucała obiekt tego wyjątku, jeżeli użytkownik próbuje zarejestrować urządzenie o takim samym id lub macAddress, jakie posiada inne urządzenie znajdujące się już w centrali.

Zadanie 7 (Interfejsy i Sortowanie):
Zmodyfikuj klasę SmartDevice tak, aby implementowała interfejs Comparable. Naturalnym porządkiem sortowania urządzeń powinien być porządek alfabetyczny względem ich nazwy (name), a w przypadku takich samych nazw – alfabetycznie względem nazwy pomieszczenia (room). Następnie w klasie HomeHub dodaj metodę getDevicesByRoom(String room), która zwróci z centrali nową listę (List) wszystkich urządzeń przypisanych do zadanego pomieszczenia. Zwracana lista musi być posortowana zgodnie z naturalnym porządkiem zdefiniowanym w klasie urządzenia.
