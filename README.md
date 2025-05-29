<h1 align="center"> Проект по автоматизации тестирования для сайта 
<a href="https://ru.wikipedia.org/"> Википедия</a> 
</h1>     


  
>Википедия является самым крупным и наиболее читаемым справочником, а также самой полной энциклопедией из когда-либо создававшихся за всю историю человечества.
____
## **Содержание:**


* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

____

<a id="tools"></a>

## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>
<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/Selenium.svg" width="50" height="50"  alt="Selenium"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>

Тесты написаны на языке <code>Java</code> с использованием фреймворка для автоматизации тестирования <code>Selenide</code>, сборщик - <code>Gradle</code>.

<code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для удаленного запуска используется <code>Selenoid</code>.

Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
Также реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.
Тесты мобильного приложения проходят на сервисе <code>BrowserStack</code>.

____

<a id="cases"></a>

## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>

-  *Проверка онбординг-экранов*
-  *Проверка размера поисковой выдачи*
-  *Соответствие поисковой выдачи запросу*


____
<a id="jenkins"></a>
## <a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/wikiMobile)</a>
### **Параметры сборки в Jenkins:**

- *tags (выбор способа запуска, по умолчанию browserstack)*


<a id="console"></a>
## Команды для запуска из терминала
___
***Запуск mobile-тестов локально из терминала:***
```bash  
gradle clean test -DdeviceHost=emulation
```


***Запуск mobile-тестов в browserstack из терминала:***
```bash  
gradle clean test -DdeviceHost=browserstack
```

___
<a id="allure"></a>
## <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/AllureStart.jpg" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/AllureSteps.jpg" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/AllureGraphs.jpg" width="850">
___
<a id="allure-testops"></a>
## Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/46583">Allure TestOps</a>
____
### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/TestopsMain.jpg" width="850">  
</p>  


### *Авто тест-кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="images/TestopsTests.jpg" width="850">  
</p>

____
<a id="telegram"></a>
## Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Telegram" src="images/TelegramNot.jpg" width="550">  
</p>

____
<a id="video"></a>
## Примеры видео выполнения тестов на BrowserStack
____
<p align="center">
<img title="Selenoid Video" src="images/9409b30f3bc148764d6b66f3e9d5a65d1b49c72d.gif" width="550" height="350"  alt="video">   
</p>
