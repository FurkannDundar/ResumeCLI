# 📄 ResumeCLI - JSON to PDF Resume Generator

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template-blue)
![Build](https://img.shields.io/badge/Build-Maven-purple)
![License](https://img.shields.io/badge/License-MIT-yellow)

**ResumeCLI**, CV bilgilerinizi (`JSON`), bir HTML şablonu (`Thymeleaf`) kullanarak profesyonel formatta **PDF** çıktısına dönüştüren, Java tabanlı bir Komut Satırı Aracıdır (CLI).

(Kullanılan CV Taslağı: Jack's Resume)

---

## Özellikler

- İçerik tamamen `resume.json` dosyasından okunur. Tasarımı bozmadan içeriği güncelleyebilirsiniz.
- `Picocli` sayesinde terminalden -i ve -o parametreleri alınarak çalışır.
-  `OpenHTMLtoPDF` kütüphanesi ile CSS uyumlu çıktı üretir.

---

## Tech Stack

- Java, Spring Boot 
- Picocli
- Thymeleaf
- OpenHTMLtoPDF 
- Jackson Library
- Maven

---

## Mimari Akış

```
[resume.json] -> Jackson -> Resume.class -> Thymeleaf -> HTML String -> OpenHTMLtoPDF -> Resume.pdf
```
--- 

## Nasıl Çalıştırabilirim

### Projeyi İndirin

Terminalde

- git clone https://github.com/FurkannDundar/ResumeCLI
- cd ResumeCLI
- Projenin ana dizinine CV bilgilerinizi içerecek bir json dosyası ekleyin. Test için `test.json` dosyasını kullanabilirsiniz.
- mvn clean packge
- java -jar target/resumecli-0-0-1-SNAPSHOT.jar -i test.json -o resume.pdf

- `-i`: Okunacak JSON dosyasının yolu
- `-o`: Oluşturulacak PDF dosyasının yolu.
