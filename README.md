# Testes de API com rest-assured utilizando Java 8

O repositório consiste em uma várias pequenas API para estudos e testes via swagger e sites normais. O projeto está utilizando Java 8 e usamos o maven para gerenciamento de pacotes, portanto antes de tudo você deve ter os dois instalados na sua máquina e baixar o projeto. Para rodar a api basta digitar os comandos dentro da pasta principal do projeto abaixo:


Para rodar a API que está testando pelo swagger é necessário rodar os seguintes comandos:

mvn clean install

e depois

mvn spring-boot:run

para rodar no eclipse é necessário seguir os seguintes passos: Ir até o POM.xml -> Run configurations -> Maven Build -> "New Configuration" -> no campo goals escrever -> mvn clean install -> acionar Run. 
