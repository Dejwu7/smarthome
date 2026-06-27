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

Zadanie 8. (Refaktoryzacja - Przygotowanie pod struktury): Jako że wzorce strukturalne opierają się na polimorfizmie i interfejsach. Zanim wprowadzimy nowe wzorce, musimy lekko zrefaktoryzować nasz kod, a więc:
Utwórz interfejs ManageableDevice zawierający deklaracje metod: turnOn(), turnOff() oraz getStatus(). 
Zmodyfikuj klasę SmartDevice (z poprzednich zajęć), aby implementowała ten interfejs i dostarczała podstawową implementację tych metod (np. wypisującą stan na konsolę). 
Zaktualizuj centralę HomeHub, aby od teraz przechowywała listę obiektów typu ManageableDevice.

Zadanie 9. (Wzorzec Adapter): Użytkownik zakupił stary, analogowy termostat, który posiada własne, archaiczne API i nie pasuje do naszego nowoczesnego systemu.
Zdefiniuj klasę LegacyThermostat, która nie implementuje Twojego interfejsu. Posiada ona własne metody: enableHeating(), disableHeating() oraz fetchCurrentTemperature().
Zastosuj wzorzec Adapter. Napisz klasę ThermostatAdapter, która implementuje interfejs ManageableDevice, ale wewnątrz (poprzez kompozycję) przechowuje instancję LegacyThermostat.
Zaimplementuj metody interfejsu tak, aby "tłumaczyły" żądania centrali na język starego urządzenia (np. wywołanie turnOn() w adapterze pod spodem wywoła enableHeating() na starym termostacie). Zarejestruj adapter w HomeHub.

Zadanie 10. (Wzorzec Decorator - Baza):  Tutaj chcemy mieć możliwość dynamicznego dodawania nowych ról do istniejących urządzeń (np. logowanie użycia, monitorowanie prądu) bez zmieniania kodu samej klasy SmartDevice i bez tworzenia gigantycznej hierarchii dziedziczenia. Pamiętacie? Jak zmienianie kolorków i linii w tym rysowaniu.
Zastosuj wzorzec Decorator (Dekorator). Utwórz abstrakcyjną klasę DeviceDecorator, która implementuje interfejs ManageableDevice. 
Klasa ta powinna przyjmować w konstruktorze inny obiekt typu ManageableDevice (czyli "opakowywać" go) i domyślnie delegować do niego wszystkie wywołania metod (np. metoda turnOn() w dekoratorze po prostu wywołuje turnOn() na opakowanym obiekcie).

Zadanie 11. (Wzorzec Decorator - Zastosowanie w praktyce) Wykorzystajcie bazę z Zadania 10. 
Utwórz klasę EnergyMonitoringDecorator dziedziczącą po DeviceDecorator. 
Nadpisz metodę turnOn() tak, aby oprócz włączenia urządzenia (wywołania super.turnOn()), system dodatkowo zapisywał do logów (lub po prostu wypisywał na ekran) dokładny czas uruchomienia urządzenia w celu przyszłego szacowania zużycia prądu. 
W funkcji main() utwórz standardową żarówkę (korzystając z Fabryki z Zadania 5), a następnie "opakuj" ją w EnergyMonitoringDecorator przed dodaniem do centrali HomeHub.

Zadanie 12. (Wzorzec Facade): Czyli piszemy interfejs do obsługi tego wszystkiego co robiliśmy poprzednio. Gdy w domu znajduje się 50 urządzeń, sterowanie każdym z nich z osobna (lub iterowanie po listach) staje się z perspektywy użytkownika końcowego koszmarem. Użytkownik chce po prostu "obejrzeć film" albo "iść spać". I tutaj przychodzi z pomocą fasada.
 Utwórz klasę SmartHomeFacade, która przyjmuje w konstruktorze referencję do Twojego HomeHub. Zdefiniuj w niej proste, wysokopoziomowe metody:
goodNightRoutine() – metoda ta pod spodem powinna pobrać wszystkie urządzenia z centrali, wyłączyć światła, obniżyć temperaturę na termostatach i włączyć tryb oszczędzania energii.
movieMode() – metoda wyłączająca główne oświetlenie i włączająca telewizor. Użyj Fasady w funkcji main(), aby pokazać studentom, jak drastycznie upraszcza ona interakcję z całym, złożonym podsystemem domu.

Ożywienie Systemu Smart Home (Wzorce Behawioralne) czyli nasze obiekty dostają swije zadania i odpowiedzialności.

