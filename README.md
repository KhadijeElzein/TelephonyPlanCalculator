# TelephonyPlanCalculator
A aplicação completa da calculadora de plano telefônico (Interface + Back-end)

## Back-End
Para compilar e rodar o Back-End da Aplicação:
* Instale o Maven na sua máquina
  * Link com instruções de instalação:
    * No Windows: https://howtodoinjava.com/maven/how-to-install-maven-on-windows/
    * No Linux e No MacOs:https://www.baeldung.com/install-maven-on-windows-linux-mac
* Compile o programa. Para compilar:
  * No terminal, vá até a pasta telephony-plan-calculator, onde se encontra o pom.xml, e digite : 
    
    **mvn clean package**
    
    **Por exemplo, no terminal digite cd telephony-plan-calculator e após mvn clean package**
    
* Para executar os testes:
  * No terminal, estando na pasta telephony-plan-calculator, onde se encontra o pom.xml, digite : 
  
    **mvn clean test**

* Para executar o back-end:
  * No terminal, estando na pasta telephony-plan-calculator, vá até a pasta target, onde está o jar da aplicação. Digite:
    **java -jar telephony-plan-calculator.jar**
    
    **Por exemplo, no terminal e na pasta telephony-plan-calculator, digite cd target e após java-jar telephony-plan-calculator.jar**
    
## Front-End
Para compilar e rodar o Front-End da Aplicação:
* Instale o node.js e o npm
  * Link com instruções de instalação:
    * Via Package Manager: https://nodejs.org/en/download/package-manager/#debian-and-ubuntu-based-linux-distributions-enterprise-linux-fedora-and-snap-packages
    * Via instalador : https://nodejs.org/en/download/
* Para instalar todas as dependências necessárias, no terminal, vá até a pasta telephony-plan-calculator-interface. Digite:

  **npm install**
  
  **Por exemplo, no terminal, estando na pasta TelephonyPlanCalculator, digite cd telephony-plan-calculator-interface e após npm install**
  
* Para executar os testes, estando na pasta telephony-plan-calculator-interface, digite:

  **npm test**
  
* Para executar o front-end, estando na pasta telephony-plan-calculator-interface, digite (Antes de executar a aplicação todas as  dependências devem estar instaladas):

  **npm start**
  
**OBSERVAÇÃO**: 
* Para a aplicação funcionar corretamente o back-end deve estar executando quando for executar o front-end da aplicação.
* Não esqueça de instalar jdk 8 no computador, pois o back-end é executado em Java.
