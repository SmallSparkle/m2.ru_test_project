# Автотесты для [m2.ru](https://m2.ru/)
## Technology Stack
**Java, Gradle, Junit5, Selenide, Selenoid, Allure Reports, Allure TestOps, Telegram Bot.**
<br><br>
## Реализованы проверки:
**в реализации использованы разные подходы проектирования, позволяющие достичь разного представления в отчетах**

- [X] - Переход на страницу "Ипотека" с главной страницы
- [X] - Переход на страницу застройщика "Самолёт" с главной страницы
- [X] - Создание оффера неавторизованным пользователем
- [X] - Просмотр телефона продавца на карточке оффера
- [X] - Поиск на главной странице - покупка квартиры
- [X] - Поиск на главной странице - снять квартиру

## Добавлено видео о прохождении тестов
![video](images/video_test.gif)
<br><br>
## Screenshots
#### *Для реализации протокола Selenium задействован Selenoid:*
![screenshot](images/selenoid.png)
<br />
<br />
<br />
#### *В качестве CI системы использован Jenkins*
![screenshot](images/jenkins.png)
<br />
<br />
<br />
#### *Для построения отчетов подключен Allure Report:*
![screenshot](images/allure.png)
![screenshot](images/allure_tests.png)
![screenshot](images/allure_atach.png)
<br />
<br />
<br />
#### *В качестве системы Тест Менеджмента использован Allure TestOps:*
![screenshot](images/allure_TO_resalts.png)
![screenshot](images/allure_TO_cases.png)
![screenshot](images/allure_TO_code.png)
![screenshot](images/allure_TO_manual_vs_auto.png)
![screenshot](images/allure_TO_jenkins.png)
<br />
<br />
<br />
#### *Настроено уведомление в Telegram:*
![screenshot](images/telegram_notif.png)