Zadanie 13. (Wzorzec Observer - Komunikacja): Nasz dom nie jest do końca "smart", jeśli centrala nie reaguje na to, co się w nim dzieje. Zastosuj wzorzec Observer (Obserwator), aby rozwiązać problem czujników.
Zdefiniuj interfejs SensorObserver z metodą onSensorTriggered(String sensorId, String eventDetails).
Utwórz klasę MotionSensor (która może, ale nie musi dziedziczyć po SmartDevice). Klasa ta powinna posiadać listę obserwatorów oraz metody attach(SensorObserver observer) i detach(SensorObserver observer).
Napisz w MotionSensor metodę detectMotion(), która przeiteruje po liście obserwatorów i powiadomi ich o zdarzeniu.
Zmodyfikuj klasę HomeHub, aby implementowała interfejs SensorObserver. Gdy centrala otrzyma powiadomienie od czujnika ruchu, powinna wypisać na konsolę odpowiedni log (np. "ALARM: Wykryto ruch z czujnika [ID]").

Zadanie 14. (Wzorzec Strategy - Elastyczne algorytmy)Zarządzanie ogrzewaniem wymaga różnych podejść w zależności od pory dnia i obecności domowników. Użyjemy wzorca Strategy (Strategia).
Zdefiniuj interfejs HeatingStrategy z metodą calculateTargetTemperature(double currentTemp, boolean isSomeoneHome).
Zaimplementuj dwie strategie:
EcoStrategy – jeśli kogoś nie ma w domu, temperatura spada do 15°C. Jeśli ktoś jest, utrzymuje 19°C.
ComfortStrategy – niezależnie od tego, czy ktoś jest w domu, temperatura ma wynosić 22°C.
W klasie termostatu (może to być ThermostatAdapter z poprzednich zajęć) dodaj pole typu HeatingStrategy oraz metodę pozwalającą na jego zmianę w czasie działania programu (setStrategy()). Przetestuj działanie termostatu dla obu strategii.

Zadanie 15. (Wzorzec State - Maszyna stanów): Użytkownik kupił inteligentne rolety antywłamaniowe (SmartBlind), które posiadają specyficzne zachowania w zależności od tego, w jakim trybie się znajdują. Użyj wzorca State (Stan).
Zdefiniuj interfejs BlindState z metodami: open(), close() oraz stop().
Utwórz trzy stany implementujące ten interfejs: OpenedState, ClosedState oraz MovingState.
Klasa SmartBlind powinna delegować wywołania swoich metod (np. openBlind()) do aktualnie ustawionego obiektu stanu.
Logika: Wywołanie open() w ClosedState powinno zmienić stan rolety na MovingState. Wywołanie open() na rolecie, która jest już w OpenedState, nie powinno robić nic (ewentualnie wyświetlić komunikat: "Roleta już jest otwarta").

Zadanie 16. (Wzorzec Visitor - Podwójne dyspozytorstwo): Nasza centrala domowa działa świetnie, ale zaszła potrzeba wygenerowania skomplikowanego raportu diagnostycznego. Nie chcemy dodawać metody generateReport() do każdego urządzenia z osobna, łamiąc tym samym zasady SOLID i "brudząc" kod urządzeń logiką raportowania. Wykorzystaj wzorzec Visitor (Odwiedzający).
Utwórz interfejs DeviceVisitor z przeciążonymi metodami: visit(SmartBulb bulb) oraz visit(LegacyThermostat thermostat) (możesz dodać więcej w zależności od klas z poprzednich zadań).
W interfejsie głównym urządzeń (ManageableDevice) dodaj metodę accept(DeviceVisitor visitor).
W klasach konkretnych urządzeń zaimplementuj tę metodę, wywołując po prostu visitor.visit(this).

Zadanie 17. (Wzorzec Visitor - Zastosowanie): Kontynuacja poprzedniego zadania.
Zaimplementuj konkretnego odwiedzającego: klasę DiagnosticsVisitor, która wewnątrz każdej metody visit() buduje kawałek tekstu (np. pobierając specyficzne dla danego urządzenia parametry robocze) i zapisuje je w swoim wewnętrznym buforze (StringBuilder).
W klasie HomeHub dodaj metodę runDiagnostics(), która utworzy instancję DiagnosticsVisitor, przeiteruje po liście wszystkich urządzeń wywołując na nich accept(visitor), a na koniec wyświetli pełny raport sprzętowy na konsoli.
