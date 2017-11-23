# golos4j
Library for interaction with golos

# Совместимость
* Java 8+


# Свойства (настройки)
* url node по умолчанию https://ws.golos.io

# Документация библиотеки
 [JavaDocs](https://onixred.github.io/golos4j)
 [wiki](https://github.com/onixred/golos4j/wiki)

# Сборка и тест
mvn package (локально)
mvn site - генирация документации и коммит в ветку gh-pages
Для сборки и тестирования программного обеспечения используем  ресурс travis-ci.org.
https://travis-ci.org/onixred/golos4j


# Релиз новой версии
mvn deploy заливка на git-hub
отмена коммита  git reset --hard HEAD^
mvn release релиз  (mvn release:prepare и mvn release:perform) 

