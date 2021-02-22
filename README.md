# BaufestTests
Pruebas de automatización para prueba técnica de Baufest

# Guía de código y ejecución

## STORE Test

src/test/java/Runners/Runner.java Es el punto de entrada usado por Cucumber para ejecutar las features.
src/test/resources/features/WebPage.feature contiene el feture que ejecuta Cucumber via Runner.java.
src/test/java/stepsDefinition/WebSteps.java contiene los pasos mapeados al feature.
src/test/java/pages contiene los page-objects usado en los steps para abstraer de una forma más manejable y mantenible la interacción con la página web via Selenium WebDriver.

##### Para ejecutar, simplemente hay que entrar a la clase Runner.java y ejecutar como JUnit.

##### En el directorio /reports/Webpage-reports, una página llamada 'report.html' se genera luego de la ejecución, el cual se abre en el navegador predeterminado el reporte de las features ejecutadas, con los status de ejecución.

## SWAGGER Test

src/test/java/Runners/restRunner.java Es el punto de entrada usado por Cucumber para ejecutar las features.
src/test/resources/features/WebService.feature contiene el feture que ejecuta Cucumber via restRunner.java.
src/test/java/restStepsDefinitions/RestSteps.java contiene los pasos mapeados al feature.
src/test/java/pages contiene las clases usadas en los steps para abstraer de una forma más manejable y mantenible la interacción del servidor via JSON y RestAssured.

##### Para ejecutar, simplemente hay que entrar a la clase restRunner.java y ejecutar como JUnit.

##### En el directorio /reports/RestAPI-reports, una página llamada 'report.html' se genera luego de la ejecución, el cual se abre en el navegador predeterminado el reporte de las features ejecutadas, con los status de ejecución.


# Disclaimer

### En caso de tener problemas con las dependencies y/o las imports en las clases: 

- En el directorio /JARs se encuentran los External JARs necesarios para el build del proyecto
  1. Descargar JARs
  2. Agregar al Build Path del proyecto (Build Path > Configure Build Path > Add External JARs) las JARs descargadas
