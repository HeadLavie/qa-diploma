## Дипломная работа Карпенко

### Документация
[План автоматизации](https://github.com/HeadLavie/qa-diploma/blob/main/docs/Plan.md)

[Отчёт по итогам тестирования](https://github.com/HeadLavie/qa-diploma/blob/main/docs/Report.md)

[Отчет по итогам автоматизации](https://github.com/HeadLavie/qa-diploma/blob/main/docs/Summary.md)

#### Подготовка и запуск теста

1. Клонировать репозиторий
    * ```https://github.com/HeadLavie/qa-diploma```
1. Перейти в каталог со скачанным содержимым репозитория и скачать докер-контейнеры
    * ```cd ./qa-diploma/```
1. Запуск контейнеров Docker и эмулятора биллинга
    * ```docker-compose up -d --build```
1. Запуск SUT с поддержкой MySQL
   * ```java "-Dspring.datasource.url=jdbc:mysql://185.119.57.164:3306/app" -jar artifacts/aqa-shop.jar```
1. **ИЛИ** Запуск SUT с поддержкой Postgres
   * ```java "-Dspring.datasource.url=jdbc:postgresql://185.119.57.164:5432/app" -jar artifacts/aqa-shop.jar```
1. Запуск тестов с MySQL
   * ```./gradlew clean test "-Ddatasource.url=jdbc:mysql://185.119.57.164:3306/app"```
1. **ИЛИ** Запуск тестов с Postgres
   * ```./gradlew clean test "-Ddatasource.url=jdbc:postgresql://185.119.57.164:5432/app"```

#### Окончание тестов и остановка контейнеров

   * Прервать выполнение SUT по Ctrl+C 
   * Остановить контейнеры командой ```docker-compose down```

#### Параметры запуска gradlew

   *  ```db.url=jdbc:mysql://185.119.57.47:3306/app``` или ```db.url=jdbc:postgresql://185.119.57.47:5432/app```
   *  ```db.user``` -- имя пользователя базы данных. Необязательный. По-умолчанию 'app'
   * ```db.pass``` -- пароль пользователя базы данных. Необязательный. По-умолчанию 'pass'
   * ```test.host``` -- адрес тестируемого хоста. Необязательный. По-умолчанию 'http://localhost:8080'
