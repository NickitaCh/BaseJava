package ru.javaops.webapp;

import ru.javaops.webapp.model.ContactType;
import ru.javaops.webapp.model.Resume;


public class ResumeTestData {
    public static void main(String[] args) {
        System.out.println(createResume("uuid1", "Григорий Кислин"));
    }

    public static Resume createResume(String uuid, String name) {
        Resume r = new Resume(uuid, name);
        r.setContact(ContactType.PHONE, "+7(921) 855-0482");
        r.setContact(ContactType.SKYPE, "grigory.kislin");
        r.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        r.setContact(ContactType.LINKEDIN, "linkedin.com/in/gkislin");
        r.setContact(ContactType.GITHUB, "github.com/gkislin");
        r.setContact(ContactType.STACKOVERFLOW, "stackoverflow.com/users/548473/grigory-kislin");
//        r.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
//        r.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры. "));
//        r.setSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList(
//                "\n" + "С 2013 года: разработка проектов \"Разработка Web приложения\"" +
//                        ",\"Java Enterprise\", \"Многомодульный maven. Многопоточность." +
//                        " XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"" +
//                        ". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников. ",
//                "\n" + "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike." +
//                        " Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk. ",
//                "\n" + "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM." +
//                        " Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления " +
//                        "окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и " +
//                        "авторизации различных ERP модулей, интеграция CIFS/SMB java сервера. ",
//                "\n" + "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA," +
//                        " Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга. ",
//                "\n" + "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов" +
//                        " (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации" +
//                        "о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования" +
//                        " и мониторинга системы по JMX (Jython/ Django).",
//                "\n" + "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat," +
//                        " Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.")));
//        r.setSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList(
//                "\n" + "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ",
//                "\n" + "Version control: Subversion, Git, Mercury, ClearCase, Perforce ",
//                "\n" + "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle",
//                "\n" + "MySQL, SQLite, MS SQL, HSQLDB ",
//                "\n" + "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
//                "\n" + "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
//                "\n" + "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, " +
//                        "MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink)," +
//                        " Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons," +
//                        " Eclipse SWT, JUnit, Selenium (htmlelements). ",
//                "\n" + "Python: Django. ",
//                "\n" + "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js ",
//                "\n" + "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka ",
//                "\n" + "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, " +
//                        "XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2," +
//                        " LDAP, OAuth1, OAuth2, JWT",
//                "\n" + "Инструменты: Maven + plugin development, Gradle, настройка Ngnix, ",
//                "\n" + "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer. ",
//                "\n" + "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования ",
//                "\n" + "Родной русский, английский \"upper intermediate\"" + "\n"
//        )));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("Java Online Projects", "https://javaops.ru/",
//                new Experience.Position(2013, Month.OCTOBER, "Автор проекта",
//                        "Создание, организация и проведение Java онлайн проектов и стажировок."))));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("Wrike", "https://www.wrike.com/vj/",
//                new Experience.Position(2014, Month.OCTOBER, 2016, Month.JANUARY, "Старший разработчик (backend)",
//                        "Проектирование и разработка онлайн платформы управления проектами Wrike " +
//                                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis)." +
//                                " Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."))));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("RIT Center", null,
//                new Experience.Position(2012, Month.APRIL, 2014, Month.OCTOBER, "Java архитектор",
//                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, " +
//                                "ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), " +
//                                "AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2," +
//                                " 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN " +
//                                "для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
//                                "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"))));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("Luxoft (Deutsche Bank)", "www.luxoft.ru",
//                new Experience.Position(2010, Month.DECEMBER, 2012, Month.APRIL, "Ведущий программист",
//                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). " +
//                                "Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и " +
//                                "анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
//                                "Commet, HTML5."))));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("Yota", "https://www.yota.ru/",
//                new Experience.Position(2008, Month.JUNE, 2010, Month.DECEMBER, "Ведущий специалист",
//                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3," +
//                                " JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга " +
//                                "фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"))));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("Siemens AG", "https://new.siemens.com/ru/ru.html",
//                new Experience.Position(2005, Month.JANUARY, 2007, Month.FEBRUARY, "Разработчик ПО",
//                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на " +
//                                "мобильной IN платформе Siemens @vantage (Java, Unix)."))));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("Alcatel", "www.alcatel.ru",
//                new Experience.Position(1997, Month.SEPTEMBER, 2005, Month.JANUARY, "Инженер по аппаратному и программному тестированию",
//                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)"))));
//        r.setSection(SectionType.EXPERIENCE, new Organization(new Experience("Alcatel", "www.alcatel.ru",
//                new Experience.Position(1997, Month.SEPTEMBER, 2005, Month.JANUARY, "Инженер по аппаратному и программному тестированию",
//                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)"))));
//        r.setSection(SectionType.EDUCATION, new Organization(new Experience("Coursera", "https://www.coursera.org/learn/progfun1",
//                new Experience.Position(2013, Month.MARCH, 2013, Month.MAY, "Functional Programming Principles" +
//                        " in Scala\" by Martin Odersky", null))));
//        r.setSection(SectionType.EDUCATION, new Organization(new Experience("Luxoft", "www.luxoft.ru",
//                new Experience.Position(2011, Month.MARCH, 2011, Month.APRIL, "Курс Объектно-ориентированный анализ ИС." +
//                        " Концептуальное моделирование на UML.", null))));
//        r.setSection(SectionType.EDUCATION, new Organization(new Experience("Siemens AG", "https://new.siemens.com/ru/ru.html",
//                new Experience.Position(2005, Month.JANUARY, 2005, Month.APRIL, "3 месяца обучения мобильным IN сетям (Берлин)",
//                        null))));
//        r.setSection(SectionType.EDUCATION, new Organization(new Experience("Alcatel", "www.alcatel.ru",
//                new Experience.Position(1997, Month.OCTOBER, 1998, Month.MARCH, "6 месяцев обучения цифровым" +
//                        " телефонным сетям (Москва)", null))));
//        r.setSection(SectionType.EDUCATION, new Organization(new Experience("Санкт-Петербургский национальный исследовательский " +
//                "университет информационных технологий, механики и оптики", "https://itmo.ru/ru/",
//                new Experience.Position(1993, Month.SEPTEMBER, 1996, Month.JULY, "Аспирантура (программист С, С++)", null),
//                new Experience.Position(1987, Month.SEPTEMBER, 1993, Month.JULY, "Инженер (программист Fortran, C)", null))));
//        r.setSection(SectionType.EDUCATION, new Organization(new Experience("Заочная физико-техническая школа при МФТИ", null,
//                new Experience.Position(1984, Month.SEPTEMBER, 1987, Month.JUNE, "Закончил с отличием", null))));
        return r;
    }
}