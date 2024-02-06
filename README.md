Для запуска приложения необходимо настроить доступ к базе данных в СУБД PostgreSQL.
В файле src/resources/application.properties следует задать конфигурационные параметры:
- spring.datasource.url=jdbc:postgresql://localhost:5432/'имя_базы_данных'
- spring.datasource.username='имя_пользователя'
- spring.datasource.password='пароль_пользователя'

Например, для локального доступа с серверу БД под учетной записью базы данных 'elreg'
с паролем 'elreg' следует использовать предлагаемую в проекте конфигурацию. Для создания
в Postgres базы данных 'elreg' следует под учетной записью с правом создания баз данных
использовать следующие команды:

postgres=# CREATE USER elreg PASSWORD 'elreg';
postgres=# CREATE DATABASE elreg OWNER elreg;

В случае удаленного доступа к базе данных, необходимо корректно задать путь к базе данных в
параметре spring.datasource.url.