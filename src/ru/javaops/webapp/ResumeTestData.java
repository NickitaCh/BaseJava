package ru.javaops.webapp;

import ru.javaops.webapp.model.*;

import java.time.LocalDate;
import java.util.Arrays;


public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("Григорий Кислин");
        r.setContact(ContactType.PHONE, "+7(921) 855-0482");
        r.setContact(ContactType.SKYPE, "grigory.kislin");
        r.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        r.setContact(ContactType.LINKEDIN, "linkedin.com/in/gkislin");
        r.setContact(ContactType.GITHUB, "github.com/gkislin");
        r.setContact(ContactType.STACKOVERFLOW, "stackoverflow.com/users/548473/grigory-kislin");

        r.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        r.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры. "));
        r.setSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList(
                "С 2013 года: разработка проектов \"Разработка Web приложения\"" +
                        ",\"Java Enterprise\", \"Многомодульный maven. Многопоточность." +
                        " XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"" +
                        ". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников. ",
                "\n" + "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike." +
                        " Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk. ",
                "\n" + "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM." +
                        " Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления " +
                        "окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и " +
                        "авторизации различных ERP модулей, интеграция CIFS/SMB java сервера. ",
                "\n" + "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA," +
                        " Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга. ",
                "\n" + "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов" +
                        " (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации" +
                        "о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования" +
                        " и мониторинга системы по JMX (Jython/ Django).",
                "\n" + "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat," +
                        " Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.")));
        r.setSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce ",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle",
                "MySQL, SQLite, MS SQL, HSQLDB ",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, " +
                        "MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink)," +
                        " Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons," +
                        " Eclipse SWT, JUnit, Selenium (htmlelements). ",
                "Python: Django. ",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js ",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka ",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, " +
                        "XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2," +
                        " LDAP, OAuth1, OAuth2, JWT",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix, ",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer. ",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования ",
                "Родной русский, английский \"upper intermediate\""
        )));

        Experience javaOps = new Experience("Java Online Projects", "https://javaops.ru/", LocalDate.of(2013, 10, 1),
                LocalDate.now(), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Experience wrike = new Experience("Wrike", "https://www.wrike.com/vj/", LocalDate.of(2014, 10, 1),
                LocalDate.of(2016, 1, 1), "Старший разработчик (backend)", "Проектирование и разработка" +
                " онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis)." +
                " Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        Experience ritCenter = new Experience("RIT Center", " ", LocalDate.of(2012, 4, 1),
                LocalDate.of(2014, 10, 1), "Java архитектор", "Организация процесса разработки системы" +
                " ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных " +
                "сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN " +
                "для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        Experience luxoft = new Experience("Luxoft (Deutsche Bank)", "www.luxoft.ru", LocalDate.of(2010, 12, 1),
                LocalDate.of(2012, 4, 1), "Ведущий программист", "Участие в проекте Deutsche Bank CRM" +
                " (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация " +
                "RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC," +
                " GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        Experience yota = new Experience("Yota", "https://www.yota.ru/", LocalDate.of(2008, 6, 1),
                LocalDate.of(2010, 12, 1), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка" +
                " для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация " +
                "администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        Experience enkata = new Experience("Enkata", "https://www.pega.com/products/platform/robotic-process-automation",
                LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1), "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения " +
                        "(OLAP, Data mining).");
        Experience siemens = new Experience("Siemens AG", "https://new.siemens.com/ru/ru.html", LocalDate.of(2005, 1, 1),
                LocalDate.of(2007, 2, 1), "Разработчик ПО", "Разработка информационной модели, проектирование" +
                " интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        Experience alcatel = new Experience("Alcatel", "www.alcatel.ru", LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1), "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)");

        r.setSection(SectionType.EXPERIENCE, new Organization(Arrays.asList(javaOps, wrike, ritCenter, luxoft, yota, enkata, siemens, alcatel)));

        Experience courseraEdu = new Experience("Coursera", "https://www.coursera.org/learn/progfun1", LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1), "Functional Programming Principles in Scala\" by Martin Odersky", "");
        Experience luxofEdu = new Experience("Luxoft", "www.luxoft.ru", LocalDate.of(2011, 3, 1),
                LocalDate.of(2011, 4, 1), "Курс Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.", "");
        Experience siemensEdu = new Experience("Siemens AG", "https://new.siemens.com/ru/ru.html", LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 4, 1), "3 месяца обучения мобильным IN сетям (Берлин)", "");
        Experience alcatelEdu = new Experience("Alcatel", "www.alcatel.ru", LocalDate.of(1997, 9, 1),
                LocalDate.of(1998, 3, 1), "6 месяцев обучения цифровым телефонным сетям (Москва)", "");
        Experience universityEdu = new Experience("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "https://itmo.ru/ru/", LocalDate.of(1987, 9, 1), LocalDate.of(1996, 7, 1),
                "Программист С, С++", "");
        Experience schoolEdu = new Experience("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/",
                LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 1), "Закончил с отличием", "");

        r.setSection(SectionType.EDUCATION, new Organization(Arrays.asList(courseraEdu, luxofEdu, siemensEdu, alcatelEdu, universityEdu, schoolEdu)));

        System.out.println(r.toString());

        System.out.println(ContactType.PHONE.getTitle() + r.getContact(ContactType.PHONE));
        System.out.println(ContactType.SKYPE.getTitle() + r.getContact(ContactType.SKYPE));
        System.out.println(ContactType.EMAIL.getTitle() + r.getContact(ContactType.EMAIL));
        System.out.println(ContactType.LINKEDIN.getTitle() + r.getContact(ContactType.LINKEDIN));
        System.out.println(ContactType.GITHUB.getTitle() + r.getContact(ContactType.GITHUB));
        System.out.println(ContactType.STACKOVERFLOW.getTitle() + r.getContact(ContactType.STACKOVERFLOW));

        System.out.println(SectionType.OBJECTIVE.getTitle()+ "\n" + r.getSection(SectionType.OBJECTIVE));
        System.out.println(SectionType.PERSONAL.getTitle()+ "\n" + r.getSection(SectionType.PERSONAL));
        System.out.println(SectionType.ACHIEVEMENT.getTitle()+ "\n" + r.getSection(SectionType.ACHIEVEMENT));
        System.out.println(SectionType.QUALIFICATIONS.getTitle()+ "\n" + r.getSection(SectionType.QUALIFICATIONS));
        System.out.println(SectionType.EXPERIENCE.getTitle()+ "\n" + r.getSection(SectionType.EXPERIENCE));
        System.out.println(SectionType.EDUCATION.getTitle()+ "\n" + r.getSection(SectionType.EDUCATION));
    }
}