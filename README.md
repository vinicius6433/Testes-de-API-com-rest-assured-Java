# Testes de API com rest-assured utilizando Java 8
Rodando a API
O repositório consiste em uma pequena API para cadastro de customers(comprador portador de um cartão) e cards(cartões) para seus respectivos portadores. O projeto está utilizando Java 8 e usamos o maven para gerenciamento de pacotes, portanto antes de tudo você deve ter os dois instalados na sua máquina e baixar o projeto. Para rodar a api basta digitar os comandos dentro da pasta principal do projeto:

mvn clean install

e depois

mvn spring-boot:run

para rodar no eclipse é necessário seguir os seguintes passos: Ir até o POM.xml -> Run configurations -> Maven Build -> "New Configuration" -> no campo goals escrever -> mvn clean install -> acionar Run. 
