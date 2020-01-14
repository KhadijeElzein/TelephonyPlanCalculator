# TelephonyPlanCalculator
A aplicação completa da calculadora de plano telefônico (Interface + Back-end)

## Back-End
Para compilar e rodar o Back-End da Aplicação:
* Instale o Maven na sua máquina
  * Link com instruções de instalação:
    * No Windows: https://howtodoinjava.com/maven/how-to-install-maven-on-windows/
    * No Linux e No MacOs:https://www.baeldung.com/install-maven-on-windows-linux-mac
* Compile o programa. Para compilar:
  * Vá até a pasta telephony-plan-calculator, onde se encontra o pom.xml, e digite : 
    
    **mvn clean package**
* Para executar os testes:
  * Vá até a pasta telephony-plan-calculator, onde se encontra o pom.xml, e digite : 
  
    **mvn clean test**
    
* Para executar o back-end:
  * Vá até a pasta telephony-plan-calculator e dentro dela vá até a pasta target,onde está o jar da aplicação. Digite:
    **java -jar telephony-plan-calculator.jar**
    
## Front-End
Para compilar e rodar o Front-End da Aplicação:
* Instale o node.js e o npm
  * Link com instruções de instalação:
    * Via Package Manager: https://nodejs.org/en/download/package-manager/#debian-and-ubuntu-based-linux-distributions-enterprise-linux-fedora-and-snap-packages
    * Via instalador : https://nodejs.org/en/download/
* Para instalar todas as dependências necessárias, vá até a pasta telephony-plan-calculator-interface. Digite:

  **npm install**
  
* Para executar os testes, vá até a pasta telephony-plan-calculator-interface. Digite:

  **npm test**
* Para executar o front-end, vá até a pasta telephony-plan-calculator-interface. Digite:

  **npm start**

**OBSERVAÇÃO**: 
* Para a aplicação funcionar corretamente o back-end deve estar executando quando for executar o front-end da aplicação.
* Não esqueça de instalar jdk 8 no computador, pois o back-end é executado em Java.
