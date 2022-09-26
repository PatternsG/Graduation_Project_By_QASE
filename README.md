# Graduation_Project_By_QASE

###  Что такое QASE?
---
QASE.io это рабочее пространство для ручных и автоматизированных тестов. Система управления тестированием для команд разработки и контроля качества, которая помогает повысить эффективность тестирования программного обеспечения. Я написал тесты, которые проверяют функциональность этого сайта.

###  Используемые инструменты
---
В своем проекте я использовал различные фреймворки, инструменты, библиотеки и технологии, такие как:

    Java
    Maven
    TestNG
    Selenium
    
В проекте использованы такие паттерны как Page Object, Builder, Data Driven Testing. 
Отчетность осуществляется фреймворком Allure Report

###  Чек-лист
---
#### Логирование
  1.  Убедиться, что пользователь может войти в систему.
  2.  Убедиться, что пользователь может выйти из системы.
  3.  Убедитесь, что пользователь не может войти в систему с неверным паролем или данными электронной почты.
#### Тест-кейсы
  4. Убедиться, что пользователь может создавать тест-кейсы.
  5. Убедиться, что пользователь не сможеть создать теск-кейс без заполнения формы.
#### Тестовые наборы 
  6. Убедиться, что пользователь может создавать наборы тест-кейсов.
  7. Убедиться, что пользователь сможет перенести тест-кейсы в набор.
#### Тестовые прогоны
  8. Убедиться, что пользователь может создовать тестовые прогоны.
  9. Убедиться, что пользователь может запускать тестовые прогоны.
  10. Убедиться, что пользователь не сможет создать тестовый прогон без добавления тест-кейсов.
#### Дефекты
  11. Убедиться, что пользователь может создовать дефекты.
  12. Убедиться, что пользователь не сможет создать дефект без заполнения формы.

### Тестовые наборы 
---
1. Для запуска позитивных тестов введите: mvn -Dtest=PositiveTests.xml test
2. Для запуска негативных тестов введите: mvn -Dtest=NegativeTests.xml test