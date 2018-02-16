#Hells Triangle - Challenge

Sistema que calcula o máximo total de um triângulo. Recebe os parâmetros como um array
multidimensional e calcula o valor máximo total. Sistema foi desenvolvido como um 
microsserviço rest.

Como Executar:
---------------

#Requesitos:

#Maven 
Apache Maven
Versão 3.5.2 ou Superior

#Java
Java 1.8 ou Superior

#Procedimentos

1. Baixar o projeto no repositório git
2. Instalar as versões do java e do maven indicadas, e configurar as
   respectivas variáveis de ambiente.
3. Abrir o prompt de comando e navegar até a pasta raiz do projeto.
4. Executar o comando: 'mvn clean install'
5. Em seguida navegar até a pasta target e executar o comando:
   'java -jar TriangleChallenge.java'
6. Realizar chamadas http get passando os valores do triângulo no url.
   Exemplo:
		http://localhost:8080/triangle/[[6],[3,5],[9,7,1],[4,6,8,4]]
